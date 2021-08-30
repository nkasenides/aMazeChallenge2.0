// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

/**
 * Protobuf type {@code ListChallengesResponse}
 */
public final class ListChallengesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ListChallengesResponse)
    ListChallengesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListChallengesResponse.newBuilder() to construct.
  private ListChallengesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListChallengesResponse() {
    challenges_ = java.util.Collections.emptyList();
    message_ = "";
    status_ = 0;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new ListChallengesResponse();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ListChallengesResponse(
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              challenges_ = new java.util.ArrayList<ChallengeProto>();
              mutable_bitField0_ |= 0x00000001;
            }
            challenges_.add(
                input.readMessage(ChallengeProto.parser(), extensionRegistry));
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            message_ = s;
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        challenges_ = java.util.Collections.unmodifiableList(challenges_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return AMCProto.internal_static_com_nkasenides_amc_proto_ListChallengesResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_com_nkasenides_amc_proto_ListChallengesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ListChallengesResponse.class, Builder.class);
  }

  /**
   * Protobuf enum {@code ListChallengesResponse.Status}
   */
  public enum Status
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>SERVER_ERROR = 0;</code>
     */
    SERVER_ERROR(0),
    /**
     * <code>NO_CHALLENGES = 1;</code>
     */
    NO_CHALLENGES(1),
    /**
     * <code>OK = 2;</code>
     */
    OK(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>SERVER_ERROR = 0;</code>
     */
    public static final int SERVER_ERROR_VALUE = 0;
    /**
     * <code>NO_CHALLENGES = 1;</code>
     */
    public static final int NO_CHALLENGES_VALUE = 1;
    /**
     * <code>OK = 2;</code>
     */
    public static final int OK_VALUE = 2;


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
        case 1: return NO_CHALLENGES;
        case 2: return OK;
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
      return ListChallengesResponse.getDescriptor().getEnumTypes().get(0);
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

    // @@protoc_insertion_point(enum_scope:ListChallengesResponse.Status)
  }

  public static final int CHALLENGES_FIELD_NUMBER = 1;
  private java.util.List<ChallengeProto> challenges_;
  /**
   * <code>repeated .ChallengeProto challenges = 1;</code>
   */
  @Override
  public java.util.List<ChallengeProto> getChallengesList() {
    return challenges_;
  }
  /**
   * <code>repeated .ChallengeProto challenges = 1;</code>
   */
  @Override
  public java.util.List<? extends ChallengeProtoOrBuilder>
      getChallengesOrBuilderList() {
    return challenges_;
  }
  /**
   * <code>repeated .ChallengeProto challenges = 1;</code>
   */
  @Override
  public int getChallengesCount() {
    return challenges_.size();
  }
  /**
   * <code>repeated .ChallengeProto challenges = 1;</code>
   */
  @Override
  public ChallengeProto getChallenges(int index) {
    return challenges_.get(index);
  }
  /**
   * <code>repeated .ChallengeProto challenges = 1;</code>
   */
  @Override
  public ChallengeProtoOrBuilder getChallengesOrBuilder(
      int index) {
    return challenges_.get(index);
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile Object message_;
  /**
   * <code>string message = 2;</code>
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
   * <code>string message = 2;</code>
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

  public static final int STATUS_FIELD_NUMBER = 3;
  private int status_;
  /**
   * <code>.ListChallengesResponse.Status status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  @Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.ListChallengesResponse.Status status = 3;</code>
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
    for (int i = 0; i < challenges_.size(); i++) {
      output.writeMessage(1, challenges_.get(i));
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
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
    for (int i = 0; i < challenges_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, challenges_.get(i));
    }
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
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
    if (!(obj instanceof ListChallengesResponse)) {
      return super.equals(obj);
    }
    ListChallengesResponse other = (ListChallengesResponse) obj;

    if (!getChallengesList()
        .equals(other.getChallengesList())) return false;
    if (!getMessage()
        .equals(other.getMessage())) return false;
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
    if (getChallengesCount() > 0) {
      hash = (37 * hash) + CHALLENGES_FIELD_NUMBER;
      hash = (53 * hash) + getChallengesList().hashCode();
    }
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ListChallengesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ListChallengesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ListChallengesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ListChallengesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ListChallengesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ListChallengesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ListChallengesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ListChallengesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ListChallengesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ListChallengesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ListChallengesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ListChallengesResponse parseFrom(
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
  public static Builder newBuilder(ListChallengesResponse prototype) {
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
   * Protobuf type {@code ListChallengesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ListChallengesResponse)
      ListChallengesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_ListChallengesResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_ListChallengesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ListChallengesResponse.class, Builder.class);
    }

    // Construct using ListChallengesResponse.newBuilder()
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
        getChallengesFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      if (challengesBuilder_ == null) {
        challenges_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        challengesBuilder_.clear();
      }
      message_ = "";

      status_ = 0;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_com_nkasenides_amc_proto_ListChallengesResponse_descriptor;
    }

    @Override
    public ListChallengesResponse getDefaultInstanceForType() {
      return ListChallengesResponse.getDefaultInstance();
    }

    @Override
    public ListChallengesResponse build() {
      ListChallengesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public ListChallengesResponse buildPartial() {
      ListChallengesResponse result = new ListChallengesResponse(this);
      int from_bitField0_ = bitField0_;
      if (challengesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          challenges_ = java.util.Collections.unmodifiableList(challenges_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.challenges_ = challenges_;
      } else {
        result.challenges_ = challengesBuilder_.build();
      }
      result.message_ = message_;
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
      if (other instanceof ListChallengesResponse) {
        return mergeFrom((ListChallengesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ListChallengesResponse other) {
      if (other == ListChallengesResponse.getDefaultInstance()) return this;
      if (challengesBuilder_ == null) {
        if (!other.challenges_.isEmpty()) {
          if (challenges_.isEmpty()) {
            challenges_ = other.challenges_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureChallengesIsMutable();
            challenges_.addAll(other.challenges_);
          }
          onChanged();
        }
      } else {
        if (!other.challenges_.isEmpty()) {
          if (challengesBuilder_.isEmpty()) {
            challengesBuilder_.dispose();
            challengesBuilder_ = null;
            challenges_ = other.challenges_;
            bitField0_ = (bitField0_ & ~0x00000001);
            challengesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getChallengesFieldBuilder() : null;
          } else {
            challengesBuilder_.addAllMessages(other.challenges_);
          }
        }
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
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
      ListChallengesResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ListChallengesResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<ChallengeProto> challenges_ =
      java.util.Collections.emptyList();
    private void ensureChallengesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        challenges_ = new java.util.ArrayList<ChallengeProto>(challenges_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        ChallengeProto, ChallengeProto.Builder, ChallengeProtoOrBuilder> challengesBuilder_;

    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public java.util.List<ChallengeProto> getChallengesList() {
      if (challengesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(challenges_);
      } else {
        return challengesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public int getChallengesCount() {
      if (challengesBuilder_ == null) {
        return challenges_.size();
      } else {
        return challengesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public ChallengeProto getChallenges(int index) {
      if (challengesBuilder_ == null) {
        return challenges_.get(index);
      } else {
        return challengesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder setChallenges(
        int index, ChallengeProto value) {
      if (challengesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChallengesIsMutable();
        challenges_.set(index, value);
        onChanged();
      } else {
        challengesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder setChallenges(
        int index, ChallengeProto.Builder builderForValue) {
      if (challengesBuilder_ == null) {
        ensureChallengesIsMutable();
        challenges_.set(index, builderForValue.build());
        onChanged();
      } else {
        challengesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder addChallenges(ChallengeProto value) {
      if (challengesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChallengesIsMutable();
        challenges_.add(value);
        onChanged();
      } else {
        challengesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder addChallenges(
        int index, ChallengeProto value) {
      if (challengesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChallengesIsMutable();
        challenges_.add(index, value);
        onChanged();
      } else {
        challengesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder addChallenges(
        ChallengeProto.Builder builderForValue) {
      if (challengesBuilder_ == null) {
        ensureChallengesIsMutable();
        challenges_.add(builderForValue.build());
        onChanged();
      } else {
        challengesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder addChallenges(
        int index, ChallengeProto.Builder builderForValue) {
      if (challengesBuilder_ == null) {
        ensureChallengesIsMutable();
        challenges_.add(index, builderForValue.build());
        onChanged();
      } else {
        challengesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder addAllChallenges(
        Iterable<? extends ChallengeProto> values) {
      if (challengesBuilder_ == null) {
        ensureChallengesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, challenges_);
        onChanged();
      } else {
        challengesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder clearChallenges() {
      if (challengesBuilder_ == null) {
        challenges_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        challengesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public Builder removeChallenges(int index) {
      if (challengesBuilder_ == null) {
        ensureChallengesIsMutable();
        challenges_.remove(index);
        onChanged();
      } else {
        challengesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public ChallengeProto.Builder getChallengesBuilder(
        int index) {
      return getChallengesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public ChallengeProtoOrBuilder getChallengesOrBuilder(
        int index) {
      if (challengesBuilder_ == null) {
        return challenges_.get(index);  } else {
        return challengesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public java.util.List<? extends ChallengeProtoOrBuilder>
         getChallengesOrBuilderList() {
      if (challengesBuilder_ != null) {
        return challengesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(challenges_);
      }
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public ChallengeProto.Builder addChallengesBuilder() {
      return getChallengesFieldBuilder().addBuilder(
          ChallengeProto.getDefaultInstance());
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public ChallengeProto.Builder addChallengesBuilder(
        int index) {
      return getChallengesFieldBuilder().addBuilder(
          index, ChallengeProto.getDefaultInstance());
    }
    /**
     * <code>repeated .ChallengeProto challenges = 1;</code>
     */
    public java.util.List<ChallengeProto.Builder>
         getChallengesBuilderList() {
      return getChallengesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        ChallengeProto, ChallengeProto.Builder, ChallengeProtoOrBuilder>
        getChallengesFieldBuilder() {
      if (challengesBuilder_ == null) {
        challengesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            ChallengeProto, ChallengeProto.Builder, ChallengeProtoOrBuilder>(
                challenges_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        challenges_ = null;
      }
      return challengesBuilder_;
    }

    private Object message_ = "";
    /**
     * <code>string message = 2;</code>
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
     * <code>string message = 2;</code>
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
     * <code>string message = 2;</code>
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
     * <code>string message = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
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

    private int status_ = 0;
    /**
     * <code>.ListChallengesResponse.Status status = 3;</code>
     * @return The enum numeric value on the wire for status.
     */
    @Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.ListChallengesResponse.Status status = 3;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.ListChallengesResponse.Status status = 3;</code>
     * @return The status.
     */
    @Override
    public Status getStatus() {
      @SuppressWarnings("deprecation")
      Status result = Status.valueOf(status_);
      return result == null ? Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.ListChallengesResponse.Status status = 3;</code>
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
     * <code>.ListChallengesResponse.Status status = 3;</code>
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


    // @@protoc_insertion_point(builder_scope:ListChallengesResponse)
  }

  // @@protoc_insertion_point(class_scope:ListChallengesResponse)
  private static final ListChallengesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ListChallengesResponse();
  }

  public static ListChallengesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListChallengesResponse>
      PARSER = new com.google.protobuf.AbstractParser<ListChallengesResponse>() {
    @Override
    public ListChallengesResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ListChallengesResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListChallengesResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<ListChallengesResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public ListChallengesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
