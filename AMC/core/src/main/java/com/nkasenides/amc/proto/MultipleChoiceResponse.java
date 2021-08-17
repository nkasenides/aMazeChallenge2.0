// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf enum {@code com.nkasenides.amc.proto.MultipleChoiceResponse}
 */
public enum MultipleChoiceResponse
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>CHOICE_1_MultipleChoiceResponse = 0;</code>
   */
  CHOICE_1_MultipleChoiceResponse(0),
  /**
   * <code>CHOICE_4_MultipleChoiceResponse = 1;</code>
   */
  CHOICE_4_MultipleChoiceResponse(1),
  /**
   * <code>CHOICE_2_MultipleChoiceResponse = 2;</code>
   */
  CHOICE_2_MultipleChoiceResponse(2),
  /**
   * <code>CHOICE_3_MultipleChoiceResponse = 3;</code>
   */
  CHOICE_3_MultipleChoiceResponse(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>CHOICE_1_MultipleChoiceResponse = 0;</code>
   */
  public static final int CHOICE_1_MultipleChoiceResponse_VALUE = 0;
  /**
   * <code>CHOICE_4_MultipleChoiceResponse = 1;</code>
   */
  public static final int CHOICE_4_MultipleChoiceResponse_VALUE = 1;
  /**
   * <code>CHOICE_2_MultipleChoiceResponse = 2;</code>
   */
  public static final int CHOICE_2_MultipleChoiceResponse_VALUE = 2;
  /**
   * <code>CHOICE_3_MultipleChoiceResponse = 3;</code>
   */
  public static final int CHOICE_3_MultipleChoiceResponse_VALUE = 3;


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
  public static MultipleChoiceResponse valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static MultipleChoiceResponse forNumber(int value) {
    switch (value) {
      case 0: return CHOICE_1_MultipleChoiceResponse;
      case 1: return CHOICE_4_MultipleChoiceResponse;
      case 2: return CHOICE_2_MultipleChoiceResponse;
      case 3: return CHOICE_3_MultipleChoiceResponse;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MultipleChoiceResponse>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MultipleChoiceResponse> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MultipleChoiceResponse>() {
          public MultipleChoiceResponse findValueByNumber(int number) {
            return MultipleChoiceResponse.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(13);
  }

  private static final MultipleChoiceResponse[] VALUES = values();

  public static MultipleChoiceResponse valueOf(
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

  private MultipleChoiceResponse(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.MultipleChoiceResponse)
}

