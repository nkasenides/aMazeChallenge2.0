// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

/**
 * Protobuf type {@code org.inspirecenter.amazechallenge.proto.QuestionEntryProto}
 */
public final class QuestionEntryProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<org.inspirecenter.amazechallenge.model.QuestionEntry> , 
    // @@protoc_insertion_point(message_implements:org.inspirecenter.amazechallenge.proto.QuestionEntryProto)
    QuestionEntryProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QuestionEntryProto.newBuilder() to construct.
  private QuestionEntryProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QuestionEntryProto() {
    answerText_ = "";
    id_ = "";
    questionText_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new QuestionEntryProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private QuestionEntryProto(
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

            answerText_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            questionText_ = s;
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
    return org.inspirecenter.amazechallenge.proto.AMCProto.internal_static_com_nkasenides_amc_proto_QuestionEntryProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.inspirecenter.amazechallenge.proto.AMCProto.internal_static_com_nkasenides_amc_proto_QuestionEntryProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.inspirecenter.amazechallenge.proto.QuestionEntryProto.class, org.inspirecenter.amazechallenge.proto.QuestionEntryProto.Builder.class);
  }

  public static final int ANSWERTEXT_FIELD_NUMBER = 1;
  private volatile Object answerText_;
  /**
   * <code>string answerText = 1;</code>
   * @return The answerText.
   */
  @Override
  public String getAnswerText() {
    Object ref = answerText_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      answerText_ = s;
      return s;
    }
  }
  /**
   * <code>string answerText = 1;</code>
   * @return The bytes for answerText.
   */
  @Override
  public com.google.protobuf.ByteString
      getAnswerTextBytes() {
    Object ref = answerText_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      answerText_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ID_FIELD_NUMBER = 2;
  private volatile Object id_;
  /**
   * <code>string id = 2;</code>
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
   * <code>string id = 2;</code>
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

  public static final int QUESTIONTEXT_FIELD_NUMBER = 3;
  private volatile Object questionText_;
  /**
   * <code>string questionText = 3;</code>
   * @return The questionText.
   */
  @Override
  public String getQuestionText() {
    Object ref = questionText_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      questionText_ = s;
      return s;
    }
  }
  /**
   * <code>string questionText = 3;</code>
   * @return The bytes for questionText.
   */
  @Override
  public com.google.protobuf.ByteString
      getQuestionTextBytes() {
    Object ref = questionText_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      questionText_ = b;
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
    if (!getAnswerTextBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, answerText_);
    }
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, id_);
    }
    if (!getQuestionTextBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, questionText_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAnswerTextBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, answerText_);
    }
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, id_);
    }
    if (!getQuestionTextBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, questionText_);
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
    if (!(obj instanceof org.inspirecenter.amazechallenge.proto.QuestionEntryProto)) {
      return super.equals(obj);
    }
    org.inspirecenter.amazechallenge.proto.QuestionEntryProto other = (org.inspirecenter.amazechallenge.proto.QuestionEntryProto) obj;

    if (!getAnswerText()
        .equals(other.getAnswerText())) return false;
    if (!getId()
        .equals(other.getId())) return false;
    if (!getQuestionText()
        .equals(other.getQuestionText())) return false;
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
    hash = (37 * hash) + ANSWERTEXT_FIELD_NUMBER;
    hash = (53 * hash) + getAnswerText().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + QUESTIONTEXT_FIELD_NUMBER;
    hash = (53 * hash) + getQuestionText().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto parseFrom(
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
  public static Builder newBuilder(org.inspirecenter.amazechallenge.proto.QuestionEntryProto prototype) {
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
   * Protobuf type {@code org.inspirecenter.amazechallenge.proto.QuestionEntryProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.inspirecenter.amazechallenge.proto.QuestionEntryProto)
      org.inspirecenter.amazechallenge.proto.QuestionEntryProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.inspirecenter.amazechallenge.proto.AMCProto.internal_static_com_nkasenides_amc_proto_QuestionEntryProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.inspirecenter.amazechallenge.proto.AMCProto.internal_static_com_nkasenides_amc_proto_QuestionEntryProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.inspirecenter.amazechallenge.proto.QuestionEntryProto.class, org.inspirecenter.amazechallenge.proto.QuestionEntryProto.Builder.class);
    }

    // Construct using org.inspirecenter.amazechallenge.proto.QuestionEntryProto.newBuilder()
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
      answerText_ = "";

      id_ = "";

      questionText_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.inspirecenter.amazechallenge.proto.AMCProto.internal_static_com_nkasenides_amc_proto_QuestionEntryProto_descriptor;
    }

    @Override
    public org.inspirecenter.amazechallenge.proto.QuestionEntryProto getDefaultInstanceForType() {
      return org.inspirecenter.amazechallenge.proto.QuestionEntryProto.getDefaultInstance();
    }

    @Override
    public org.inspirecenter.amazechallenge.proto.QuestionEntryProto build() {
      org.inspirecenter.amazechallenge.proto.QuestionEntryProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public org.inspirecenter.amazechallenge.proto.QuestionEntryProto buildPartial() {
      org.inspirecenter.amazechallenge.proto.QuestionEntryProto result = new org.inspirecenter.amazechallenge.proto.QuestionEntryProto(this);
      result.answerText_ = answerText_;
      result.id_ = id_;
      result.questionText_ = questionText_;
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
      if (other instanceof org.inspirecenter.amazechallenge.proto.QuestionEntryProto) {
        return mergeFrom((org.inspirecenter.amazechallenge.proto.QuestionEntryProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.inspirecenter.amazechallenge.proto.QuestionEntryProto other) {
      if (other == org.inspirecenter.amazechallenge.proto.QuestionEntryProto.getDefaultInstance()) return this;
      if (!other.getAnswerText().isEmpty()) {
        answerText_ = other.answerText_;
        onChanged();
      }
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (!other.getQuestionText().isEmpty()) {
        questionText_ = other.questionText_;
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
      org.inspirecenter.amazechallenge.proto.QuestionEntryProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.inspirecenter.amazechallenge.proto.QuestionEntryProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object answerText_ = "";
    /**
     * <code>string answerText = 1;</code>
     * @return The answerText.
     */
    public String getAnswerText() {
      Object ref = answerText_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        answerText_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string answerText = 1;</code>
     * @return The bytes for answerText.
     */
    public com.google.protobuf.ByteString
        getAnswerTextBytes() {
      Object ref = answerText_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        answerText_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string answerText = 1;</code>
     * @param value The answerText to set.
     * @return This builder for chaining.
     */
    public Builder setAnswerText(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      answerText_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string answerText = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAnswerText() {
      
      answerText_ = getDefaultInstance().getAnswerText();
      onChanged();
      return this;
    }
    /**
     * <code>string answerText = 1;</code>
     * @param value The bytes for answerText to set.
     * @return This builder for chaining.
     */
    public Builder setAnswerTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      answerText_ = value;
      onChanged();
      return this;
    }

    private Object id_ = "";
    /**
     * <code>string id = 2;</code>
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
     * <code>string id = 2;</code>
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
     * <code>string id = 2;</code>
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

    private Object questionText_ = "";
    /**
     * <code>string questionText = 3;</code>
     * @return The questionText.
     */
    public String getQuestionText() {
      Object ref = questionText_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        questionText_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string questionText = 3;</code>
     * @return The bytes for questionText.
     */
    public com.google.protobuf.ByteString
        getQuestionTextBytes() {
      Object ref = questionText_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        questionText_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string questionText = 3;</code>
     * @param value The questionText to set.
     * @return This builder for chaining.
     */
    public Builder setQuestionText(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      questionText_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string questionText = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearQuestionText() {
      
      questionText_ = getDefaultInstance().getQuestionText();
      onChanged();
      return this;
    }
    /**
     * <code>string questionText = 3;</code>
     * @param value The bytes for questionText to set.
     * @return This builder for chaining.
     */
    public Builder setQuestionTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      questionText_ = value;
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


    // @@protoc_insertion_point(builder_scope:org.inspirecenter.amazechallenge.proto.QuestionEntryProto)
  }

  // @@protoc_insertion_point(class_scope:org.inspirecenter.amazechallenge.proto.QuestionEntryProto)
  private static final org.inspirecenter.amazechallenge.proto.QuestionEntryProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.inspirecenter.amazechallenge.proto.QuestionEntryProto();
  }

  public static org.inspirecenter.amazechallenge.proto.QuestionEntryProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QuestionEntryProto>
      PARSER = new com.google.protobuf.AbstractParser<QuestionEntryProto>() {
    @Override
    public QuestionEntryProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new QuestionEntryProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<QuestionEntryProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<QuestionEntryProto> getParserForType() {
    return PARSER;
  }

  @Override
  public org.inspirecenter.amazechallenge.proto.QuestionEntryProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public org.inspirecenter.amazechallenge.model.QuestionEntry toObject() {    
        org.inspirecenter.amazechallenge.model.QuestionEntry item = new org.inspirecenter.amazechallenge.model.QuestionEntry();        
        item.setAnswerText(getAnswerText());        
        item.setId(getId());        
        item.setQuestionText(getQuestionText());        
        return item;        
    }    
    
}

