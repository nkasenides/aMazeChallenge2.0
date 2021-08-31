// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

import org.inspirecenter.amazechallenge.model.QuestionEntry;
import org.inspirecenter.amazechallenge.model.QuestionnaireEntry;

/**
 * Protobuf type {@code QuestionnaireEntryProto}
 */
public final class QuestionnaireEntryProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<QuestionnaireEntry> ,
    // @@protoc_insertion_point(message_implements:QuestionnaireEntryProto)
    QuestionnaireEntryProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QuestionnaireEntryProto.newBuilder() to construct.
  private QuestionnaireEntryProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QuestionnaireEntryProto() {
    challengeID_ = "";
    questionEntry_ = java.util.Collections.emptyList();
    id_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new QuestionnaireEntryProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private QuestionnaireEntryProto(
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

            challengeID_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              questionEntry_ = new java.util.ArrayList<QuestionEntryProto>();
              mutable_bitField0_ |= 0x00000001;
            }
            questionEntry_.add(
                input.readMessage(QuestionEntryProto.parser(), extensionRegistry));
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            id_ = s;
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
        questionEntry_ = java.util.Collections.unmodifiableList(questionEntry_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_QuestionnaireEntryProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_QuestionnaireEntryProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            QuestionnaireEntryProto.class, Builder.class);
  }

  public static final int CHALLENGEID_FIELD_NUMBER = 1;
  private volatile Object challengeID_;
  /**
   * <code>string challengeID = 1;</code>
   * @return The challengeID.
   */
  @Override
  public String getChallengeID() {
    Object ref = challengeID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      challengeID_ = s;
      return s;
    }
  }
  /**
   * <code>string challengeID = 1;</code>
   * @return The bytes for challengeID.
   */
  @Override
  public com.google.protobuf.ByteString
      getChallengeIDBytes() {
    Object ref = challengeID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      challengeID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QUESTIONENTRY_FIELD_NUMBER = 2;
  private java.util.List<QuestionEntryProto> questionEntry_;
  /**
   * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
   */
  @Override
  public java.util.List<QuestionEntryProto> getQuestionEntryList() {
    return questionEntry_;
  }
  /**
   * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
   */
  @Override
  public java.util.List<? extends QuestionEntryProtoOrBuilder>
      getQuestionEntryOrBuilderList() {
    return questionEntry_;
  }
  /**
   * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
   */
  @Override
  public int getQuestionEntryCount() {
    return questionEntry_.size();
  }
  /**
   * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
   */
  @Override
  public QuestionEntryProto getQuestionEntry(int index) {
    return questionEntry_.get(index);
  }
  /**
   * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
   */
  @Override
  public QuestionEntryProtoOrBuilder getQuestionEntryOrBuilder(
      int index) {
    return questionEntry_.get(index);
  }

  public static final int ID_FIELD_NUMBER = 3;
  private volatile Object id_;
  /**
   * <code>string id = 3;</code>
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
   * <code>string id = 3;</code>
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
    if (!getChallengeIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, challengeID_);
    }
    for (int i = 0; i < questionEntry_.size(); i++) {
      output.writeMessage(2, questionEntry_.get(i));
    }
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, id_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getChallengeIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, challengeID_);
    }
    for (int i = 0; i < questionEntry_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, questionEntry_.get(i));
    }
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, id_);
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
    if (!(obj instanceof QuestionnaireEntryProto)) {
      return super.equals(obj);
    }
    QuestionnaireEntryProto other = (QuestionnaireEntryProto) obj;

    if (!getChallengeID()
        .equals(other.getChallengeID())) return false;
    if (!getQuestionEntryList()
        .equals(other.getQuestionEntryList())) return false;
    if (!getId()
        .equals(other.getId())) return false;
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
    hash = (37 * hash) + CHALLENGEID_FIELD_NUMBER;
    hash = (53 * hash) + getChallengeID().hashCode();
    if (getQuestionEntryCount() > 0) {
      hash = (37 * hash) + QUESTIONENTRY_FIELD_NUMBER;
      hash = (53 * hash) + getQuestionEntryList().hashCode();
    }
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static QuestionnaireEntryProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static QuestionnaireEntryProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static QuestionnaireEntryProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static QuestionnaireEntryProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static QuestionnaireEntryProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static QuestionnaireEntryProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static QuestionnaireEntryProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static QuestionnaireEntryProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static QuestionnaireEntryProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static QuestionnaireEntryProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static QuestionnaireEntryProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static QuestionnaireEntryProto parseFrom(
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
  public static Builder newBuilder(QuestionnaireEntryProto prototype) {
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
   * Protobuf type {@code QuestionnaireEntryProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:QuestionnaireEntryProto)
      QuestionnaireEntryProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_QuestionnaireEntryProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_QuestionnaireEntryProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              QuestionnaireEntryProto.class, Builder.class);
    }

    // Construct using QuestionnaireEntryProto.newBuilder()
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
        getQuestionEntryFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      challengeID_ = "";

      if (questionEntryBuilder_ == null) {
        questionEntry_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        questionEntryBuilder_.clear();
      }
      id_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_QuestionnaireEntryProto_descriptor;
    }

    @Override
    public QuestionnaireEntryProto getDefaultInstanceForType() {
      return QuestionnaireEntryProto.getDefaultInstance();
    }

    @Override
    public QuestionnaireEntryProto build() {
      QuestionnaireEntryProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public QuestionnaireEntryProto buildPartial() {
      QuestionnaireEntryProto result = new QuestionnaireEntryProto(this);
      int from_bitField0_ = bitField0_;
      result.challengeID_ = challengeID_;
      if (questionEntryBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          questionEntry_ = java.util.Collections.unmodifiableList(questionEntry_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.questionEntry_ = questionEntry_;
      } else {
        result.questionEntry_ = questionEntryBuilder_.build();
      }
      result.id_ = id_;
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
      if (other instanceof QuestionnaireEntryProto) {
        return mergeFrom((QuestionnaireEntryProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(QuestionnaireEntryProto other) {
      if (other == QuestionnaireEntryProto.getDefaultInstance()) return this;
      if (!other.getChallengeID().isEmpty()) {
        challengeID_ = other.challengeID_;
        onChanged();
      }
      if (questionEntryBuilder_ == null) {
        if (!other.questionEntry_.isEmpty()) {
          if (questionEntry_.isEmpty()) {
            questionEntry_ = other.questionEntry_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureQuestionEntryIsMutable();
            questionEntry_.addAll(other.questionEntry_);
          }
          onChanged();
        }
      } else {
        if (!other.questionEntry_.isEmpty()) {
          if (questionEntryBuilder_.isEmpty()) {
            questionEntryBuilder_.dispose();
            questionEntryBuilder_ = null;
            questionEntry_ = other.questionEntry_;
            bitField0_ = (bitField0_ & ~0x00000001);
            questionEntryBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getQuestionEntryFieldBuilder() : null;
          } else {
            questionEntryBuilder_.addAllMessages(other.questionEntry_);
          }
        }
      }
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
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
      QuestionnaireEntryProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (QuestionnaireEntryProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private Object challengeID_ = "";
    /**
     * <code>string challengeID = 1;</code>
     * @return The challengeID.
     */
    public String getChallengeID() {
      Object ref = challengeID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        challengeID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string challengeID = 1;</code>
     * @return The bytes for challengeID.
     */
    public com.google.protobuf.ByteString
        getChallengeIDBytes() {
      Object ref = challengeID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        challengeID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string challengeID = 1;</code>
     * @param value The challengeID to set.
     * @return This builder for chaining.
     */
    public Builder setChallengeID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      challengeID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string challengeID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearChallengeID() {
      
      challengeID_ = getDefaultInstance().getChallengeID();
      onChanged();
      return this;
    }
    /**
     * <code>string challengeID = 1;</code>
     * @param value The bytes for challengeID to set.
     * @return This builder for chaining.
     */
    public Builder setChallengeIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      challengeID_ = value;
      onChanged();
      return this;
    }

    private java.util.List<QuestionEntryProto> questionEntry_ =
      java.util.Collections.emptyList();
    private void ensureQuestionEntryIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        questionEntry_ = new java.util.ArrayList<QuestionEntryProto>(questionEntry_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        QuestionEntryProto, QuestionEntryProto.Builder, QuestionEntryProtoOrBuilder> questionEntryBuilder_;

    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public java.util.List<QuestionEntryProto> getQuestionEntryList() {
      if (questionEntryBuilder_ == null) {
        return java.util.Collections.unmodifiableList(questionEntry_);
      } else {
        return questionEntryBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public int getQuestionEntryCount() {
      if (questionEntryBuilder_ == null) {
        return questionEntry_.size();
      } else {
        return questionEntryBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public QuestionEntryProto getQuestionEntry(int index) {
      if (questionEntryBuilder_ == null) {
        return questionEntry_.get(index);
      } else {
        return questionEntryBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder setQuestionEntry(
        int index, QuestionEntryProto value) {
      if (questionEntryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureQuestionEntryIsMutable();
        questionEntry_.set(index, value);
        onChanged();
      } else {
        questionEntryBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder setQuestionEntry(
        int index, QuestionEntryProto.Builder builderForValue) {
      if (questionEntryBuilder_ == null) {
        ensureQuestionEntryIsMutable();
        questionEntry_.set(index, builderForValue.build());
        onChanged();
      } else {
        questionEntryBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder addQuestionEntry(QuestionEntryProto value) {
      if (questionEntryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureQuestionEntryIsMutable();
        questionEntry_.add(value);
        onChanged();
      } else {
        questionEntryBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder addQuestionEntry(
        int index, QuestionEntryProto value) {
      if (questionEntryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureQuestionEntryIsMutable();
        questionEntry_.add(index, value);
        onChanged();
      } else {
        questionEntryBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder addQuestionEntry(
        QuestionEntryProto.Builder builderForValue) {
      if (questionEntryBuilder_ == null) {
        ensureQuestionEntryIsMutable();
        questionEntry_.add(builderForValue.build());
        onChanged();
      } else {
        questionEntryBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder addQuestionEntry(
        int index, QuestionEntryProto.Builder builderForValue) {
      if (questionEntryBuilder_ == null) {
        ensureQuestionEntryIsMutable();
        questionEntry_.add(index, builderForValue.build());
        onChanged();
      } else {
        questionEntryBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder addAllQuestionEntry(
        Iterable<? extends QuestionEntryProto> values) {
      if (questionEntryBuilder_ == null) {
        ensureQuestionEntryIsMutable();
        addAll(
            values, questionEntry_);
        onChanged();
      } else {
        questionEntryBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder clearQuestionEntry() {
      if (questionEntryBuilder_ == null) {
        questionEntry_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        questionEntryBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public Builder removeQuestionEntry(int index) {
      if (questionEntryBuilder_ == null) {
        ensureQuestionEntryIsMutable();
        questionEntry_.remove(index);
        onChanged();
      } else {
        questionEntryBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public QuestionEntryProto.Builder getQuestionEntryBuilder(
        int index) {
      return getQuestionEntryFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public QuestionEntryProtoOrBuilder getQuestionEntryOrBuilder(
        int index) {
      if (questionEntryBuilder_ == null) {
        return questionEntry_.get(index);  } else {
        return questionEntryBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public java.util.List<? extends QuestionEntryProtoOrBuilder>
         getQuestionEntryOrBuilderList() {
      if (questionEntryBuilder_ != null) {
        return questionEntryBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(questionEntry_);
      }
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public QuestionEntryProto.Builder addQuestionEntryBuilder() {
      return getQuestionEntryFieldBuilder().addBuilder(
          QuestionEntryProto.getDefaultInstance());
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public QuestionEntryProto.Builder addQuestionEntryBuilder(
        int index) {
      return getQuestionEntryFieldBuilder().addBuilder(
          index, QuestionEntryProto.getDefaultInstance());
    }
    /**
     * <code>repeated .QuestionEntryProto questionEntry = 2;</code>
     */
    public java.util.List<QuestionEntryProto.Builder>
         getQuestionEntryBuilderList() {
      return getQuestionEntryFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        QuestionEntryProto, QuestionEntryProto.Builder, QuestionEntryProtoOrBuilder>
        getQuestionEntryFieldBuilder() {
      if (questionEntryBuilder_ == null) {
        questionEntryBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            QuestionEntryProto, QuestionEntryProto.Builder, QuestionEntryProtoOrBuilder>(
                questionEntry_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        questionEntry_ = null;
      }
      return questionEntryBuilder_;
    }

    private Object id_ = "";
    /**
     * <code>string id = 3;</code>
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
     * <code>string id = 3;</code>
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
     * <code>string id = 3;</code>
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
     * <code>string id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 3;</code>
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


    // @@protoc_insertion_point(builder_scope:QuestionnaireEntryProto)
  }

  // @@protoc_insertion_point(class_scope:QuestionnaireEntryProto)
  private static final QuestionnaireEntryProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new QuestionnaireEntryProto();
  }

  public static QuestionnaireEntryProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QuestionnaireEntryProto>
      PARSER = new com.google.protobuf.AbstractParser<QuestionnaireEntryProto>() {
    @Override
    public QuestionnaireEntryProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new QuestionnaireEntryProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<QuestionnaireEntryProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<QuestionnaireEntryProto> getParserForType() {
    return PARSER;
  }

  @Override
  public QuestionnaireEntryProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public QuestionnaireEntry toObject() {
        QuestionnaireEntry item = new QuestionnaireEntry();
        item.setChallengeID(getChallengeID());        
        java.util.ArrayList<QuestionEntry> questionEntryList = new java.util.ArrayList<>();
        for (int i = 0; i < getQuestionEntryCount(); i++) {        
            questionEntryList.add(getQuestionEntry(i).toObject());            
        }        
        item.setQuestionEntry(questionEntryList);        
        item.setId(getId());        
        return item;        
    }    
    
        public java.util.List<QuestionEntryProto> getQuestionEntry() {
        return questionEntry_;
    }
    
}

