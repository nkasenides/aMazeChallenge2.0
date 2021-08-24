// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf enum {@code com.nkasenides.amc.proto.Bias}
 */
public enum Bias
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>PENALTY_Bias = 0;</code>
   */
  PENALTY_Bias(0),
  /**
   * <code>NONE_Bias = 1;</code>
   */
  NONE_Bias(1),
  /**
   * <code>REWARD_Bias = 2;</code>
   */
  REWARD_Bias(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>PENALTY_Bias = 0;</code>
   */
  public static final int PENALTY_Bias_VALUE = 0;
  /**
   * <code>NONE_Bias = 1;</code>
   */
  public static final int NONE_Bias_VALUE = 1;
  /**
   * <code>REWARD_Bias = 2;</code>
   */
  public static final int REWARD_Bias_VALUE = 2;


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
  public static Bias valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Bias forNumber(int value) {
    switch (value) {
      case 0: return PENALTY_Bias;
      case 1: return NONE_Bias;
      case 2: return REWARD_Bias;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Bias>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Bias> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Bias>() {
          public Bias findValueByNumber(int number) {
            return Bias.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(4);
  }

  private static final Bias[] VALUES = values();

  public static Bias valueOf(
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

  private Bias(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.Bias)
}

