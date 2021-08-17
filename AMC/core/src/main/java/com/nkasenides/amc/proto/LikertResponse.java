// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf enum {@code com.nkasenides.amc.proto.LikertResponse}
 */
public enum LikertResponse
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>POSITIVE_LikertResponse = 0;</code>
   */
  POSITIVE_LikertResponse(0),
  /**
   * <code>NEGATIVE_LikertResponse = 1;</code>
   */
  NEGATIVE_LikertResponse(1),
  /**
   * <code>NEUTRAL_LikertResponse = 2;</code>
   */
  NEUTRAL_LikertResponse(2),
  /**
   * <code>VERY_POSITIVE_LikertResponse = 3;</code>
   */
  VERY_POSITIVE_LikertResponse(3),
  /**
   * <code>VERY_NEGATIVE_LikertResponse = 4;</code>
   */
  VERY_NEGATIVE_LikertResponse(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>POSITIVE_LikertResponse = 0;</code>
   */
  public static final int POSITIVE_LikertResponse_VALUE = 0;
  /**
   * <code>NEGATIVE_LikertResponse = 1;</code>
   */
  public static final int NEGATIVE_LikertResponse_VALUE = 1;
  /**
   * <code>NEUTRAL_LikertResponse = 2;</code>
   */
  public static final int NEUTRAL_LikertResponse_VALUE = 2;
  /**
   * <code>VERY_POSITIVE_LikertResponse = 3;</code>
   */
  public static final int VERY_POSITIVE_LikertResponse_VALUE = 3;
  /**
   * <code>VERY_NEGATIVE_LikertResponse = 4;</code>
   */
  public static final int VERY_NEGATIVE_LikertResponse_VALUE = 4;


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
  public static LikertResponse valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static LikertResponse forNumber(int value) {
    switch (value) {
      case 0: return POSITIVE_LikertResponse;
      case 1: return NEGATIVE_LikertResponse;
      case 2: return NEUTRAL_LikertResponse;
      case 3: return VERY_POSITIVE_LikertResponse;
      case 4: return VERY_NEGATIVE_LikertResponse;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<LikertResponse>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      LikertResponse> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<LikertResponse>() {
          public LikertResponse findValueByNumber(int number) {
            return LikertResponse.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final LikertResponse[] VALUES = values();

  public static LikertResponse valueOf(
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

  private LikertResponse(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.LikertResponse)
}

