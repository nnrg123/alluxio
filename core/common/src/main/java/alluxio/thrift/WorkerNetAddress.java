/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package alluxio.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Address information about workers.
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
public class WorkerNetAddress implements org.apache.thrift.TBase<WorkerNetAddress, WorkerNetAddress._Fields>, java.io.Serializable, Cloneable, Comparable<WorkerNetAddress> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WorkerNetAddress");

  private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField RPC_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("rpcPort", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField DATA_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("dataPort", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField WEB_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("webPort", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField DOMAIN_SOCKET_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("domainSocketPath", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField TIERED_IDENTITY_FIELD_DESC = new org.apache.thrift.protocol.TField("tieredIdentity", org.apache.thrift.protocol.TType.STRUCT, (short)6);
  private static final org.apache.thrift.protocol.TField ROLE_FIELD_DESC = new org.apache.thrift.protocol.TField("role", org.apache.thrift.protocol.TType.I32, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WorkerNetAddressStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WorkerNetAddressTupleSchemeFactory());
  }

  private String host; // required
  private int rpcPort; // required
  private int dataPort; // required
  private int webPort; // required
  private String domainSocketPath; // required
  private TieredIdentity tieredIdentity; // required
  private WorkerRole role; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HOST((short)1, "host"),
    RPC_PORT((short)2, "rpcPort"),
    DATA_PORT((short)3, "dataPort"),
    WEB_PORT((short)4, "webPort"),
    DOMAIN_SOCKET_PATH((short)5, "domainSocketPath"),
    TIERED_IDENTITY((short)6, "tieredIdentity"),
    /**
     * 
     * @see WorkerRole
     */
    ROLE((short)7, "role");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // HOST
          return HOST;
        case 2: // RPC_PORT
          return RPC_PORT;
        case 3: // DATA_PORT
          return DATA_PORT;
        case 4: // WEB_PORT
          return WEB_PORT;
        case 5: // DOMAIN_SOCKET_PATH
          return DOMAIN_SOCKET_PATH;
        case 6: // TIERED_IDENTITY
          return TIERED_IDENTITY;
        case 7: // ROLE
          return ROLE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __RPCPORT_ISSET_ID = 0;
  private static final int __DATAPORT_ISSET_ID = 1;
  private static final int __WEBPORT_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RPC_PORT, new org.apache.thrift.meta_data.FieldMetaData("rpcPort", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DATA_PORT, new org.apache.thrift.meta_data.FieldMetaData("dataPort", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.WEB_PORT, new org.apache.thrift.meta_data.FieldMetaData("webPort", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DOMAIN_SOCKET_PATH, new org.apache.thrift.meta_data.FieldMetaData("domainSocketPath", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TIERED_IDENTITY, new org.apache.thrift.meta_data.FieldMetaData("tieredIdentity", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TieredIdentity.class)));
    tmpMap.put(_Fields.ROLE, new org.apache.thrift.meta_data.FieldMetaData("role", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, WorkerRole.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WorkerNetAddress.class, metaDataMap);
  }

  public WorkerNetAddress() {
  }

  public WorkerNetAddress(
    String host,
    int rpcPort,
    int dataPort,
    int webPort,
    String domainSocketPath,
    TieredIdentity tieredIdentity,
    WorkerRole role)
  {
    this();
    this.host = host;
    this.rpcPort = rpcPort;
    setRpcPortIsSet(true);
    this.dataPort = dataPort;
    setDataPortIsSet(true);
    this.webPort = webPort;
    setWebPortIsSet(true);
    this.domainSocketPath = domainSocketPath;
    this.tieredIdentity = tieredIdentity;
    this.role = role;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WorkerNetAddress(WorkerNetAddress other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHost()) {
      this.host = other.host;
    }
    this.rpcPort = other.rpcPort;
    this.dataPort = other.dataPort;
    this.webPort = other.webPort;
    if (other.isSetDomainSocketPath()) {
      this.domainSocketPath = other.domainSocketPath;
    }
    if (other.isSetTieredIdentity()) {
      this.tieredIdentity = new TieredIdentity(other.tieredIdentity);
    }
    if (other.isSetRole()) {
      this.role = other.role;
    }
  }

  public WorkerNetAddress deepCopy() {
    return new WorkerNetAddress(this);
  }

  @Override
  public void clear() {
    this.host = null;
    setRpcPortIsSet(false);
    this.rpcPort = 0;
    setDataPortIsSet(false);
    this.dataPort = 0;
    setWebPortIsSet(false);
    this.webPort = 0;
    this.domainSocketPath = null;
    this.tieredIdentity = null;
    this.role = null;
  }

  public String getHost() {
    return this.host;
  }

  public WorkerNetAddress setHost(String host) {
    this.host = host;
    return this;
  }

  public void unsetHost() {
    this.host = null;
  }

  /** Returns true if field host is set (has been assigned a value) and false otherwise */
  public boolean isSetHost() {
    return this.host != null;
  }

  public void setHostIsSet(boolean value) {
    if (!value) {
      this.host = null;
    }
  }

  public int getRpcPort() {
    return this.rpcPort;
  }

  public WorkerNetAddress setRpcPort(int rpcPort) {
    this.rpcPort = rpcPort;
    setRpcPortIsSet(true);
    return this;
  }

  public void unsetRpcPort() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __RPCPORT_ISSET_ID);
  }

  /** Returns true if field rpcPort is set (has been assigned a value) and false otherwise */
  public boolean isSetRpcPort() {
    return EncodingUtils.testBit(__isset_bitfield, __RPCPORT_ISSET_ID);
  }

  public void setRpcPortIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __RPCPORT_ISSET_ID, value);
  }

  public int getDataPort() {
    return this.dataPort;
  }

  public WorkerNetAddress setDataPort(int dataPort) {
    this.dataPort = dataPort;
    setDataPortIsSet(true);
    return this;
  }

  public void unsetDataPort() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DATAPORT_ISSET_ID);
  }

  /** Returns true if field dataPort is set (has been assigned a value) and false otherwise */
  public boolean isSetDataPort() {
    return EncodingUtils.testBit(__isset_bitfield, __DATAPORT_ISSET_ID);
  }

  public void setDataPortIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DATAPORT_ISSET_ID, value);
  }

  public int getWebPort() {
    return this.webPort;
  }

  public WorkerNetAddress setWebPort(int webPort) {
    this.webPort = webPort;
    setWebPortIsSet(true);
    return this;
  }

  public void unsetWebPort() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WEBPORT_ISSET_ID);
  }

  /** Returns true if field webPort is set (has been assigned a value) and false otherwise */
  public boolean isSetWebPort() {
    return EncodingUtils.testBit(__isset_bitfield, __WEBPORT_ISSET_ID);
  }

  public void setWebPortIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WEBPORT_ISSET_ID, value);
  }

  public String getDomainSocketPath() {
    return this.domainSocketPath;
  }

  public WorkerNetAddress setDomainSocketPath(String domainSocketPath) {
    this.domainSocketPath = domainSocketPath;
    return this;
  }

  public void unsetDomainSocketPath() {
    this.domainSocketPath = null;
  }

  /** Returns true if field domainSocketPath is set (has been assigned a value) and false otherwise */
  public boolean isSetDomainSocketPath() {
    return this.domainSocketPath != null;
  }

  public void setDomainSocketPathIsSet(boolean value) {
    if (!value) {
      this.domainSocketPath = null;
    }
  }

  public TieredIdentity getTieredIdentity() {
    return this.tieredIdentity;
  }

  public WorkerNetAddress setTieredIdentity(TieredIdentity tieredIdentity) {
    this.tieredIdentity = tieredIdentity;
    return this;
  }

  public void unsetTieredIdentity() {
    this.tieredIdentity = null;
  }

  /** Returns true if field tieredIdentity is set (has been assigned a value) and false otherwise */
  public boolean isSetTieredIdentity() {
    return this.tieredIdentity != null;
  }

  public void setTieredIdentityIsSet(boolean value) {
    if (!value) {
      this.tieredIdentity = null;
    }
  }

  /**
   * 
   * @see WorkerRole
   */
  public WorkerRole getRole() {
    return this.role;
  }

  /**
   * 
   * @see WorkerRole
   */
  public WorkerNetAddress setRole(WorkerRole role) {
    this.role = role;
    return this;
  }

  public void unsetRole() {
    this.role = null;
  }

  /** Returns true if field role is set (has been assigned a value) and false otherwise */
  public boolean isSetRole() {
    return this.role != null;
  }

  public void setRoleIsSet(boolean value) {
    if (!value) {
      this.role = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case HOST:
      if (value == null) {
        unsetHost();
      } else {
        setHost((String)value);
      }
      break;

    case RPC_PORT:
      if (value == null) {
        unsetRpcPort();
      } else {
        setRpcPort((Integer)value);
      }
      break;

    case DATA_PORT:
      if (value == null) {
        unsetDataPort();
      } else {
        setDataPort((Integer)value);
      }
      break;

    case WEB_PORT:
      if (value == null) {
        unsetWebPort();
      } else {
        setWebPort((Integer)value);
      }
      break;

    case DOMAIN_SOCKET_PATH:
      if (value == null) {
        unsetDomainSocketPath();
      } else {
        setDomainSocketPath((String)value);
      }
      break;

    case TIERED_IDENTITY:
      if (value == null) {
        unsetTieredIdentity();
      } else {
        setTieredIdentity((TieredIdentity)value);
      }
      break;

    case ROLE:
      if (value == null) {
        unsetRole();
      } else {
        setRole((WorkerRole)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HOST:
      return getHost();

    case RPC_PORT:
      return getRpcPort();

    case DATA_PORT:
      return getDataPort();

    case WEB_PORT:
      return getWebPort();

    case DOMAIN_SOCKET_PATH:
      return getDomainSocketPath();

    case TIERED_IDENTITY:
      return getTieredIdentity();

    case ROLE:
      return getRole();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case HOST:
      return isSetHost();
    case RPC_PORT:
      return isSetRpcPort();
    case DATA_PORT:
      return isSetDataPort();
    case WEB_PORT:
      return isSetWebPort();
    case DOMAIN_SOCKET_PATH:
      return isSetDomainSocketPath();
    case TIERED_IDENTITY:
      return isSetTieredIdentity();
    case ROLE:
      return isSetRole();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WorkerNetAddress)
      return this.equals((WorkerNetAddress)that);
    return false;
  }

  public boolean equals(WorkerNetAddress that) {
    if (that == null)
      return false;

    boolean this_present_host = true && this.isSetHost();
    boolean that_present_host = true && that.isSetHost();
    if (this_present_host || that_present_host) {
      if (!(this_present_host && that_present_host))
        return false;
      if (!this.host.equals(that.host))
        return false;
    }

    boolean this_present_rpcPort = true;
    boolean that_present_rpcPort = true;
    if (this_present_rpcPort || that_present_rpcPort) {
      if (!(this_present_rpcPort && that_present_rpcPort))
        return false;
      if (this.rpcPort != that.rpcPort)
        return false;
    }

    boolean this_present_dataPort = true;
    boolean that_present_dataPort = true;
    if (this_present_dataPort || that_present_dataPort) {
      if (!(this_present_dataPort && that_present_dataPort))
        return false;
      if (this.dataPort != that.dataPort)
        return false;
    }

    boolean this_present_webPort = true;
    boolean that_present_webPort = true;
    if (this_present_webPort || that_present_webPort) {
      if (!(this_present_webPort && that_present_webPort))
        return false;
      if (this.webPort != that.webPort)
        return false;
    }

    boolean this_present_domainSocketPath = true && this.isSetDomainSocketPath();
    boolean that_present_domainSocketPath = true && that.isSetDomainSocketPath();
    if (this_present_domainSocketPath || that_present_domainSocketPath) {
      if (!(this_present_domainSocketPath && that_present_domainSocketPath))
        return false;
      if (!this.domainSocketPath.equals(that.domainSocketPath))
        return false;
    }

    boolean this_present_tieredIdentity = true && this.isSetTieredIdentity();
    boolean that_present_tieredIdentity = true && that.isSetTieredIdentity();
    if (this_present_tieredIdentity || that_present_tieredIdentity) {
      if (!(this_present_tieredIdentity && that_present_tieredIdentity))
        return false;
      if (!this.tieredIdentity.equals(that.tieredIdentity))
        return false;
    }

    boolean this_present_role = true && this.isSetRole();
    boolean that_present_role = true && that.isSetRole();
    if (this_present_role || that_present_role) {
      if (!(this_present_role && that_present_role))
        return false;
      if (!this.role.equals(that.role))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_host = true && (isSetHost());
    list.add(present_host);
    if (present_host)
      list.add(host);

    boolean present_rpcPort = true;
    list.add(present_rpcPort);
    if (present_rpcPort)
      list.add(rpcPort);

    boolean present_dataPort = true;
    list.add(present_dataPort);
    if (present_dataPort)
      list.add(dataPort);

    boolean present_webPort = true;
    list.add(present_webPort);
    if (present_webPort)
      list.add(webPort);

    boolean present_domainSocketPath = true && (isSetDomainSocketPath());
    list.add(present_domainSocketPath);
    if (present_domainSocketPath)
      list.add(domainSocketPath);

    boolean present_tieredIdentity = true && (isSetTieredIdentity());
    list.add(present_tieredIdentity);
    if (present_tieredIdentity)
      list.add(tieredIdentity);

    boolean present_role = true && (isSetRole());
    list.add(present_role);
    if (present_role)
      list.add(role.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(WorkerNetAddress other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetHost()).compareTo(other.isSetHost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, other.host);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRpcPort()).compareTo(other.isSetRpcPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRpcPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rpcPort, other.rpcPort);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDataPort()).compareTo(other.isSetDataPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDataPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dataPort, other.dataPort);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWebPort()).compareTo(other.isSetWebPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWebPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.webPort, other.webPort);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDomainSocketPath()).compareTo(other.isSetDomainSocketPath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDomainSocketPath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.domainSocketPath, other.domainSocketPath);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTieredIdentity()).compareTo(other.isSetTieredIdentity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTieredIdentity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tieredIdentity, other.tieredIdentity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRole()).compareTo(other.isSetRole());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRole()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.role, other.role);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("WorkerNetAddress(");
    boolean first = true;

    sb.append("host:");
    if (this.host == null) {
      sb.append("null");
    } else {
      sb.append(this.host);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("rpcPort:");
    sb.append(this.rpcPort);
    first = false;
    if (!first) sb.append(", ");
    sb.append("dataPort:");
    sb.append(this.dataPort);
    first = false;
    if (!first) sb.append(", ");
    sb.append("webPort:");
    sb.append(this.webPort);
    first = false;
    if (!first) sb.append(", ");
    sb.append("domainSocketPath:");
    if (this.domainSocketPath == null) {
      sb.append("null");
    } else {
      sb.append(this.domainSocketPath);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tieredIdentity:");
    if (this.tieredIdentity == null) {
      sb.append("null");
    } else {
      sb.append(this.tieredIdentity);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("role:");
    if (this.role == null) {
      sb.append("null");
    } else {
      sb.append(this.role);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (tieredIdentity != null) {
      tieredIdentity.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WorkerNetAddressStandardSchemeFactory implements SchemeFactory {
    public WorkerNetAddressStandardScheme getScheme() {
      return new WorkerNetAddressStandardScheme();
    }
  }

  private static class WorkerNetAddressStandardScheme extends StandardScheme<WorkerNetAddress> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WorkerNetAddress struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // HOST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.host = iprot.readString();
              struct.setHostIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RPC_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.rpcPort = iprot.readI32();
              struct.setRpcPortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DATA_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.dataPort = iprot.readI32();
              struct.setDataPortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // WEB_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.webPort = iprot.readI32();
              struct.setWebPortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DOMAIN_SOCKET_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.domainSocketPath = iprot.readString();
              struct.setDomainSocketPathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TIERED_IDENTITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.tieredIdentity = new TieredIdentity();
              struct.tieredIdentity.read(iprot);
              struct.setTieredIdentityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // ROLE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.role = alluxio.thrift.WorkerRole.findByValue(iprot.readI32());
              struct.setRoleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WorkerNetAddress struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.host != null) {
        oprot.writeFieldBegin(HOST_FIELD_DESC);
        oprot.writeString(struct.host);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(RPC_PORT_FIELD_DESC);
      oprot.writeI32(struct.rpcPort);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DATA_PORT_FIELD_DESC);
      oprot.writeI32(struct.dataPort);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(WEB_PORT_FIELD_DESC);
      oprot.writeI32(struct.webPort);
      oprot.writeFieldEnd();
      if (struct.domainSocketPath != null) {
        oprot.writeFieldBegin(DOMAIN_SOCKET_PATH_FIELD_DESC);
        oprot.writeString(struct.domainSocketPath);
        oprot.writeFieldEnd();
      }
      if (struct.tieredIdentity != null) {
        oprot.writeFieldBegin(TIERED_IDENTITY_FIELD_DESC);
        struct.tieredIdentity.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.role != null) {
        oprot.writeFieldBegin(ROLE_FIELD_DESC);
        oprot.writeI32(struct.role.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WorkerNetAddressTupleSchemeFactory implements SchemeFactory {
    public WorkerNetAddressTupleScheme getScheme() {
      return new WorkerNetAddressTupleScheme();
    }
  }

  private static class WorkerNetAddressTupleScheme extends TupleScheme<WorkerNetAddress> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WorkerNetAddress struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHost()) {
        optionals.set(0);
      }
      if (struct.isSetRpcPort()) {
        optionals.set(1);
      }
      if (struct.isSetDataPort()) {
        optionals.set(2);
      }
      if (struct.isSetWebPort()) {
        optionals.set(3);
      }
      if (struct.isSetDomainSocketPath()) {
        optionals.set(4);
      }
      if (struct.isSetTieredIdentity()) {
        optionals.set(5);
      }
      if (struct.isSetRole()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetHost()) {
        oprot.writeString(struct.host);
      }
      if (struct.isSetRpcPort()) {
        oprot.writeI32(struct.rpcPort);
      }
      if (struct.isSetDataPort()) {
        oprot.writeI32(struct.dataPort);
      }
      if (struct.isSetWebPort()) {
        oprot.writeI32(struct.webPort);
      }
      if (struct.isSetDomainSocketPath()) {
        oprot.writeString(struct.domainSocketPath);
      }
      if (struct.isSetTieredIdentity()) {
        struct.tieredIdentity.write(oprot);
      }
      if (struct.isSetRole()) {
        oprot.writeI32(struct.role.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WorkerNetAddress struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.host = iprot.readString();
        struct.setHostIsSet(true);
      }
      if (incoming.get(1)) {
        struct.rpcPort = iprot.readI32();
        struct.setRpcPortIsSet(true);
      }
      if (incoming.get(2)) {
        struct.dataPort = iprot.readI32();
        struct.setDataPortIsSet(true);
      }
      if (incoming.get(3)) {
        struct.webPort = iprot.readI32();
        struct.setWebPortIsSet(true);
      }
      if (incoming.get(4)) {
        struct.domainSocketPath = iprot.readString();
        struct.setDomainSocketPathIsSet(true);
      }
      if (incoming.get(5)) {
        struct.tieredIdentity = new TieredIdentity();
        struct.tieredIdentity.read(iprot);
        struct.setTieredIdentityIsSet(true);
      }
      if (incoming.get(6)) {
        struct.role = alluxio.thrift.WorkerRole.findByValue(iprot.readI32());
        struct.setRoleIsSet(true);
      }
    }
  }

}

