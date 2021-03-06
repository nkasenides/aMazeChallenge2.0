// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

import org.inspirecenter.amazechallenge.model.AMCTerrainCell;

/**
 * Protobuf type {@code AMCTerrainCellProto}
 */
public final class AMCTerrainCellProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<AMCTerrainCell> , com.nkasenides.athlos.model.ITerrainCell,
    // @@protoc_insertion_point(message_implements:AMCTerrainCellProto)
    AMCTerrainCellProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AMCTerrainCellProto.newBuilder() to construct.
  private AMCTerrainCellProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AMCTerrainCellProto() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new AMCTerrainCellProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AMCTerrainCellProto(
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
          case 16: {

            rightWall_ = input.readBool();
            break;
          }
          case 24: {

            downWall_ = input.readBool();
            break;
          }
          case 32: {

            upWall_ = input.readBool();
            break;
          }
          case 40: {

            leftWall_ = input.readBool();
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
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_AMCTerrainCellProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_AMCTerrainCellProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            AMCTerrainCellProto.class, Builder.class);
  }

  public static final int POSITION_FIELD_NUMBER = 1;
  private MatrixPositionProto position_;
  /**
   * <code>.MatrixPositionProto position = 1;</code>
   * @return Whether the position field is set.
   */
  @Override
  public boolean hasPosition() {
    return position_ != null;
  }
  /**
   * <code>.MatrixPositionProto position = 1;</code>
   * @return The position.
   */
  @Override
  public MatrixPositionProto getPosition() {
    return position_ == null ? MatrixPositionProto.getDefaultInstance() : position_;
  }
  /**
   * <code>.MatrixPositionProto position = 1;</code>
   */
  @Override
  public MatrixPositionProtoOrBuilder getPositionOrBuilder() {
    return getPosition();
  }

  public static final int RIGHTWALL_FIELD_NUMBER = 2;
  private boolean rightWall_;
  /**
   * <code>bool rightWall = 2;</code>
   * @return The rightWall.
   */
  @Override
  public boolean getRightWall() {
    return rightWall_;
  }

  public static final int DOWNWALL_FIELD_NUMBER = 3;
  private boolean downWall_;
  /**
   * <code>bool downWall = 3;</code>
   * @return The downWall.
   */
  @Override
  public boolean getDownWall() {
    return downWall_;
  }

  public static final int UPWALL_FIELD_NUMBER = 4;
  private boolean upWall_;
  /**
   * <code>bool upWall = 4;</code>
   * @return The upWall.
   */
  @Override
  public boolean getUpWall() {
    return upWall_;
  }

  public static final int LEFTWALL_FIELD_NUMBER = 5;
  private boolean leftWall_;
  /**
   * <code>bool leftWall = 5;</code>
   * @return The leftWall.
   */
  @Override
  public boolean getLeftWall() {
    return leftWall_;
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
    if (position_ != null) {
      output.writeMessage(1, getPosition());
    }
    if (rightWall_ != false) {
      output.writeBool(2, rightWall_);
    }
    if (downWall_ != false) {
      output.writeBool(3, downWall_);
    }
    if (upWall_ != false) {
      output.writeBool(4, upWall_);
    }
    if (leftWall_ != false) {
      output.writeBool(5, leftWall_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (position_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPosition());
    }
    if (rightWall_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, rightWall_);
    }
    if (downWall_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, downWall_);
    }
    if (upWall_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, upWall_);
    }
    if (leftWall_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(5, leftWall_);
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
    if (!(obj instanceof AMCTerrainCellProto)) {
      return super.equals(obj);
    }
    AMCTerrainCellProto other = (AMCTerrainCellProto) obj;

    if (hasPosition() != other.hasPosition()) return false;
    if (hasPosition()) {
      if (!getPosition()
          .equals(other.getPosition())) return false;
    }
    if (getRightWall()
        != other.getRightWall()) return false;
    if (getDownWall()
        != other.getDownWall()) return false;
    if (getUpWall()
        != other.getUpWall()) return false;
    if (getLeftWall()
        != other.getLeftWall()) return false;
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
    if (hasPosition()) {
      hash = (37 * hash) + POSITION_FIELD_NUMBER;
      hash = (53 * hash) + getPosition().hashCode();
    }
    hash = (37 * hash) + RIGHTWALL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getRightWall());
    hash = (37 * hash) + DOWNWALL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getDownWall());
    hash = (37 * hash) + UPWALL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getUpWall());
    hash = (37 * hash) + LEFTWALL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getLeftWall());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static AMCTerrainCellProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AMCTerrainCellProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AMCTerrainCellProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AMCTerrainCellProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AMCTerrainCellProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AMCTerrainCellProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AMCTerrainCellProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AMCTerrainCellProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static AMCTerrainCellProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static AMCTerrainCellProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static AMCTerrainCellProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AMCTerrainCellProto parseFrom(
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
  public static Builder newBuilder(AMCTerrainCellProto prototype) {
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
   * Protobuf type {@code AMCTerrainCellProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements com.nkasenides.athlos.model.ITerrainCell, com.nkasenides.athlos.proto.Modelable<AMCTerrainCell>,
      // @@protoc_insertion_point(builder_implements:AMCTerrainCellProto)
      AMCTerrainCellProtoOrBuilder {    @Override
    public AMCTerrainCell toObject() {
        AMCTerrainCell item = new AMCTerrainCell();
        item.setPosition(getPosition().toObject());        
        item.setRightWall(getRightWall());        
        item.setDownWall(getDownWall());        
        item.setUpWall(getUpWall());        
        item.setLeftWall(getLeftWall());        
        return item;        
    }    
    

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_AMCTerrainCellProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_AMCTerrainCellProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AMCTerrainCellProto.class, Builder.class);
    }

    // Construct using AMCTerrainCellProto.newBuilder()
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
      if (positionBuilder_ == null) {
        position_ = null;
      } else {
        position_ = null;
        positionBuilder_ = null;
      }
      rightWall_ = false;

      downWall_ = false;

      upWall_ = false;

      leftWall_ = false;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_AMCTerrainCellProto_descriptor;
    }

    @Override
    public AMCTerrainCellProto getDefaultInstanceForType() {
      return AMCTerrainCellProto.getDefaultInstance();
    }

    @Override
    public AMCTerrainCellProto build() {
      AMCTerrainCellProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public AMCTerrainCellProto buildPartial() {
      AMCTerrainCellProto result = new AMCTerrainCellProto(this);
      if (positionBuilder_ == null) {
        result.position_ = position_;
      } else {
        result.position_ = positionBuilder_.build();
      }
      result.rightWall_ = rightWall_;
      result.downWall_ = downWall_;
      result.upWall_ = upWall_;
      result.leftWall_ = leftWall_;
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
      if (other instanceof AMCTerrainCellProto) {
        return mergeFrom((AMCTerrainCellProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(AMCTerrainCellProto other) {
      if (other == AMCTerrainCellProto.getDefaultInstance()) return this;
      if (other.hasPosition()) {
        mergePosition(other.getPosition());
      }
      if (other.getRightWall() != false) {
        setRightWall(other.getRightWall());
      }
      if (other.getDownWall() != false) {
        setDownWall(other.getDownWall());
      }
      if (other.getUpWall() != false) {
        setUpWall(other.getUpWall());
      }
      if (other.getLeftWall() != false) {
        setLeftWall(other.getLeftWall());
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
      AMCTerrainCellProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (AMCTerrainCellProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private MatrixPositionProto position_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder> positionBuilder_;
    /**
     * <code>.MatrixPositionProto position = 1;</code>
     * @return Whether the position field is set.
     */
    public boolean hasPosition() {
      return positionBuilder_ != null || position_ != null;
    }
    /**
     * <code>.MatrixPositionProto position = 1;</code>
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
     * <code>.MatrixPositionProto position = 1;</code>
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
     * <code>.MatrixPositionProto position = 1;</code>
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
     * <code>.MatrixPositionProto position = 1;</code>
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
     * <code>.MatrixPositionProto position = 1;</code>
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
     * <code>.MatrixPositionProto position = 1;</code>
     */
    public MatrixPositionProto.Builder getPositionBuilder() {
      
      onChanged();
      return getPositionFieldBuilder().getBuilder();
    }
    /**
     * <code>.MatrixPositionProto position = 1;</code>
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
     * <code>.MatrixPositionProto position = 1;</code>
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

    private boolean rightWall_ ;
    /**
     * <code>bool rightWall = 2;</code>
     * @return The rightWall.
     */
    @Override
    public boolean getRightWall() {
      return rightWall_;
    }
    /**
     * <code>bool rightWall = 2;</code>
     * @param value The rightWall to set.
     * @return This builder for chaining.
     */
    public Builder setRightWall(boolean value) {
      
      rightWall_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool rightWall = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRightWall() {
      
      rightWall_ = false;
      onChanged();
      return this;
    }

    private boolean downWall_ ;
    /**
     * <code>bool downWall = 3;</code>
     * @return The downWall.
     */
    @Override
    public boolean getDownWall() {
      return downWall_;
    }
    /**
     * <code>bool downWall = 3;</code>
     * @param value The downWall to set.
     * @return This builder for chaining.
     */
    public Builder setDownWall(boolean value) {
      
      downWall_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool downWall = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDownWall() {
      
      downWall_ = false;
      onChanged();
      return this;
    }

    private boolean upWall_ ;
    /**
     * <code>bool upWall = 4;</code>
     * @return The upWall.
     */
    @Override
    public boolean getUpWall() {
      return upWall_;
    }
    /**
     * <code>bool upWall = 4;</code>
     * @param value The upWall to set.
     * @return This builder for chaining.
     */
    public Builder setUpWall(boolean value) {
      
      upWall_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool upWall = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearUpWall() {
      
      upWall_ = false;
      onChanged();
      return this;
    }

    private boolean leftWall_ ;
    /**
     * <code>bool leftWall = 5;</code>
     * @return The leftWall.
     */
    @Override
    public boolean getLeftWall() {
      return leftWall_;
    }
    /**
     * <code>bool leftWall = 5;</code>
     * @param value The leftWall to set.
     * @return This builder for chaining.
     */
    public Builder setLeftWall(boolean value) {
      
      leftWall_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool leftWall = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearLeftWall() {
      
      leftWall_ = false;
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


    // @@protoc_insertion_point(builder_scope:AMCTerrainCellProto)
  }

  // @@protoc_insertion_point(class_scope:AMCTerrainCellProto)
  private static final AMCTerrainCellProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AMCTerrainCellProto();
  }

  public static AMCTerrainCellProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AMCTerrainCellProto>
      PARSER = new com.google.protobuf.AbstractParser<AMCTerrainCellProto>() {
    @Override
    public AMCTerrainCellProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AMCTerrainCellProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AMCTerrainCellProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AMCTerrainCellProto> getParserForType() {
    return PARSER;
  }

  @Override
  public AMCTerrainCellProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public AMCTerrainCell toObject() {
        AMCTerrainCell item = new AMCTerrainCell();
        item.setPosition(getPosition().toObject());        
        item.setRightWall(getRightWall());        
        item.setDownWall(getDownWall());        
        item.setUpWall(getUpWall());        
        item.setLeftWall(getLeftWall());        
        return item;        
    }    
    
}

