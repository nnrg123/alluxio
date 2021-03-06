/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio;

import alluxio.Configuration;
import alluxio.PropertyKey;
import alluxio.client.file.URIStatus;
import alluxio.wire.BlockInfo;
import alluxio.wire.FileBlockInfo;
import alluxio.wire.WorkerInfo;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.nio.file.Path;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

import javax.annotation.concurrent.ThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the file meta cache
 */
@ThreadSafe
public class MetaCache {
  private static final Logger LOG = LoggerFactory.getLogger(MetaCache.class);

  private static Path alluxioRootPath = null;
  private static int maxCachedPaths = Configuration.getInt(PropertyKey.MASTER_UFS_PATH_CACHE_CAPACITY);
  private static Map<String, MetaCacheData> fcache = new ConcurrentHashMap<String, MetaCacheData>();
  private static Map<Long, BlockInfoData> bcache = new ConcurrentHashMap<Long, BlockInfoData>();
  private static List<WorkerInfo> workerList = new ArrayList<>();
  private static long lastWorkerListAccess = 0;
  private static boolean attr_cache_enabled = true;
  private static boolean block_cache_enabled = true;
  private static boolean worker_cache_enabled = true;

  public static void setAlluxioRootPath(Path path) {
    alluxioRootPath = path;
  }

  public static void debug_meta_cache(String p) {
    if (p.startsWith("a0")) {
      MetaCache.set_attr_cache(0);
      System.out.println("Alluxio attr cache disabled.");
    } else if (p.startsWith("a1")) {
      MetaCache.set_attr_cache(1);
      System.out.println("Alluxio attr cache enabled.");
    } else if (p.startsWith("ap")) {
      MetaCache.set_attr_cache(2);
      System.out.println("Alluxio attr cache purged.");
    } else if (p.startsWith("as")) {
      System.out.println("Alluxio attr cache state:" + attr_cache_enabled);
      System.out.println("Alluxio attr cache size:" + fcache.size());
    } else if (p.startsWith("ac")) {
      p = p.substring(2);
      System.out.println("Attr cache for " + p + ":" + MetaCache.getStatus(MetaCache.resolve(p)));
    } else if (p.startsWith("b0")) {
      MetaCache.set_block_cache(0);
      System.out.println("Alluxio block cache disabled.");
    } else if (p.startsWith("b1")) {
      MetaCache.set_block_cache(1);
      System.out.println("Alluxio block cache enabled.");
    } else if (p.startsWith("bp")) {
      MetaCache.set_block_cache(2);
      System.out.println("Alluxio block cache purged.");
    } else if (p.startsWith("bs")) {
      System.out.println("Alluxio block cache state:" + block_cache_enabled);
      System.out.println("Alluxio block cache size:" + bcache.size());
    } else if (p.startsWith("bc")) {
      p = p.substring(2);
      Long l = Long.parseLong(p);
      System.out.println("Cached block for " + l + ":" + MetaCache.getBlockInfoCache(l));
    } else if (p.startsWith("w0")) {
      MetaCache.set_worker_cache(0);
      System.out.println("Alluxio worker cache disabled.");
    } else if (p.startsWith("w1")) {
      MetaCache.set_worker_cache(1);
      System.out.println("Alluxio worker cache enabled.");
    } else if (p.startsWith("wp")) {
      MetaCache.set_worker_cache(2);
      System.out.println("Alluxio worker cache purged.");
    } else if (p.startsWith("ws")) {
      System.out.println("Cached workers state:" + worker_cache_enabled);
      System.out.println("Cached workers:" + MetaCache.getWorkerInfoList());
    }
  }

  public static void set_attr_cache(int v) {
    switch (v) {
      case 0: 
        attr_cache_enabled = false; 
        fcache.clear();
        return;
      case 1: 
        attr_cache_enabled = true; 
        return;
      default: 
        fcache.clear();
    }
  }
  public static void set_block_cache(int v) {
    switch (v) {
      case 0: 
        block_cache_enabled = false;
        bcache.clear();
        return;
      case 1:
        block_cache_enabled = true;
        return;
      default:
        bcache.clear();
    }

  }
  public static void set_worker_cache(int v) {
    worker_cache_enabled = (0 == v) ? false : true;
    if (v > 1) MetaCache.invalidateWorkerInfoList();
  }

  public static void setWorkerInfoList(List<WorkerInfo> list) {
    if (!worker_cache_enabled) return;

    if (list != null) {
      synchronized (workerList) {
        workerList.clear();
        workerList.addAll(list);
      }
    }
  }

  public static List<WorkerInfo> getWorkerInfoList() {
    long now = System.currentTimeMillis(); // expire every 10s
    if (now - lastWorkerListAccess > 1000 * 300) {
      synchronized (workerList) {
        workerList.clear();
      }
    }
    lastWorkerListAccess = now;
    return workerList;
  }

  public static void invalidateWorkerInfoList() {
    synchronized (workerList) {
      workerList.clear();
    }
  }

  public static String resolve(String path) {
    if (alluxioRootPath == null) return path;
    if (path.indexOf(alluxioRootPath.toString()) == 0) return path;
    Path tpath = alluxioRootPath.resolve(path.substring(1));
    return tpath.toString();
  }

  public static URIStatus getStatus(String path) {
    path = resolve(path);
    MetaCacheData c = fcache.get(path);
    return (c != null) ? c.getStatus() : null;
  }

  private static <T> void reduceCacheSize(Map<T, ?> m) {
    List<T> ls = new ArrayList<T>(m.keySet());
    Random rd = new Random();
    int remove = maxCachedPaths / 10;   // 10% off
    for (int i = 0; i < remove; i++) {
      m.remove(ls.get(rd.nextInt(ls.size())));
    }
  }

  public static void setStatus(String path, URIStatus s) {
    if (!attr_cache_enabled || s.isFolder() || s.getBlockSizeBytes() == 0
        || s.getLength() == 0 || s.getInAlluxioPercentage() != 100) return;

    path = resolve(path);
    if (fcache.size() >= maxCachedPaths) reduceCacheSize(fcache);
    MetaCacheData c = fcache.get(path);
    if (c == null) {
      c = new MetaCacheData(path);
      fcache.put(path, c);
    }
    c.setStatus(s);
    if (s.getLength() > 0) {
      for (FileBlockInfo f: s.getFileBlockInfos()) {
        BlockInfo b = f.getBlockInfo();
        addBlockInfoCache(b.getBlockId(), b);
      }
    }
  }

  public static AlluxioURI getURI(String path) {
    path = resolve(path);
    if (fcache.size() >= maxCachedPaths) reduceCacheSize(fcache);
    MetaCacheData c = fcache.get(path); //confirm to original code logic
    if (c == null) {
      c = new MetaCacheData(path);
      fcache.put(path, c);
    }
    return c.getURI();
  }

  public static void invalidate(String path) {
    //also invalidate block belonging to the file
    path = resolve(path);
    MetaCacheData data = fcache.get(path);
    if (data != null) {
      URIStatus stat = data.getStatus();
      if (stat != null) {
        for (long blockId: stat.getBlockIds()) {
          bcache.remove(blockId);
        }
      }
    }
    fcache.remove(path);
  }

  public static void invalidatePrefix(String prefix) {
    prefix = resolve(prefix);
    Set<String> keys = fcache.keySet();
    for (String k: keys) {
      if (k.startsWith(prefix)) invalidate(k);
    }
  }

  public static void invalidateAll() {
    fcache.clear();
  }


  public static void addBlockInfoCache(long blockId, BlockInfo info) {
    if (!block_cache_enabled) return;

    if (bcache.size() >= maxCachedPaths) reduceCacheSize(bcache);
    BlockInfoData data = bcache.get(blockId);
    if (data == null) {
      data = new BlockInfoData(blockId);
      bcache.put(blockId, data);
    }
    data.setBlockInfo(info);
  }

  public static BlockInfo getBlockInfoCache(long blockId) {
    BlockInfoData b = bcache.get(blockId);
    return (b != null) ? b.getBlockInfo() : null;
  }

  public static void invalidateBlockInfoCache(long blockId) {
    bcache.remove(blockId);
  }

  public static void invalidateAllBlockInfoCache() {
    bcache.clear();
  }

  static class MetaCacheData {
    private URIStatus uriStatus;
    private AlluxioURI uri;

    public MetaCacheData(String path) {
      /*
         if (alluxioRootPath != null) {
         Path tpath = alluxioRootPath.resolve(path.substring(1));
         this.uri = new AlluxioURI(tpath.toString());
         } else {
         this.uri = new AlluxioURI(path);
         }*/
      this.uri = new AlluxioURI(path);
      this.uriStatus = null;
    }

    public URIStatus getStatus() {
      return this.uriStatus;
    }

    public void setStatus(URIStatus s) {
      this.uriStatus = s;
    }

    public AlluxioURI getURI() {
      return this.uri;
    }
  }

  static class BlockInfoData {
    Long id;
    private BlockInfo info;

    BlockInfoData(Long id) {
      this.id = id;
      this.info = null;
    }

    public void setBlockInfo(BlockInfo info) {
      this.info = info;
    }
    public BlockInfo getBlockInfo() {
      return this.info;
    }
  }
}

