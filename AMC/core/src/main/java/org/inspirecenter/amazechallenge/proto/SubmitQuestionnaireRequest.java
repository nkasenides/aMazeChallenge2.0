// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

/**
 * Protobuf type {@code SubmitQuestionnaireRequest}
 */
public final class SubmitQuestionnaireRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:SubmitQuestionnaireRequest)
    SubmitQuestionnaireRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SubmitQuestionnaireRequest.newBuilder() to construct.
  private SubmitQuestionnaireRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SubmitQuestionnaireRequest() {
    worldSessionID_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new SubmitQuestionnaireRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SubmitQuestionnaireRequest(
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
            QuestionnaireEntryProto.Builder subBuilder = null;
            if (questionnaireEntry_ != null) {
              subBuilder = questionnaireEntry_.toBuilder();
            }
            questionnaireEntry_ = input.readMessage(QuestionnaireEntryProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(questionnaireEntry_);
              questionnaireEntry_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            worldSessionID_ = s;
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
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_SubmitQuestionnaireRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_SubmitQuestionnaireRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            SubmitQuestionnaireRequest.class, Builder.class);
  }

  public static final int QUESTIONNAIREENTRY_FIELD_NUMBER = 1;
  private QuestionnaireEntryProto questionnaireEntry_;
  /**
   * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
   * @return Whether the questionnaireEntry field is set.
   */
  @Override
  public boolean hasQuestionnaireEntry() {
    return questionnaireEntry_ != null;
  }
  /**
   * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
   * @return The questionnaireEntry.
   */
  @Override
  public QuestionnaireEntryProto getQuestionnaireEntry() {
    return questionnaireEntry_ == null ? QuestionnaireEntryProto.getDefaultInstance() : questionnaireEntry_;
  }
  /**
   * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
   */
  @Override
  public QuestionnaireEntryProtoOrBuilder getQuestionnaireEntryOrBuilder() {
    return getQuestionnaireEntry();
  }

  public static final int WORLDSESSIONID_FIELD_NUMBER = 2;
  private volatile Object worldSessionID_;
  /**
   * <code>string worldSessionID = 2;</code>
   * @return The worldSessionID.
   */
  @Override
  public String getWorldSessionID() {
    Object ref = worldSessionID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      worldSessionID_ = s;
      return s;
    }
  }
  /**
   * <code>string worldSessionID = 2;</code>
   * @return The bytes for worldSessionID.
   */
  @Override
  public com.google.protobuf.ByteString
      getWorldSessionIDBytes() {
    Object ref = worldSessionID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      worldSessionID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (questionnaireEntry_ != null) {
      output.writeMessage(1, getQuestionnaireEntry());
    }
    if (!getWorldSessionIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, worldSessionID_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (questionnaireEntry_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getQuestionnaireEntry());
    }
    if (!getWorldSessionIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, worldSessionID_);
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
    if (!(obj instanceof SubmitQuestionnaireRequest)) {
      return super.equals(obj);
    }
    SubmitQuestionnaireRequest other = (SubmitQuestionnaireRequest) obj;

    if (hasQuestionnaireEntry() != other.hasQuestionnaireEntry()) return false;
    if (hasQuestionnaireEntry()) {
      if (!getQuestionnaireEntry()
          .equals(other.getQuestionnaireEntry())) return false;
    }
    if (!getWorldSessionID()
        .equals(other.getWorldSessionID())) return false;
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
    if (hasQuestionnaireEntry()) {
      hash = (37 * hash) + QUESTIONNAIREENTRY_FIELD_NUMBER;
      hash = (53 * hash) + getQuestionnaireEntry().hashCode();
    }
    hash = (37 * hash) + WORLDSESSIONID_FIELD_NUMBER;
    hash = (53 * hash) + getWorldSessionID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static SubmitQuestionnaireRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SubmitQuestionnaireRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SubmitQuestionnaireRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SubmitQuestionnaireRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SubmitQuestionnaireRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SubmitQuestionnaireRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SubmitQuestionnaireRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SubmitQuestionnaireRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static SubmitQuestionnaireRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static SubmitQuestionnaireRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static SubmitQuestionnaireRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SubmitQuestionnaireRequest parseFrom(
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
  public static Builder newBuilder(SubmitQuestionnaireRequest prototype) {
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
   * Protobuf type {@code SubmitQuestionnaireRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SubmitQuestionnaireRequest)
      SubmitQuestionnaireRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_SubmitQuestionnaireRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_SubmitQuestionnaireRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SubmitQuestionnaireRequest.class, Builder.class);
    }

    // Construct using SubmitQuestionnaireRequest.newBuilder()
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
      if (questionnaireEntryBuilder_ == null) {
        questionnaireEntry_ = null;
      } else {
        questionnaireEntry_ = null;
        questionnaireEntryBuilder_ = null;
      }
      worldSessionID_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_SubmitQuestionnaireRequest_descriptor;
    }

    @Override
    public SubmitQuestionnaireRequest getDefaultInstanceForType() {
      return SubmitQuestionnaireRequest.getDefaultInstance();
    }

    @Override
    public SubmitQuestionnaireRequest build() {
      SubmitQuestionnaireRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public SubmitQuestionnaireRequest buildPartial() {
      SubmitQuestionnaireRequest result = new SubmitQuestionnaireRequest(this);
      if (questionnaireEntryBuilder_ == null) {
        result.questionnaireEntry_ = questionnaireEntry_;
      } else {
        result.questionnaireEntry_ = questionnaireEntryBuilder_.build();
      }
      result.worldSessionID_ = worldSessionID_;
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
      if (other instanceof SubmitQuestionnaireRequest) {
        return mergeFrom((SubmitQuestionnaireRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(SubmitQuestionnaireRequest other) {
      if (other == SubmitQuestionnaireRequest.getDefaultInstance()) return this;
      if (other.hasQuestionnaireEntry()) {
        mergeQuestionnaireEntry(other.getQuestionnaireEntry());
      }
      if (!other.getWorldSessionID().isEmpty()) {
        worldSessionID_ = other.worldSessionID_;
        onChanged();
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
      SubmitQuestionnaireRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (SubmitQuestionnaireRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private QuestionnaireEntryProto questionnaireEntry_;
    private com.google.protobuf.SingleFieldBuilderV3<
        QuestionnaireEntryProto, QuestionnaireEntryProto.Builder, QuestionnaireEntryProtoOrBuilder> questionnaireEntryBuilder_;
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     * @return Whether the questionnaireEntry field is set.
     */
    public boolean hasQuestionnaireEntry() {
      return questionnaireEntryBuilder_ != null || questionnaireEntry_ != null;
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     * @return The questionnaireEntry.
     */
    public QuestionnaireEntryProto getQuestionnaireEntry() {
      if (questionnaireEntryBuilder_ == null) {
        return questionnaireEntry_ == null ? QuestionnaireEntryProto.getDefaultInstance() : questionnaireEntry_;
      } else {
        return questionnaireEntryBuilder_.getMessage();
      }
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     */
    public Builder setQuestionnaireEntry(QuestionnaireEntryProto value) {
      if (questionnaireEntryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        questionnaireEntry_ = value;
        onChanged();
      } else {
        questionnaireEntryBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     */
    public Builder setQuestionnaireEntry(
        QuestionnaireEntryProto.Builder builderForValue) {
      if (questionnaireEntryBuilder_ == null) {
        questionnaireEntry_ = builderForValue.build();
        onChanged();
      } else {
        questionnaireEntryBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     */
    public Builder mergeQuestionnaireEntry(QuestionnaireEntryProto value) {
      if (questionnaireEntryBuilder_ == null) {
        if (questionnaireEntry_ != null) {
          questionnaireEntry_ =
            QuestionnaireEntryProto.newBuilder(questionnaireEntry_).mergeFrom(value).buildPartial();
        } else {
          questionnaireEntry_ = value;
        }
        onChanged();
      } else {
        questionnaireEntryBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     */
    public Builder clearQuestionnaireEntry() {
      if (questionnaireEntryBuilder_ == null) {
        questionnaireEntry_ = null;
        onChanged();
      } else {
        questionnaireEntry_ = null;
        questionnaireEntryBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     */
    public QuestionnaireEntryProto.Builder getQuestionnaireEntryBuilder() {
      
      onChanged();
      return getQuestionnaireEntryFieldBuilder().getBuilder();
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     */
    public QuestionnaireEntryProtoOrBuilder getQuestionnaireEntryOrBuilder() {
      if (questionnaireEntryBuilder_ != null) {
        return questionnaireEntryBuilder_.getMessageOrBuilder();
      } else {
        return questionnaireEntry_ == null ?
            QuestionnaireEntryProto.getDefaultInstance() : questionnaireEntry_;
      }
    }
    /**
     * <code>.QuestionnaireEntryProto questionnaireEntry = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        QuestionnaireEntryProto, QuestionnaireEntryProto.Builder, QuestionnaireEntryProtoOrBuilder>
        getQuestionnaireEntryFieldBuilder() {
      if (questionnaireEntryBuilder_ == null) {
        questionnaireEntryBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            QuestionnaireEntryProto, QuestionnaireEntryProto.Builder, QuestionnaireEntryProtoOrBuilder>(
                getQuestionnaireEntry(),
                getParentForChildren(),
                isClean());
        questionnaireEntry_ = null;
      }
      return questionnaireEntryBuilder_;
    }

    private Object worldSessionID_ = "";
    /**
     * <code>string worldSessionID = 2;</code>
     * @return The worldSessionID.
     */
    public String getWorldSessionID() {
      Object ref = worldSessionID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        worldSessionID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @return The bytes for worldSessionID.
     */
    public com.google.protobuf.ByteString
        getWorldSessionIDBytes() {
      Object ref = worldSessionID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        worldSessionID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @param value The worldSessionID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldSessionID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      worldSessionID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearWorldSessionID() {
      
      worldSessionID_ = getDefaultInstance().getWorldSessionID();
      onChanged();
      return this;
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @param value The bytes for worldSessionID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldSessionIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      worldSessionID_ = value;
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


    // @@protoc_insertion_point(builder_scope:SubmitQuestionnaireRequest)
  }

  // @@protoc_insertion_point(class_scope:SubmitQuestionnaireRequest)
  private static final SubmitQuestionnaireRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new SubmitQuestionnaireRequest();
  }

  public static SubmitQuestionnaireRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SubmitQuestionnaireRequest>
      PARSER = new com.google.protobuf.AbstractParser<SubmitQuestionnaireRequest>() {
    @Override
    public SubmitQuestionnaireRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SubmitQuestionnaireRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SubmitQuestionnaireRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<SubmitQuestionnaireRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public SubmitQuestionnaireRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

