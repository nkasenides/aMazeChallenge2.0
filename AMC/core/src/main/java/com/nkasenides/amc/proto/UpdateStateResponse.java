// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf type {@code com.nkasenides.amc.proto.UpdateStateResponse}
 */
public final class UpdateStateResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.nkasenides.amc.proto.UpdateStateResponse)
    UpdateStateResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateStateResponse.newBuilder() to construct.
  private UpdateStateResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateStateResponse() {
    message_ = "";
    status_ = 0;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateStateResponse();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateStateResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
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

            message_ = s;
            break;
          }
          case 18: {
            AMCStateUpdateProto.Builder subBuilder = null;
            if (stateUpdate_ != null) {
              subBuilder = stateUpdate_.toBuilder();
            }
            stateUpdate_ = input.readMessage(AMCStateUpdateProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(stateUpdate_);
              stateUpdate_ = subBuilder.buildPartial();
            }

            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            status_ = rawValue;
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
    return AMCProto.internal_static_com_nkasenides_amc_proto_UpdateStateResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_com_nkasenides_amc_proto_UpdateStateResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            UpdateStateResponse.class, Builder.class);
  }

  /**
   * Protobuf enum {@code com.nkasenides.amc.proto.UpdateStateResponse.Status}
   */
  public enum Status
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>SERVER_ERROR = 0;</code>
     */
    SERVER_ERROR(0),
    /**
     * <code>NO_SUCH_WORLD_SESSION = 1;</code>
     */
    NO_SUCH_WORLD_SESSION(1),
    /**
     * <code>INVALID_DATA = 2;</code>
     */
    INVALID_DATA(2),
    /**
     * <code>NOT_AUTHORIZED = 3;</code>
     */
    NOT_AUTHORIZED(3),
    /**
     * <code>CANNOT_COMPOSE_STATE = 4;</code>
     */
    CANNOT_COMPOSE_STATE(4),
    /**
     * <code>OK = 5;</code>
     */
    OK(5),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>SERVER_ERROR = 0;</code>
     */
    public static final int SERVER_ERROR_VALUE = 0;
    /**
     * <code>NO_SUCH_WORLD_SESSION = 1;</code>
     */
    public static final int NO_SUCH_WORLD_SESSION_VALUE = 1;
    /**
     * <code>INVALID_DATA = 2;</code>
     */
    public static final int INVALID_DATA_VALUE = 2;
    /**
     * <code>NOT_AUTHORIZED = 3;</code>
     */
    public static final int NOT_AUTHORIZED_VALUE = 3;
    /**
     * <code>CANNOT_COMPOSE_STATE = 4;</code>
     */
    public static final int CANNOT_COMPOSE_STATE_VALUE = 4;
    /**
     * <code>OK = 5;</code>
     */
    public static final int OK_VALUE = 5;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static Status valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Status forNumber(int value) {
      switch (value) {
        case 0: return SERVER_ERROR;
        case 1: return NO_SUCH_WORLD_SESSION;
        case 2: return INVALID_DATA;
        case 3: return NOT_AUTHORIZED;
        case 4: return CANNOT_COMPOSE_STATE;
        case 5: return OK;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Status>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Status> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Status>() {
            public Status findValueByNumber(int number) {
              return Status.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return UpdateStateResponse.getDescriptor().getEnumTypes().get(0);
    }

    private static final Status[] VALUES = values();

    public static Status valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Status(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.UpdateStateResponse.Status)
  }

  public static final int MESSAGE_FIELD_NUMBER = 1;
  private volatile Object message_;
  /**
   * <code>string message = 1;</code>
   * @return The message.
   */
  @Override
  public String getMessage() {
    Object ref = message_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 1;</code>
   * @return The bytes for message.
   */
  @Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    Object ref = message_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATEUPDATE_FIELD_NUMBER = 2;
  private AMCStateUpdateProto stateUpdate_;
  /**
   * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
   * @return Whether the stateUpdate field is set.
   */
  @Override
  public boolean hasStateUpdate() {
    return stateUpdate_ != null;
  }
  /**
   * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
   * @return The stateUpdate.
   */
  @Override
  public AMCStateUpdateProto getStateUpdate() {
    return stateUpdate_ == null ? AMCStateUpdateProto.getDefaultInstance() : stateUpdate_;
  }
  /**
   * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
   */
  @Override
  public AMCStateUpdateProtoOrBuilder getStateUpdateOrBuilder() {
    return getStateUpdate();
  }

  public static final int STATUS_FIELD_NUMBER = 3;
  private int status_;
  /**
   * <code>.com.nkasenides.amc.proto.UpdateStateResponse.Status status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  @Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.com.nkasenides.amc.proto.UpdateStateResponse.Status status = 3;</code>
   * @return The status.
   */
  @Override public Status getStatus() {
    @SuppressWarnings("deprecation")
    Status result = Status.valueOf(status_);
    return result == null ? Status.UNRECOGNIZED : result;
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
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, message_);
    }
    if (stateUpdate_ != null) {
      output.writeMessage(2, getStateUpdate());
    }
    if (status_ != Status.SERVER_ERROR.getNumber()) {
      output.writeEnum(3, status_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, message_);
    }
    if (stateUpdate_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getStateUpdate());
    }
    if (status_ != Status.SERVER_ERROR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, status_);
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
    if (!(obj instanceof UpdateStateResponse)) {
      return super.equals(obj);
    }
    UpdateStateResponse other = (UpdateStateResponse) obj;

    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (hasStateUpdate() != other.hasStateUpdate()) return false;
    if (hasStateUpdate()) {
      if (!getStateUpdate()
          .equals(other.getStateUpdate())) return false;
    }
    if (status_ != other.status_) return false;
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
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    if (hasStateUpdate()) {
      hash = (37 * hash) + STATEUPDATE_FIELD_NUMBER;
      hash = (53 * hash) + getStateUpdate().hashCode();
    }
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static UpdateStateResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateStateResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateStateResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateStateResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateStateResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateStateResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateStateResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UpdateStateResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static UpdateStateResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static UpdateStateResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static UpdateStateResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UpdateStateResponse parseFrom(
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
  public static Builder newBuilder(UpdateStateResponse prototype) {
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
   * Protobuf type {@code com.nkasenides.amc.proto.UpdateStateResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.nkasenides.amc.proto.UpdateStateResponse)
      UpdateStateResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_UpdateStateResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_UpdateStateResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              UpdateStateResponse.class, Builder.class);
    }

    // Construct using com.nkasenides.amc.proto.UpdateStateResponse.newBuilder()
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
      message_ = "";

      if (stateUpdateBuilder_ == null) {
        stateUpdate_ = null;
      } else {
        stateUpdate_ = null;
        stateUpdateBuilder_ = null;
      }
      status_ = 0;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_UpdateStateResponse_descriptor;
    }

    @Override
    public UpdateStateResponse getDefaultInstanceForType() {
      return UpdateStateResponse.getDefaultInstance();
    }

    @Override
    public UpdateStateResponse build() {
      UpdateStateResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public UpdateStateResponse buildPartial() {
      UpdateStateResponse result = new UpdateStateResponse(this);
      result.message_ = message_;
      if (stateUpdateBuilder_ == null) {
        result.stateUpdate_ = stateUpdate_;
      } else {
        result.stateUpdate_ = stateUpdateBuilder_.build();
      }
      result.status_ = status_;
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
      if (other instanceof UpdateStateResponse) {
        return mergeFrom((UpdateStateResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(UpdateStateResponse other) {
      if (other == UpdateStateResponse.getDefaultInstance()) return this;
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (other.hasStateUpdate()) {
        mergeStateUpdate(other.getStateUpdate());
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
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
      UpdateStateResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (UpdateStateResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object message_ = "";
    /**
     * <code>string message = 1;</code>
     * @return The message.
     */
    public String getMessage() {
      Object ref = message_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string message = 1;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 1;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 1;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private AMCStateUpdateProto stateUpdate_;
    private com.google.protobuf.SingleFieldBuilderV3<
        AMCStateUpdateProto, AMCStateUpdateProto.Builder, AMCStateUpdateProtoOrBuilder> stateUpdateBuilder_;
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     * @return Whether the stateUpdate field is set.
     */
    public boolean hasStateUpdate() {
      return stateUpdateBuilder_ != null || stateUpdate_ != null;
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     * @return The stateUpdate.
     */
    public AMCStateUpdateProto getStateUpdate() {
      if (stateUpdateBuilder_ == null) {
        return stateUpdate_ == null ? AMCStateUpdateProto.getDefaultInstance() : stateUpdate_;
      } else {
        return stateUpdateBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     */
    public Builder setStateUpdate(AMCStateUpdateProto value) {
      if (stateUpdateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        stateUpdate_ = value;
        onChanged();
      } else {
        stateUpdateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     */
    public Builder setStateUpdate(
        AMCStateUpdateProto.Builder builderForValue) {
      if (stateUpdateBuilder_ == null) {
        stateUpdate_ = builderForValue.build();
        onChanged();
      } else {
        stateUpdateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     */
    public Builder mergeStateUpdate(AMCStateUpdateProto value) {
      if (stateUpdateBuilder_ == null) {
        if (stateUpdate_ != null) {
          stateUpdate_ =
            AMCStateUpdateProto.newBuilder(stateUpdate_).mergeFrom(value).buildPartial();
        } else {
          stateUpdate_ = value;
        }
        onChanged();
      } else {
        stateUpdateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     */
    public Builder clearStateUpdate() {
      if (stateUpdateBuilder_ == null) {
        stateUpdate_ = null;
        onChanged();
      } else {
        stateUpdate_ = null;
        stateUpdateBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     */
    public AMCStateUpdateProto.Builder getStateUpdateBuilder() {
      
      onChanged();
      return getStateUpdateFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     */
    public AMCStateUpdateProtoOrBuilder getStateUpdateOrBuilder() {
      if (stateUpdateBuilder_ != null) {
        return stateUpdateBuilder_.getMessageOrBuilder();
      } else {
        return stateUpdate_ == null ?
            AMCStateUpdateProto.getDefaultInstance() : stateUpdate_;
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.AMCStateUpdateProto stateUpdate = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        AMCStateUpdateProto, AMCStateUpdateProto.Builder, AMCStateUpdateProtoOrBuilder>
        getStateUpdateFieldBuilder() {
      if (stateUpdateBuilder_ == null) {
        stateUpdateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            AMCStateUpdateProto, AMCStateUpdateProto.Builder, AMCStateUpdateProtoOrBuilder>(
                getStateUpdate(),
                getParentForChildren(),
                isClean());
        stateUpdate_ = null;
      }
      return stateUpdateBuilder_;
    }

    private int status_ = 0;
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateResponse.Status status = 3;</code>
     * @return The enum numeric value on the wire for status.
     */
    @Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateResponse.Status status = 3;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateResponse.Status status = 3;</code>
     * @return The status.
     */
    @Override
    public Status getStatus() {
      @SuppressWarnings("deprecation")
      Status result = Status.valueOf(status_);
      return result == null ? Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateResponse.Status status = 3;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateResponse.Status status = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
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


    // @@protoc_insertion_point(builder_scope:com.nkasenides.amc.proto.UpdateStateResponse)
  }

  // @@protoc_insertion_point(class_scope:com.nkasenides.amc.proto.UpdateStateResponse)
  private static final UpdateStateResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new UpdateStateResponse();
  }

  public static UpdateStateResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateStateResponse>
      PARSER = new com.google.protobuf.AbstractParser<UpdateStateResponse>() {
    @Override
    public UpdateStateResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateStateResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateStateResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<UpdateStateResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public UpdateStateResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

