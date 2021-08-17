// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf type {@code com.nkasenides.amc.proto.AMCTerrainChunkProto}
 */
public final class AMCTerrainChunkProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<com.nkasenides.amc.model.AMCTerrainChunk> , com.nkasenides.athlos.model.ITerrainChunk, 
    // @@protoc_insertion_point(message_implements:com.nkasenides.amc.proto.AMCTerrainChunkProto)
    AMCTerrainChunkProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AMCTerrainChunkProto.newBuilder() to construct.
  private AMCTerrainChunkProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AMCTerrainChunkProto() {
    id_ = "";
    worldID_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new AMCTerrainChunkProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AMCTerrainChunkProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            worldID_ = s;
            break;
          }
          case 26: {
            MatrixPositionProto.Builder subBuilder = null;
            if (position_ != null) {
              subBuilder = position_.toBuilder();
            }
            position_ = input.readMessage(MatrixPositionProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(position_);
              position_ = subBuilder.buildPartial();
            }

            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              cells_ = com.google.protobuf.MapField.newMapField(
                  CellsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<String, AMCTerrainCellProto>
            cells__ = input.readMessage(
                CellsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            cells_.getMutableMap().put(
                cells__.getKey(), cells__.getValue());
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return AMCProto.internal_static_com_nkasenides_amc_proto_AMCTerrainChunkProto_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 4:
        return internalGetCells();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_com_nkasenides_amc_proto_AMCTerrainChunkProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            AMCTerrainChunkProto.class, Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private volatile Object id_;
  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  @Override
  public String getId() {
    Object ref = id_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  @Override
  public com.google.protobuf.ByteString
      getIdBytes() {
    Object ref = id_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int WORLDID_FIELD_NUMBER = 2;
  private volatile Object worldID_;
  /**
   * <code>string worldID = 2;</code>
   * @return The worldID.
   */
  @Override
  public String getWorldID() {
    Object ref = worldID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      worldID_ = s;
      return s;
    }
  }
  /**
   * <code>string worldID = 2;</code>
   * @return The bytes for worldID.
   */
  @Override
  public com.google.protobuf.ByteString
      getWorldIDBytes() {
    Object ref = worldID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      worldID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int POSITION_FIELD_NUMBER = 3;
  private MatrixPositionProto position_;
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
   * @return Whether the position field is set.
   */
  @Override
  public boolean hasPosition() {
    return position_ != null;
  }
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
   * @return The position.
   */
  @Override
  public MatrixPositionProto getPosition() {
    return position_ == null ? MatrixPositionProto.getDefaultInstance() : position_;
  }
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
   */
  @Override
  public MatrixPositionProtoOrBuilder getPositionOrBuilder() {
    return getPosition();
  }

  public static final int CELLS_FIELD_NUMBER = 4;
  private static final class CellsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        String, AMCTerrainCellProto> defaultEntry =
            com.google.protobuf.MapEntry
            .<String, AMCTerrainCellProto>newDefaultInstance(
                AMCProto.internal_static_com_nkasenides_amc_proto_AMCTerrainChunkProto_CellsEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                AMCTerrainCellProto.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      String, AMCTerrainCellProto> cells_;
  private com.google.protobuf.MapField<String, AMCTerrainCellProto>
  internalGetCells() {
    if (cells_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          CellsDefaultEntryHolder.defaultEntry);
    }
    return cells_;
  }

  public int getCellsCount() {
    return internalGetCells().getMap().size();
  }
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
   */

  @Override
  public boolean containsCells(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    return internalGetCells().getMap().containsKey(key);
  }
  /**
   * Use {@link #getCellsMap()} instead.
   */
  @Override
  @Deprecated
  public java.util.Map<String, AMCTerrainCellProto> getCells() {
    return getCellsMap();
  }
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
   */
  @Override

  public java.util.Map<String, AMCTerrainCellProto> getCellsMap() {
    return internalGetCells().getMap();
  }
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
   */
  @Override

  public AMCTerrainCellProto getCellsOrDefault(
      String key,
      AMCTerrainCellProto defaultValue) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, AMCTerrainCellProto> map =
        internalGetCells().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
   */
  @Override

  public AMCTerrainCellProto getCellsOrThrow(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, AMCTerrainCellProto> map =
        internalGetCells().getMap();
    if (!map.containsKey(key)) {
      throw new IllegalArgumentException();
    }
    return map.get(key);
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
    }
    if (!getWorldIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, worldID_);
    }
    if (position_ != null) {
      output.writeMessage(3, getPosition());
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetCells(),
        CellsDefaultEntryHolder.defaultEntry,
        4);
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
    }
    if (!getWorldIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, worldID_);
    }
    if (position_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getPosition());
    }
    for (java.util.Map.Entry<String, AMCTerrainCellProto> entry
         : internalGetCells().getMap().entrySet()) {
      com.google.protobuf.MapEntry<String, AMCTerrainCellProto>
      cells__ = CellsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, cells__);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof AMCTerrainChunkProto)) {
      return super.equals(obj);
    }
    AMCTerrainChunkProto other = (AMCTerrainChunkProto) obj;

    if (!getId()
        .equals(other.getId())) return false;
    if (!getWorldID()
        .equals(other.getWorldID())) return false;
    if (hasPosition() != other.hasPosition()) return false;
    if (hasPosition()) {
      if (!getPosition()
          .equals(other.getPosition())) return false;
    }
    if (!internalGetCells().equals(
        other.internalGetCells())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + WORLDID_FIELD_NUMBER;
    hash = (53 * hash) + getWorldID().hashCode();
    if (hasPosition()) {
      hash = (37 * hash) + POSITION_FIELD_NUMBER;
      hash = (53 * hash) + getPosition().hashCode();
    }
    if (!internalGetCells().getMap().isEmpty()) {
      hash = (37 * hash) + CELLS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetCells().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static AMCTerrainChunkProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AMCTerrainChunkProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AMCTerrainChunkProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AMCTerrainChunkProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AMCTerrainChunkProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AMCTerrainChunkProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AMCTerrainChunkProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AMCTerrainChunkProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static AMCTerrainChunkProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static AMCTerrainChunkProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static AMCTerrainChunkProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AMCTerrainChunkProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(AMCTerrainChunkProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.nkasenides.amc.proto.AMCTerrainChunkProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements com.nkasenides.athlos.model.ITerrainChunk, com.nkasenides.athlos.proto.Modelable<com.nkasenides.amc.model.AMCTerrainChunk>, 
      // @@protoc_insertion_point(builder_implements:com.nkasenides.amc.proto.AMCTerrainChunkProto)
      AMCTerrainChunkProtoOrBuilder {    @Override
    public com.nkasenides.amc.model.AMCTerrainChunk toObject() {    
        com.nkasenides.amc.model.AMCTerrainChunk item = new com.nkasenides.amc.model.AMCTerrainChunk();        
        item.setPosition(getPosition().toObject());        
        return item;        
    }    
    

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_AMCTerrainChunkProto_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 4:
          return internalGetCells();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 4:
          return internalGetMutableCells();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_AMCTerrainChunkProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AMCTerrainChunkProto.class, Builder.class);
    }

    // Construct using com.nkasenides.amc.proto.AMCTerrainChunkProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      id_ = "";

      worldID_ = "";

      if (positionBuilder_ == null) {
        position_ = null;
      } else {
        position_ = null;
        positionBuilder_ = null;
      }
      internalGetMutableCells().clear();
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_AMCTerrainChunkProto_descriptor;
    }

    @Override
    public AMCTerrainChunkProto getDefaultInstanceForType() {
      return AMCTerrainChunkProto.getDefaultInstance();
    }

    @Override
    public AMCTerrainChunkProto build() {
      AMCTerrainChunkProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public AMCTerrainChunkProto buildPartial() {
      AMCTerrainChunkProto result = new AMCTerrainChunkProto(this);
      int from_bitField0_ = bitField0_;
      result.id_ = id_;
      result.worldID_ = worldID_;
      if (positionBuilder_ == null) {
        result.position_ = position_;
      } else {
        result.position_ = positionBuilder_.build();
      }
      result.cells_ = internalGetCells();
      result.cells_.makeImmutable();
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof AMCTerrainChunkProto) {
        return mergeFrom((AMCTerrainChunkProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(AMCTerrainChunkProto other) {
      if (other == AMCTerrainChunkProto.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (!other.getWorldID().isEmpty()) {
        worldID_ = other.worldID_;
        onChanged();
      }
      if (other.hasPosition()) {
        mergePosition(other.getPosition());
      }
      internalGetMutableCells().mergeFrom(
          other.internalGetCells());
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      AMCTerrainChunkProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (AMCTerrainChunkProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private Object id_ = "";
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    public String getId() {
      Object ref = id_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private Object worldID_ = "";
    /**
     * <code>string worldID = 2;</code>
     * @return The worldID.
     */
    public String getWorldID() {
      Object ref = worldID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        worldID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string worldID = 2;</code>
     * @return The bytes for worldID.
     */
    public com.google.protobuf.ByteString
        getWorldIDBytes() {
      Object ref = worldID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        worldID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string worldID = 2;</code>
     * @param value The worldID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      worldID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string worldID = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearWorldID() {
      
      worldID_ = getDefaultInstance().getWorldID();
      onChanged();
      return this;
    }
    /**
     * <code>string worldID = 2;</code>
     * @param value The bytes for worldID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      worldID_ = value;
      onChanged();
      return this;
    }

    private MatrixPositionProto position_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder> positionBuilder_;
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     * @return Whether the position field is set.
     */
    public boolean hasPosition() {
      return positionBuilder_ != null || position_ != null;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     * @return The position.
     */
    public MatrixPositionProto getPosition() {
      if (positionBuilder_ == null) {
        return position_ == null ? MatrixPositionProto.getDefaultInstance() : position_;
      } else {
        return positionBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     */
    public Builder setPosition(MatrixPositionProto value) {
      if (positionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        position_ = value;
        onChanged();
      } else {
        positionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     */
    public Builder setPosition(
        MatrixPositionProto.Builder builderForValue) {
      if (positionBuilder_ == null) {
        position_ = builderForValue.build();
        onChanged();
      } else {
        positionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     */
    public Builder mergePosition(MatrixPositionProto value) {
      if (positionBuilder_ == null) {
        if (position_ != null) {
          position_ =
            MatrixPositionProto.newBuilder(position_).mergeFrom(value).buildPartial();
        } else {
          position_ = value;
        }
        onChanged();
      } else {
        positionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     */
    public Builder clearPosition() {
      if (positionBuilder_ == null) {
        position_ = null;
        onChanged();
      } else {
        position_ = null;
        positionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     */
    public MatrixPositionProto.Builder getPositionBuilder() {
      
      onChanged();
      return getPositionFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     */
    public MatrixPositionProtoOrBuilder getPositionOrBuilder() {
      if (positionBuilder_ != null) {
        return positionBuilder_.getMessageOrBuilder();
      } else {
        return position_ == null ?
            MatrixPositionProto.getDefaultInstance() : position_;
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto position = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>
        getPositionFieldBuilder() {
      if (positionBuilder_ == null) {
        positionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>(
                getPosition(),
                getParentForChildren(),
                isClean());
        position_ = null;
      }
      return positionBuilder_;
    }

    private com.google.protobuf.MapField<
        String, AMCTerrainCellProto> cells_;
    private com.google.protobuf.MapField<String, AMCTerrainCellProto>
    internalGetCells() {
      if (cells_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            CellsDefaultEntryHolder.defaultEntry);
      }
      return cells_;
    }
    private com.google.protobuf.MapField<String, AMCTerrainCellProto>
    internalGetMutableCells() {
      onChanged();;
      if (cells_ == null) {
        cells_ = com.google.protobuf.MapField.newMapField(
            CellsDefaultEntryHolder.defaultEntry);
      }
      if (!cells_.isMutable()) {
        cells_ = cells_.copy();
      }
      return cells_;
    }

    public int getCellsCount() {
      return internalGetCells().getMap().size();
    }
    /**
     * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
     */

    @Override
    public boolean containsCells(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetCells().getMap().containsKey(key);
    }
    /**
     * Use {@link #getCellsMap()} instead.
     */
    @Override
    @Deprecated
    public java.util.Map<String, AMCTerrainCellProto> getCells() {
      return getCellsMap();
    }
    /**
     * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
     */
    @Override

    public java.util.Map<String, AMCTerrainCellProto> getCellsMap() {
      return internalGetCells().getMap();
    }
    /**
     * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
     */
    @Override

    public AMCTerrainCellProto getCellsOrDefault(
        String key,
        AMCTerrainCellProto defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, AMCTerrainCellProto> map =
          internalGetCells().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
     */
    @Override

    public AMCTerrainCellProto getCellsOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, AMCTerrainCellProto> map =
          internalGetCells().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearCells() {
      internalGetMutableCells().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
     */

    public Builder removeCells(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      internalGetMutableCells().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @Deprecated
    public java.util.Map<String, AMCTerrainCellProto>
    getMutableCells() {
      return internalGetMutableCells().getMutableMap();
    }
    /**
     * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
     */
    public Builder putCells(
        String key,
        AMCTerrainCellProto value) {
      if (key == null) { throw new NullPointerException(); }
      if (value == null) { throw new NullPointerException(); }
      internalGetMutableCells().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, .com.nkasenides.amc.proto.AMCTerrainCellProto&gt; cells = 4;</code>
     */

    public Builder putAllCells(
        java.util.Map<String, AMCTerrainCellProto> values) {
      internalGetMutableCells().getMutableMap()
          .putAll(values);
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.nkasenides.amc.proto.AMCTerrainChunkProto)
  }

  // @@protoc_insertion_point(class_scope:com.nkasenides.amc.proto.AMCTerrainChunkProto)
  private static final AMCTerrainChunkProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AMCTerrainChunkProto();
  }

  public static AMCTerrainChunkProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AMCTerrainChunkProto>
      PARSER = new com.google.protobuf.AbstractParser<AMCTerrainChunkProto>() {
    @Override
    public AMCTerrainChunkProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AMCTerrainChunkProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AMCTerrainChunkProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AMCTerrainChunkProto> getParserForType() {
    return PARSER;
  }

  @Override
  public AMCTerrainChunkProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public com.nkasenides.amc.model.AMCTerrainChunk toObject() {    
        com.nkasenides.amc.model.AMCTerrainChunk item = new com.nkasenides.amc.model.AMCTerrainChunk();        
        item.setPosition(getPosition().toObject());        
        return item;        
    }    
    
}

