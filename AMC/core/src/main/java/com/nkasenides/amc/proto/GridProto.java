// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf type {@code com.nkasenides.amc.proto.GridProto}
 */
public final class GridProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<com.nkasenides.amc.model.Grid> , 
    // @@protoc_insertion_point(message_implements:com.nkasenides.amc.proto.GridProto)
    GridProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GridProto.newBuilder() to construct.
  private GridProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GridProto() {
    startingDirection_ = 0;
    data_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GridProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GridProto(
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
          case 8: {
            int rawValue = input.readEnum();

            startingDirection_ = rawValue;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            data_ = s;
            break;
          }
          case 26: {
            MatrixPositionProto.Builder subBuilder = null;
            if (targetPosition_ != null) {
              subBuilder = targetPosition_.toBuilder();
            }
            targetPosition_ = input.readMessage(MatrixPositionProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(targetPosition_);
              targetPosition_ = subBuilder.buildPartial();
            }

            break;
          }
          case 32: {

            width_ = input.readInt32();
            break;
          }
          case 42: {
            MatrixPositionProto.Builder subBuilder = null;
            if (startingPosition_ != null) {
              subBuilder = startingPosition_.toBuilder();
            }
            startingPosition_ = input.readMessage(MatrixPositionProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(startingPosition_);
              startingPosition_ = subBuilder.buildPartial();
            }

            break;
          }
          case 48: {

            height_ = input.readInt32();
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
    return AMCProto.internal_static_com_nkasenides_amc_proto_GridProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_com_nkasenides_amc_proto_GridProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GridProto.class, Builder.class);
  }

  public static final int STARTINGDIRECTION_FIELD_NUMBER = 1;
  private int startingDirection_;
  /**
   * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
   * @return The enum numeric value on the wire for startingDirection.
   */
  @Override public int getStartingDirectionValue() {
    return startingDirection_;
  }
  /**
   * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
   * @return The startingDirection.
   */
  @Override public Direction4 getStartingDirection() {
    @SuppressWarnings("deprecation")
    Direction4 result = Direction4.valueOf(startingDirection_);
    return result == null ? Direction4.UNRECOGNIZED : result;
  }

  public static final int DATA_FIELD_NUMBER = 2;
  private volatile Object data_;
  /**
   * <code>string data = 2;</code>
   * @return The data.
   */
  @Override
  public String getData() {
    Object ref = data_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      data_ = s;
      return s;
    }
  }
  /**
   * <code>string data = 2;</code>
   * @return The bytes for data.
   */
  @Override
  public com.google.protobuf.ByteString
      getDataBytes() {
    Object ref = data_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      data_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TARGETPOSITION_FIELD_NUMBER = 3;
  private MatrixPositionProto targetPosition_;
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
   * @return Whether the targetPosition field is set.
   */
  @Override
  public boolean hasTargetPosition() {
    return targetPosition_ != null;
  }
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
   * @return The targetPosition.
   */
  @Override
  public MatrixPositionProto getTargetPosition() {
    return targetPosition_ == null ? MatrixPositionProto.getDefaultInstance() : targetPosition_;
  }
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
   */
  @Override
  public MatrixPositionProtoOrBuilder getTargetPositionOrBuilder() {
    return getTargetPosition();
  }

  public static final int WIDTH_FIELD_NUMBER = 4;
  private int width_;
  /**
   * <code>int32 width = 4;</code>
   * @return The width.
   */
  @Override
  public int getWidth() {
    return width_;
  }

  public static final int STARTINGPOSITION_FIELD_NUMBER = 5;
  private MatrixPositionProto startingPosition_;
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
   * @return Whether the startingPosition field is set.
   */
  @Override
  public boolean hasStartingPosition() {
    return startingPosition_ != null;
  }
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
   * @return The startingPosition.
   */
  @Override
  public MatrixPositionProto getStartingPosition() {
    return startingPosition_ == null ? MatrixPositionProto.getDefaultInstance() : startingPosition_;
  }
  /**
   * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
   */
  @Override
  public MatrixPositionProtoOrBuilder getStartingPositionOrBuilder() {
    return getStartingPosition();
  }

  public static final int HEIGHT_FIELD_NUMBER = 6;
  private int height_;
  /**
   * <code>int32 height = 6;</code>
   * @return The height.
   */
  @Override
  public int getHeight() {
    return height_;
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
    if (startingDirection_ != Direction4.NORTH.getNumber()) {
      output.writeEnum(1, startingDirection_);
    }
    if (!getDataBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, data_);
    }
    if (targetPosition_ != null) {
      output.writeMessage(3, getTargetPosition());
    }
    if (width_ != 0) {
      output.writeInt32(4, width_);
    }
    if (startingPosition_ != null) {
      output.writeMessage(5, getStartingPosition());
    }
    if (height_ != 0) {
      output.writeInt32(6, height_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (startingDirection_ != Direction4.NORTH.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, startingDirection_);
    }
    if (!getDataBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, data_);
    }
    if (targetPosition_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getTargetPosition());
    }
    if (width_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, width_);
    }
    if (startingPosition_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getStartingPosition());
    }
    if (height_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, height_);
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
    if (!(obj instanceof GridProto)) {
      return super.equals(obj);
    }
    GridProto other = (GridProto) obj;

    if (startingDirection_ != other.startingDirection_) return false;
    if (!getData()
        .equals(other.getData())) return false;
    if (hasTargetPosition() != other.hasTargetPosition()) return false;
    if (hasTargetPosition()) {
      if (!getTargetPosition()
          .equals(other.getTargetPosition())) return false;
    }
    if (getWidth()
        != other.getWidth()) return false;
    if (hasStartingPosition() != other.hasStartingPosition()) return false;
    if (hasStartingPosition()) {
      if (!getStartingPosition()
          .equals(other.getStartingPosition())) return false;
    }
    if (getHeight()
        != other.getHeight()) return false;
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
    hash = (37 * hash) + STARTINGDIRECTION_FIELD_NUMBER;
    hash = (53 * hash) + startingDirection_;
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    if (hasTargetPosition()) {
      hash = (37 * hash) + TARGETPOSITION_FIELD_NUMBER;
      hash = (53 * hash) + getTargetPosition().hashCode();
    }
    hash = (37 * hash) + WIDTH_FIELD_NUMBER;
    hash = (53 * hash) + getWidth();
    if (hasStartingPosition()) {
      hash = (37 * hash) + STARTINGPOSITION_FIELD_NUMBER;
      hash = (53 * hash) + getStartingPosition().hashCode();
    }
    hash = (37 * hash) + HEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + getHeight();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GridProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GridProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GridProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GridProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GridProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GridProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GridProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GridProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GridProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GridProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GridProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GridProto parseFrom(
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
  public static Builder newBuilder(GridProto prototype) {
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
   * Protobuf type {@code com.nkasenides.amc.proto.GridProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.nkasenides.amc.proto.GridProto)
      GridProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_GridProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_GridProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GridProto.class, Builder.class);
    }

    // Construct using com.nkasenides.amc.proto.GridProto.newBuilder()
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
      startingDirection_ = 0;

      data_ = "";

      if (targetPositionBuilder_ == null) {
        targetPosition_ = null;
      } else {
        targetPosition_ = null;
        targetPositionBuilder_ = null;
      }
      width_ = 0;

      if (startingPositionBuilder_ == null) {
        startingPosition_ = null;
      } else {
        startingPosition_ = null;
        startingPositionBuilder_ = null;
      }
      height_ = 0;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_GridProto_descriptor;
    }

    @Override
    public GridProto getDefaultInstanceForType() {
      return GridProto.getDefaultInstance();
    }

    @Override
    public GridProto build() {
      GridProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GridProto buildPartial() {
      GridProto result = new GridProto(this);
      result.startingDirection_ = startingDirection_;
      result.data_ = data_;
      if (targetPositionBuilder_ == null) {
        result.targetPosition_ = targetPosition_;
      } else {
        result.targetPosition_ = targetPositionBuilder_.build();
      }
      result.width_ = width_;
      if (startingPositionBuilder_ == null) {
        result.startingPosition_ = startingPosition_;
      } else {
        result.startingPosition_ = startingPositionBuilder_.build();
      }
      result.height_ = height_;
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
      if (other instanceof GridProto) {
        return mergeFrom((GridProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GridProto other) {
      if (other == GridProto.getDefaultInstance()) return this;
      if (other.startingDirection_ != 0) {
        setStartingDirectionValue(other.getStartingDirectionValue());
      }
      if (!other.getData().isEmpty()) {
        data_ = other.data_;
        onChanged();
      }
      if (other.hasTargetPosition()) {
        mergeTargetPosition(other.getTargetPosition());
      }
      if (other.getWidth() != 0) {
        setWidth(other.getWidth());
      }
      if (other.hasStartingPosition()) {
        mergeStartingPosition(other.getStartingPosition());
      }
      if (other.getHeight() != 0) {
        setHeight(other.getHeight());
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
      GridProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GridProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int startingDirection_ = 0;
    /**
     * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
     * @return The enum numeric value on the wire for startingDirection.
     */
    @Override public int getStartingDirectionValue() {
      return startingDirection_;
    }
    /**
     * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
     * @param value The enum numeric value on the wire for startingDirection to set.
     * @return This builder for chaining.
     */
    public Builder setStartingDirectionValue(int value) {
      
      startingDirection_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
     * @return The startingDirection.
     */
    @Override
    public Direction4 getStartingDirection() {
      @SuppressWarnings("deprecation")
      Direction4 result = Direction4.valueOf(startingDirection_);
      return result == null ? Direction4.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
     * @param value The startingDirection to set.
     * @return This builder for chaining.
     */
    public Builder setStartingDirection(Direction4 value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      startingDirection_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.Direction4 startingDirection = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStartingDirection() {
      
      startingDirection_ = 0;
      onChanged();
      return this;
    }

    private Object data_ = "";
    /**
     * <code>string data = 2;</code>
     * @return The data.
     */
    public String getData() {
      Object ref = data_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        data_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string data = 2;</code>
     * @return The bytes for data.
     */
    public com.google.protobuf.ByteString
        getDataBytes() {
      Object ref = data_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        data_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string data = 2;</code>
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string data = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      
      data_ = getDefaultInstance().getData();
      onChanged();
      return this;
    }
    /**
     * <code>string data = 2;</code>
     * @param value The bytes for data to set.
     * @return This builder for chaining.
     */
    public Builder setDataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      data_ = value;
      onChanged();
      return this;
    }

    private MatrixPositionProto targetPosition_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder> targetPositionBuilder_;
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     * @return Whether the targetPosition field is set.
     */
    public boolean hasTargetPosition() {
      return targetPositionBuilder_ != null || targetPosition_ != null;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     * @return The targetPosition.
     */
    public MatrixPositionProto getTargetPosition() {
      if (targetPositionBuilder_ == null) {
        return targetPosition_ == null ? MatrixPositionProto.getDefaultInstance() : targetPosition_;
      } else {
        return targetPositionBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     */
    public Builder setTargetPosition(MatrixPositionProto value) {
      if (targetPositionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        targetPosition_ = value;
        onChanged();
      } else {
        targetPositionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     */
    public Builder setTargetPosition(
        MatrixPositionProto.Builder builderForValue) {
      if (targetPositionBuilder_ == null) {
        targetPosition_ = builderForValue.build();
        onChanged();
      } else {
        targetPositionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     */
    public Builder mergeTargetPosition(MatrixPositionProto value) {
      if (targetPositionBuilder_ == null) {
        if (targetPosition_ != null) {
          targetPosition_ =
            MatrixPositionProto.newBuilder(targetPosition_).mergeFrom(value).buildPartial();
        } else {
          targetPosition_ = value;
        }
        onChanged();
      } else {
        targetPositionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     */
    public Builder clearTargetPosition() {
      if (targetPositionBuilder_ == null) {
        targetPosition_ = null;
        onChanged();
      } else {
        targetPosition_ = null;
        targetPositionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     */
    public MatrixPositionProto.Builder getTargetPositionBuilder() {
      
      onChanged();
      return getTargetPositionFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     */
    public MatrixPositionProtoOrBuilder getTargetPositionOrBuilder() {
      if (targetPositionBuilder_ != null) {
        return targetPositionBuilder_.getMessageOrBuilder();
      } else {
        return targetPosition_ == null ?
            MatrixPositionProto.getDefaultInstance() : targetPosition_;
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto targetPosition = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>
        getTargetPositionFieldBuilder() {
      if (targetPositionBuilder_ == null) {
        targetPositionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>(
                getTargetPosition(),
                getParentForChildren(),
                isClean());
        targetPosition_ = null;
      }
      return targetPositionBuilder_;
    }

    private int width_ ;
    /**
     * <code>int32 width = 4;</code>
     * @return The width.
     */
    @Override
    public int getWidth() {
      return width_;
    }
    /**
     * <code>int32 width = 4;</code>
     * @param value The width to set.
     * @return This builder for chaining.
     */
    public Builder setWidth(int value) {
      
      width_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 width = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearWidth() {
      
      width_ = 0;
      onChanged();
      return this;
    }

    private MatrixPositionProto startingPosition_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder> startingPositionBuilder_;
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     * @return Whether the startingPosition field is set.
     */
    public boolean hasStartingPosition() {
      return startingPositionBuilder_ != null || startingPosition_ != null;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     * @return The startingPosition.
     */
    public MatrixPositionProto getStartingPosition() {
      if (startingPositionBuilder_ == null) {
        return startingPosition_ == null ? MatrixPositionProto.getDefaultInstance() : startingPosition_;
      } else {
        return startingPositionBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     */
    public Builder setStartingPosition(MatrixPositionProto value) {
      if (startingPositionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        startingPosition_ = value;
        onChanged();
      } else {
        startingPositionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     */
    public Builder setStartingPosition(
        MatrixPositionProto.Builder builderForValue) {
      if (startingPositionBuilder_ == null) {
        startingPosition_ = builderForValue.build();
        onChanged();
      } else {
        startingPositionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     */
    public Builder mergeStartingPosition(MatrixPositionProto value) {
      if (startingPositionBuilder_ == null) {
        if (startingPosition_ != null) {
          startingPosition_ =
            MatrixPositionProto.newBuilder(startingPosition_).mergeFrom(value).buildPartial();
        } else {
          startingPosition_ = value;
        }
        onChanged();
      } else {
        startingPositionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     */
    public Builder clearStartingPosition() {
      if (startingPositionBuilder_ == null) {
        startingPosition_ = null;
        onChanged();
      } else {
        startingPosition_ = null;
        startingPositionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     */
    public MatrixPositionProto.Builder getStartingPositionBuilder() {
      
      onChanged();
      return getStartingPositionFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     */
    public MatrixPositionProtoOrBuilder getStartingPositionOrBuilder() {
      if (startingPositionBuilder_ != null) {
        return startingPositionBuilder_.getMessageOrBuilder();
      } else {
        return startingPosition_ == null ?
            MatrixPositionProto.getDefaultInstance() : startingPosition_;
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.MatrixPositionProto startingPosition = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>
        getStartingPositionFieldBuilder() {
      if (startingPositionBuilder_ == null) {
        startingPositionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>(
                getStartingPosition(),
                getParentForChildren(),
                isClean());
        startingPosition_ = null;
      }
      return startingPositionBuilder_;
    }

    private int height_ ;
    /**
     * <code>int32 height = 6;</code>
     * @return The height.
     */
    @Override
    public int getHeight() {
      return height_;
    }
    /**
     * <code>int32 height = 6;</code>
     * @param value The height to set.
     * @return This builder for chaining.
     */
    public Builder setHeight(int value) {
      
      height_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 height = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearHeight() {
      
      height_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.nkasenides.amc.proto.GridProto)
  }

  // @@protoc_insertion_point(class_scope:com.nkasenides.amc.proto.GridProto)
  private static final GridProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GridProto();
  }

  public static GridProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GridProto>
      PARSER = new com.google.protobuf.AbstractParser<GridProto>() {
    @Override
    public GridProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GridProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GridProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GridProto> getParserForType() {
    return PARSER;
  }

  @Override
  public GridProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public com.nkasenides.amc.model.Grid toObject() {    
        com.nkasenides.amc.model.Grid item = new com.nkasenides.amc.model.Grid();        
        item.setStartingDirection(getStartingDirection());        
        item.setData(getData());        
        item.setTargetPosition(getTargetPosition().toObject());        
        item.setWidth(getWidth());        
        item.setStartingPosition(getStartingPosition().toObject());        
        item.setHeight(getHeight());        
        return item;        
    }    
    
}

