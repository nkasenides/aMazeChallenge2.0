// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf type {@code com.nkasenides.amc.proto.Request}
 */
public final class Request extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.nkasenides.amc.proto.Request)
    RequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Request.newBuilder() to construct.
  private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Request() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Request();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Request(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
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
            com.nkasenides.amc.proto.GetStateRequest.Builder subBuilder = null;
            if (requestCase_ == 1) {
              subBuilder = ((com.nkasenides.amc.proto.GetStateRequest) request_).toBuilder();
            }
            request_ =
                input.readMessage(com.nkasenides.amc.proto.GetStateRequest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((com.nkasenides.amc.proto.GetStateRequest) request_);
              request_ = subBuilder.buildPartial();
            }
            requestCase_ = 1;
            break;
          }
          case 18: {
            com.nkasenides.amc.proto.UpdateStateRequest.Builder subBuilder = null;
            if (requestCase_ == 2) {
              subBuilder = ((com.nkasenides.amc.proto.UpdateStateRequest) request_).toBuilder();
            }
            request_ =
                input.readMessage(com.nkasenides.amc.proto.UpdateStateRequest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((com.nkasenides.amc.proto.UpdateStateRequest) request_);
              request_ = subBuilder.buildPartial();
            }
            requestCase_ = 2;
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
    return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_Request_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_Request_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.nkasenides.amc.proto.Request.class, com.nkasenides.amc.proto.Request.Builder.class);
  }

  private int requestCase_ = 0;
  private java.lang.Object request_;
  public enum RequestCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    GETSTATEREQUEST(1),
    UPDATESTATEREQUEST(2),
    REQUEST_NOT_SET(0);
    private final int value;
    private RequestCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static RequestCase valueOf(int value) {
      return forNumber(value);
    }

    public static RequestCase forNumber(int value) {
      switch (value) {
        case 1: return GETSTATEREQUEST;
        case 2: return UPDATESTATEREQUEST;
        case 0: return REQUEST_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public RequestCase
  getRequestCase() {
    return RequestCase.forNumber(
        requestCase_);
  }

  public static final int GETSTATEREQUEST_FIELD_NUMBER = 1;
  /**
   * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
   * @return Whether the getStateRequest field is set.
   */
  @java.lang.Override
  public boolean hasGetStateRequest() {
    return requestCase_ == 1;
  }
  /**
   * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
   * @return The getStateRequest.
   */
  @java.lang.Override
  public com.nkasenides.amc.proto.GetStateRequest getGetStateRequest() {
    if (requestCase_ == 1) {
       return (com.nkasenides.amc.proto.GetStateRequest) request_;
    }
    return com.nkasenides.amc.proto.GetStateRequest.getDefaultInstance();
  }
  /**
   * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
   */
  @java.lang.Override
  public com.nkasenides.amc.proto.GetStateRequestOrBuilder getGetStateRequestOrBuilder() {
    if (requestCase_ == 1) {
       return (com.nkasenides.amc.proto.GetStateRequest) request_;
    }
    return com.nkasenides.amc.proto.GetStateRequest.getDefaultInstance();
  }

  public static final int UPDATESTATEREQUEST_FIELD_NUMBER = 2;
  /**
   * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
   * @return Whether the updateStateRequest field is set.
   */
  @java.lang.Override
  public boolean hasUpdateStateRequest() {
    return requestCase_ == 2;
  }
  /**
   * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
   * @return The updateStateRequest.
   */
  @java.lang.Override
  public com.nkasenides.amc.proto.UpdateStateRequest getUpdateStateRequest() {
    if (requestCase_ == 2) {
       return (com.nkasenides.amc.proto.UpdateStateRequest) request_;
    }
    return com.nkasenides.amc.proto.UpdateStateRequest.getDefaultInstance();
  }
  /**
   * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
   */
  @java.lang.Override
  public com.nkasenides.amc.proto.UpdateStateRequestOrBuilder getUpdateStateRequestOrBuilder() {
    if (requestCase_ == 2) {
       return (com.nkasenides.amc.proto.UpdateStateRequest) request_;
    }
    return com.nkasenides.amc.proto.UpdateStateRequest.getDefaultInstance();
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
    if (requestCase_ == 1) {
      output.writeMessage(1, (com.nkasenides.amc.proto.GetStateRequest) request_);
    }
    if (requestCase_ == 2) {
      output.writeMessage(2, (com.nkasenides.amc.proto.UpdateStateRequest) request_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (requestCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (com.nkasenides.amc.proto.GetStateRequest) request_);
    }
    if (requestCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (com.nkasenides.amc.proto.UpdateStateRequest) request_);
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
    if (!(obj instanceof com.nkasenides.amc.proto.Request)) {
      return super.equals(obj);
    }
    com.nkasenides.amc.proto.Request other = (com.nkasenides.amc.proto.Request) obj;

    if (!getRequestCase().equals(other.getRequestCase())) return false;
    switch (requestCase_) {
      case 1:
        if (!getGetStateRequest()
            .equals(other.getGetStateRequest())) return false;
        break;
      case 2:
        if (!getUpdateStateRequest()
            .equals(other.getUpdateStateRequest())) return false;
        break;
      case 0:
      default:
    }
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
    switch (requestCase_) {
      case 1:
        hash = (37 * hash) + GETSTATEREQUEST_FIELD_NUMBER;
        hash = (53 * hash) + getGetStateRequest().hashCode();
        break;
      case 2:
        hash = (37 * hash) + UPDATESTATEREQUEST_FIELD_NUMBER;
        hash = (53 * hash) + getUpdateStateRequest().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.nkasenides.amc.proto.Request parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.Request parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.nkasenides.amc.proto.Request parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.nkasenides.amc.proto.Request parseFrom(
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
  public static Builder newBuilder(com.nkasenides.amc.proto.Request prototype) {
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
   * Protobuf type {@code com.nkasenides.amc.proto.Request}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.nkasenides.amc.proto.Request)
      com.nkasenides.amc.proto.RequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_Request_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.nkasenides.amc.proto.Request.class, com.nkasenides.amc.proto.Request.Builder.class);
    }

    // Construct using com.nkasenides.amc.proto.Request.newBuilder()
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
      requestCase_ = 0;
      request_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.nkasenides.amc.proto.AMCProto.internal_static_com_nkasenides_amc_proto_Request_descriptor;
    }

    @java.lang.Override
    public com.nkasenides.amc.proto.Request getDefaultInstanceForType() {
      return com.nkasenides.amc.proto.Request.getDefaultInstance();
    }

    @java.lang.Override
    public com.nkasenides.amc.proto.Request build() {
      com.nkasenides.amc.proto.Request result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.nkasenides.amc.proto.Request buildPartial() {
      com.nkasenides.amc.proto.Request result = new com.nkasenides.amc.proto.Request(this);
      if (requestCase_ == 1) {
        if (getStateRequestBuilder_ == null) {
          result.request_ = request_;
        } else {
          result.request_ = getStateRequestBuilder_.build();
        }
      }
      if (requestCase_ == 2) {
        if (updateStateRequestBuilder_ == null) {
          result.request_ = request_;
        } else {
          result.request_ = updateStateRequestBuilder_.build();
        }
      }
      result.requestCase_ = requestCase_;
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
      if (other instanceof com.nkasenides.amc.proto.Request) {
        return mergeFrom((com.nkasenides.amc.proto.Request)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.nkasenides.amc.proto.Request other) {
      if (other == com.nkasenides.amc.proto.Request.getDefaultInstance()) return this;
      switch (other.getRequestCase()) {
        case GETSTATEREQUEST: {
          mergeGetStateRequest(other.getGetStateRequest());
          break;
        }
        case UPDATESTATEREQUEST: {
          mergeUpdateStateRequest(other.getUpdateStateRequest());
          break;
        }
        case REQUEST_NOT_SET: {
          break;
        }
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
      com.nkasenides.amc.proto.Request parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.nkasenides.amc.proto.Request) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int requestCase_ = 0;
    private java.lang.Object request_;
    public RequestCase
        getRequestCase() {
      return RequestCase.forNumber(
          requestCase_);
    }

    public Builder clearRequest() {
      requestCase_ = 0;
      request_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        com.nkasenides.amc.proto.GetStateRequest, com.nkasenides.amc.proto.GetStateRequest.Builder, com.nkasenides.amc.proto.GetStateRequestOrBuilder> getStateRequestBuilder_;
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     * @return Whether the getStateRequest field is set.
     */
    @java.lang.Override
    public boolean hasGetStateRequest() {
      return requestCase_ == 1;
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     * @return The getStateRequest.
     */
    @java.lang.Override
    public com.nkasenides.amc.proto.GetStateRequest getGetStateRequest() {
      if (getStateRequestBuilder_ == null) {
        if (requestCase_ == 1) {
          return (com.nkasenides.amc.proto.GetStateRequest) request_;
        }
        return com.nkasenides.amc.proto.GetStateRequest.getDefaultInstance();
      } else {
        if (requestCase_ == 1) {
          return getStateRequestBuilder_.getMessage();
        }
        return com.nkasenides.amc.proto.GetStateRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     */
    public Builder setGetStateRequest(com.nkasenides.amc.proto.GetStateRequest value) {
      if (getStateRequestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        request_ = value;
        onChanged();
      } else {
        getStateRequestBuilder_.setMessage(value);
      }
      requestCase_ = 1;
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     */
    public Builder setGetStateRequest(
        com.nkasenides.amc.proto.GetStateRequest.Builder builderForValue) {
      if (getStateRequestBuilder_ == null) {
        request_ = builderForValue.build();
        onChanged();
      } else {
        getStateRequestBuilder_.setMessage(builderForValue.build());
      }
      requestCase_ = 1;
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     */
    public Builder mergeGetStateRequest(com.nkasenides.amc.proto.GetStateRequest value) {
      if (getStateRequestBuilder_ == null) {
        if (requestCase_ == 1 &&
            request_ != com.nkasenides.amc.proto.GetStateRequest.getDefaultInstance()) {
          request_ = com.nkasenides.amc.proto.GetStateRequest.newBuilder((com.nkasenides.amc.proto.GetStateRequest) request_)
              .mergeFrom(value).buildPartial();
        } else {
          request_ = value;
        }
        onChanged();
      } else {
        if (requestCase_ == 1) {
          getStateRequestBuilder_.mergeFrom(value);
        }
        getStateRequestBuilder_.setMessage(value);
      }
      requestCase_ = 1;
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     */
    public Builder clearGetStateRequest() {
      if (getStateRequestBuilder_ == null) {
        if (requestCase_ == 1) {
          requestCase_ = 0;
          request_ = null;
          onChanged();
        }
      } else {
        if (requestCase_ == 1) {
          requestCase_ = 0;
          request_ = null;
        }
        getStateRequestBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     */
    public com.nkasenides.amc.proto.GetStateRequest.Builder getGetStateRequestBuilder() {
      return getGetStateRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     */
    @java.lang.Override
    public com.nkasenides.amc.proto.GetStateRequestOrBuilder getGetStateRequestOrBuilder() {
      if ((requestCase_ == 1) && (getStateRequestBuilder_ != null)) {
        return getStateRequestBuilder_.getMessageOrBuilder();
      } else {
        if (requestCase_ == 1) {
          return (com.nkasenides.amc.proto.GetStateRequest) request_;
        }
        return com.nkasenides.amc.proto.GetStateRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.GetStateRequest getStateRequest = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.nkasenides.amc.proto.GetStateRequest, com.nkasenides.amc.proto.GetStateRequest.Builder, com.nkasenides.amc.proto.GetStateRequestOrBuilder> 
        getGetStateRequestFieldBuilder() {
      if (getStateRequestBuilder_ == null) {
        if (!(requestCase_ == 1)) {
          request_ = com.nkasenides.amc.proto.GetStateRequest.getDefaultInstance();
        }
        getStateRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.nkasenides.amc.proto.GetStateRequest, com.nkasenides.amc.proto.GetStateRequest.Builder, com.nkasenides.amc.proto.GetStateRequestOrBuilder>(
                (com.nkasenides.amc.proto.GetStateRequest) request_,
                getParentForChildren(),
                isClean());
        request_ = null;
      }
      requestCase_ = 1;
      onChanged();;
      return getStateRequestBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        com.nkasenides.amc.proto.UpdateStateRequest, com.nkasenides.amc.proto.UpdateStateRequest.Builder, com.nkasenides.amc.proto.UpdateStateRequestOrBuilder> updateStateRequestBuilder_;
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     * @return Whether the updateStateRequest field is set.
     */
    @java.lang.Override
    public boolean hasUpdateStateRequest() {
      return requestCase_ == 2;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     * @return The updateStateRequest.
     */
    @java.lang.Override
    public com.nkasenides.amc.proto.UpdateStateRequest getUpdateStateRequest() {
      if (updateStateRequestBuilder_ == null) {
        if (requestCase_ == 2) {
          return (com.nkasenides.amc.proto.UpdateStateRequest) request_;
        }
        return com.nkasenides.amc.proto.UpdateStateRequest.getDefaultInstance();
      } else {
        if (requestCase_ == 2) {
          return updateStateRequestBuilder_.getMessage();
        }
        return com.nkasenides.amc.proto.UpdateStateRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     */
    public Builder setUpdateStateRequest(com.nkasenides.amc.proto.UpdateStateRequest value) {
      if (updateStateRequestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        request_ = value;
        onChanged();
      } else {
        updateStateRequestBuilder_.setMessage(value);
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     */
    public Builder setUpdateStateRequest(
        com.nkasenides.amc.proto.UpdateStateRequest.Builder builderForValue) {
      if (updateStateRequestBuilder_ == null) {
        request_ = builderForValue.build();
        onChanged();
      } else {
        updateStateRequestBuilder_.setMessage(builderForValue.build());
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     */
    public Builder mergeUpdateStateRequest(com.nkasenides.amc.proto.UpdateStateRequest value) {
      if (updateStateRequestBuilder_ == null) {
        if (requestCase_ == 2 &&
            request_ != com.nkasenides.amc.proto.UpdateStateRequest.getDefaultInstance()) {
          request_ = com.nkasenides.amc.proto.UpdateStateRequest.newBuilder((com.nkasenides.amc.proto.UpdateStateRequest) request_)
              .mergeFrom(value).buildPartial();
        } else {
          request_ = value;
        }
        onChanged();
      } else {
        if (requestCase_ == 2) {
          updateStateRequestBuilder_.mergeFrom(value);
        }
        updateStateRequestBuilder_.setMessage(value);
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     */
    public Builder clearUpdateStateRequest() {
      if (updateStateRequestBuilder_ == null) {
        if (requestCase_ == 2) {
          requestCase_ = 0;
          request_ = null;
          onChanged();
        }
      } else {
        if (requestCase_ == 2) {
          requestCase_ = 0;
          request_ = null;
        }
        updateStateRequestBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     */
    public com.nkasenides.amc.proto.UpdateStateRequest.Builder getUpdateStateRequestBuilder() {
      return getUpdateStateRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     */
    @java.lang.Override
    public com.nkasenides.amc.proto.UpdateStateRequestOrBuilder getUpdateStateRequestOrBuilder() {
      if ((requestCase_ == 2) && (updateStateRequestBuilder_ != null)) {
        return updateStateRequestBuilder_.getMessageOrBuilder();
      } else {
        if (requestCase_ == 2) {
          return (com.nkasenides.amc.proto.UpdateStateRequest) request_;
        }
        return com.nkasenides.amc.proto.UpdateStateRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.com.nkasenides.amc.proto.UpdateStateRequest updateStateRequest = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.nkasenides.amc.proto.UpdateStateRequest, com.nkasenides.amc.proto.UpdateStateRequest.Builder, com.nkasenides.amc.proto.UpdateStateRequestOrBuilder> 
        getUpdateStateRequestFieldBuilder() {
      if (updateStateRequestBuilder_ == null) {
        if (!(requestCase_ == 2)) {
          request_ = com.nkasenides.amc.proto.UpdateStateRequest.getDefaultInstance();
        }
        updateStateRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.nkasenides.amc.proto.UpdateStateRequest, com.nkasenides.amc.proto.UpdateStateRequest.Builder, com.nkasenides.amc.proto.UpdateStateRequestOrBuilder>(
                (com.nkasenides.amc.proto.UpdateStateRequest) request_,
                getParentForChildren(),
                isClean());
        request_ = null;
      }
      requestCase_ = 2;
      onChanged();;
      return updateStateRequestBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.nkasenides.amc.proto.Request)
  }

  // @@protoc_insertion_point(class_scope:com.nkasenides.amc.proto.Request)
  private static final com.nkasenides.amc.proto.Request DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.nkasenides.amc.proto.Request();
  }

  public static com.nkasenides.amc.proto.Request getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Request>
      PARSER = new com.google.protobuf.AbstractParser<Request>() {
    @java.lang.Override
    public Request parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Request(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Request> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Request> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.nkasenides.amc.proto.Request getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

