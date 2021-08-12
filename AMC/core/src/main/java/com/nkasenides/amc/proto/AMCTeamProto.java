// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf type {@code com.nkasenides.amc.proto.AMCTeamProto}
 */
public final class AMCTeamProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<com.nkasenides.amc.model.AMCTeam> , com.nkasenides.athlos.model.ITeam, 
    // @@protoc_insertion_point(message_implements:com.nkasenides.amc.proto.AMCTeamProto)
    AMCTeamProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AMCTeamProto.newBuilder() to construct.
  private AMCTeamProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AMCTeamProto() {
    name_ = "";
    id_ = "";
    ownerID_ = "";
    playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AMCTeamProto();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AMCTeamProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
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
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            ownerID_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              playerIDs_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            playerIDs_.add(s);
            break;
          }
          case 40: {

            playerLimit_ = input.readUInt32();
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        playerIDs_ = playerIDs_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_AMCTeamProto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_AMCTeamProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.nkasenides.amc.proto.AMCTeamProto.class, com.nkasenides.amc.proto.AMCTeamProto.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ID_FIELD_NUMBER = 2;
  private volatile java.lang.Object id_;
  /**
   * <code>string id = 2;</code>
   * @return The id.
   */
  @java.lang.Override
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 2;</code>
   * @return The bytes for id.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OWNERID_FIELD_NUMBER = 3;
  private volatile java.lang.Object ownerID_;
  /**
   * <code>string ownerID = 3;</code>
   * @return The ownerID.
   */
  @java.lang.Override
  public java.lang.String getOwnerID() {
    java.lang.Object ref = ownerID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ownerID_ = s;
      return s;
    }
  }
  /**
   * <code>string ownerID = 3;</code>
   * @return The bytes for ownerID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOwnerIDBytes() {
    java.lang.Object ref = ownerID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ownerID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PLAYERIDS_FIELD_NUMBER = 4;
  private com.google.protobuf.LazyStringList playerIDs_;
  /**
   * <code>repeated string playerIDs = 4;</code>
   * @return A list containing the playerIDs.
   */
  public com.google.protobuf.ProtocolStringList
      getPlayerIDsList() {
    return playerIDs_;
  }
  /**
   * <code>repeated string playerIDs = 4;</code>
   * @return The count of playerIDs.
   */
  public int getPlayerIDsCount() {
    return playerIDs_.size();
  }
  /**
   * <code>repeated string playerIDs = 4;</code>
   * @param index The index of the element to return.
   * @return The playerIDs at the given index.
   */
  public java.lang.String getPlayerIDs(int index) {
    return playerIDs_.get(index);
  }
  /**
   * <code>repeated string playerIDs = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the playerIDs at the given index.
   */
  public com.google.protobuf.ByteString
      getPlayerIDsBytes(int index) {
    return playerIDs_.getByteString(index);
  }

  public static final int PLAYERLIMIT_FIELD_NUMBER = 5;
  private int playerLimit_;
  /**
   * <code>uint32 playerLimit = 5;</code>
   * @return The playerLimit.
   */
  @java.lang.Override
  public int getPlayerLimit() {
    return playerLimit_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, id_);
    }
    if (!getOwnerIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, ownerID_);
    }
    for (int i = 0; i < playerIDs_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, playerIDs_.getRaw(i));
    }
    if (playerLimit_ != 0) {
      output.writeUInt32(5, playerLimit_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, id_);
    }
    if (!getOwnerIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, ownerID_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < playerIDs_.size(); i++) {
        dataSize += computeStringSizeNoTag(playerIDs_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getPlayerIDsList().size();
    }
    if (playerLimit_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(5, playerLimit_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.nkasenides.amc.proto.AMCTeamProto)) {
      return super.equals(obj);
    }
    com.nkasenides.amc.proto.AMCTeamProto other = (com.nkasenides.amc.proto.AMCTeamProto) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (!getId()
        .equals(other.getId())) return false;
    if (!getOwnerID()
        .equals(other.getOwnerID())) return false;
    if (!getPlayerIDsList()
        .equals(other.getPlayerIDsList())) return false;
    if (getPlayerLimit()
        != other.getPlayerLimit()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + OWNERID_FIELD_NUMBER;
    hash = (53 * hash) + getOwnerID().hashCode();
    if (getPlayerIDsCount() > 0) {
      hash = (37 * hash) + PLAYERIDS_FIELD_NUMBER;
      hash = (53 * hash) + getPlayerIDsList().hashCode();
    }
    hash = (37 * hash) + PLAYERLIMIT_FIELD_NUMBER;
    hash = (53 * hash) + getPlayerLimit();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.nkasenides.amc.proto.AMCTeamProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.nkasenides.amc.proto.AMCTeamProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.nkasenides.amc.proto.AMCTeamProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements com.nkasenides.athlos.model.ITeam, com.nkasenides.athlos.proto.Modelable<com.nkasenides.amc.model.AMCTeam>, 
      // @@protoc_insertion_point(builder_implements:com.nkasenides.amc.proto.AMCTeamProto)
      com.nkasenides.amc.proto.AMCTeamProtoOrBuilder {    @java.lang.Override    
    public com.nkasenides.amc.model.AMCTeam toObject() {    
        com.nkasenides.amc.model.AMCTeam item = new com.nkasenides.amc.model.AMCTeam();        
        item.setName(getName());        
        item.setId(getId());        
        item.setOwnerID(getOwnerID());        
        java.util.ArrayList<String> playerIDsList = new java.util.ArrayList<>();        
        for (int i = 0; i < getPlayerIDsCount(); i++) {        
            playerIDsList.add(getPlayerIDs(i));            
        }        
        item.setPlayerIDs(playerIDsList);        
        item.setPlayerLimit(getPlayerLimit());        
        return item;        
    }    
    
        public java.util.List<String> getPlayerIDs() {
        return playerIDs_;
    }
    

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_AMCTeamProto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_AMCTeamProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.nkasenides.amc.proto.AMCTeamProto.class, com.nkasenides.amc.proto.AMCTeamProto.Builder.class);
    }

    // Construct using com.nkasenides.amc.proto.AMCTeamProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      name_ = "";

      id_ = "";

      ownerID_ = "";

      playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      playerLimit_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_AMCTeamProto_descriptor;
    }

    @java.lang.Override
    public com.nkasenides.amc.proto.AMCTeamProto getDefaultInstanceForType() {
      return com.nkasenides.amc.proto.AMCTeamProto.getDefaultInstance();
    }

    @java.lang.Override
    public com.nkasenides.amc.proto.AMCTeamProto build() {
      com.nkasenides.amc.proto.AMCTeamProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.nkasenides.amc.proto.AMCTeamProto buildPartial() {
      com.nkasenides.amc.proto.AMCTeamProto result = new com.nkasenides.amc.proto.AMCTeamProto(this);
      int from_bitField0_ = bitField0_;
      result.name_ = name_;
      result.id_ = id_;
      result.ownerID_ = ownerID_;
      if (((bitField0_ & 0x00000001) != 0)) {
        playerIDs_ = playerIDs_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.playerIDs_ = playerIDs_;
      result.playerLimit_ = playerLimit_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.nkasenides.amc.proto.AMCTeamProto) {
        return mergeFrom((com.nkasenides.amc.proto.AMCTeamProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.nkasenides.amc.proto.AMCTeamProto other) {
      if (other == com.nkasenides.amc.proto.AMCTeamProto.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (!other.getOwnerID().isEmpty()) {
        ownerID_ = other.ownerID_;
        onChanged();
      }
      if (!other.playerIDs_.isEmpty()) {
        if (playerIDs_.isEmpty()) {
          playerIDs_ = other.playerIDs_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensurePlayerIDsIsMutable();
          playerIDs_.addAll(other.playerIDs_);
        }
        onChanged();
      }
      if (other.getPlayerLimit() != 0) {
        setPlayerLimit(other.getPlayerLimit());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.nkasenides.amc.proto.AMCTeamProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.nkasenides.amc.proto.AMCTeamProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 1;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 2;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 2;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 2;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 2;</code>
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

    private java.lang.Object ownerID_ = "";
    /**
     * <code>string ownerID = 3;</code>
     * @return The ownerID.
     */
    public java.lang.String getOwnerID() {
      java.lang.Object ref = ownerID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ownerID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string ownerID = 3;</code>
     * @return The bytes for ownerID.
     */
    public com.google.protobuf.ByteString
        getOwnerIDBytes() {
      java.lang.Object ref = ownerID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ownerID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string ownerID = 3;</code>
     * @param value The ownerID to set.
     * @return This builder for chaining.
     */
    public Builder setOwnerID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ownerID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string ownerID = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearOwnerID() {
      
      ownerID_ = getDefaultInstance().getOwnerID();
      onChanged();
      return this;
    }
    /**
     * <code>string ownerID = 3;</code>
     * @param value The bytes for ownerID to set.
     * @return This builder for chaining.
     */
    public Builder setOwnerIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      ownerID_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensurePlayerIDsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        playerIDs_ = new com.google.protobuf.LazyStringArrayList(playerIDs_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @return A list containing the playerIDs.
     */
    public com.google.protobuf.ProtocolStringList
        getPlayerIDsList() {
      return playerIDs_.getUnmodifiableView();
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @return The count of playerIDs.
     */
    public int getPlayerIDsCount() {
      return playerIDs_.size();
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @param index The index of the element to return.
     * @return The playerIDs at the given index.
     */
    public java.lang.String getPlayerIDs(int index) {
      return playerIDs_.get(index);
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @param index The index of the value to return.
     * @return The bytes of the playerIDs at the given index.
     */
    public com.google.protobuf.ByteString
        getPlayerIDsBytes(int index) {
      return playerIDs_.getByteString(index);
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @param index The index to set the value at.
     * @param value The playerIDs to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerIDs(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePlayerIDsIsMutable();
      playerIDs_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @param value The playerIDs to add.
     * @return This builder for chaining.
     */
    public Builder addPlayerIDs(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePlayerIDsIsMutable();
      playerIDs_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @param values The playerIDs to add.
     * @return This builder for chaining.
     */
    public Builder addAllPlayerIDs(
        java.lang.Iterable<java.lang.String> values) {
      ensurePlayerIDsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, playerIDs_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlayerIDs() {
      playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 4;</code>
     * @param value The bytes of the playerIDs to add.
     * @return This builder for chaining.
     */
    public Builder addPlayerIDsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensurePlayerIDsIsMutable();
      playerIDs_.add(value);
      onChanged();
      return this;
    }

    private int playerLimit_ ;
    /**
     * <code>uint32 playerLimit = 5;</code>
     * @return The playerLimit.
     */
    @java.lang.Override
    public int getPlayerLimit() {
      return playerLimit_;
    }
    /**
     * <code>uint32 playerLimit = 5;</code>
     * @param value The playerLimit to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerLimit(int value) {
      
      playerLimit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 playerLimit = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlayerLimit() {
      
      playerLimit_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.nkasenides.amc.proto.AMCTeamProto)
  }

  // @@protoc_insertion_point(class_scope:com.nkasenides.amc.proto.AMCTeamProto)
  private static final com.nkasenides.amc.proto.AMCTeamProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.nkasenides.amc.proto.AMCTeamProto();
  }

  public static com.nkasenides.amc.proto.AMCTeamProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AMCTeamProto>
      PARSER = new com.google.protobuf.AbstractParser<AMCTeamProto>() {
    @java.lang.Override
    public AMCTeamProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AMCTeamProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AMCTeamProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AMCTeamProto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.nkasenides.amc.proto.AMCTeamProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @java.lang.Override    
    public com.nkasenides.amc.model.AMCTeam toObject() {    
        com.nkasenides.amc.model.AMCTeam item = new com.nkasenides.amc.model.AMCTeam();        
        item.setName(getName());        
        item.setId(getId());        
        item.setOwnerID(getOwnerID());        
        java.util.ArrayList<String> playerIDsList = new java.util.ArrayList<>();        
        for (int i = 0; i < getPlayerIDsCount(); i++) {        
            playerIDsList.add(getPlayerIDs(i));            
        }        
        item.setPlayerIDs(playerIDsList);        
        item.setPlayerLimit(getPlayerLimit());        
        return item;        
    }    
    
        public java.util.List<String> getPlayerIDs() {
        return playerIDs_;
    }
    
}

