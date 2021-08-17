// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf enum {@code com.nkasenides.amc.proto.Movement4}
 */
public enum Movement4
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>FORWARD = 0;</code>
   */
  FORWARD(0),
  /**
   * <code>BACKWARD = 1;</code>
   */
  BACKWARD(1),
  /**
   * <code>LEFTWARD = 2;</code>
   */
  LEFTWARD(2),
  /**
   * <code>RIGHTWARD = 3;</code>
   */
  RIGHTWARD(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>FORWARD = 0;</code>
   */
  public static final int FORWARD_VALUE = 0;
  /**
   * <code>BACKWARD = 1;</code>
   */
  public static final int BACKWARD_VALUE = 1;
  /**
   * <code>LEFTWARD = 2;</code>
   */
  public static final int LEFTWARD_VALUE = 2;
  /**
   * <code>RIGHTWARD = 3;</code>
   */
  public static final int RIGHTWARD_VALUE = 3;


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
  public static Movement4 valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Movement4 forNumber(int value) {
    switch (value) {
      case 0: return FORWARD;
      case 1: return BACKWARD;
      case 2: return LEFTWARD;
      case 3: return RIGHTWARD;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Movement4>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Movement4> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Movement4>() {
          public Movement4 findValueByNumber(int number) {
            return Movement4.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(19);
  }

  private static final Movement4[] VALUES = values();

  public static Movement4 valueOf(
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

  private Movement4(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.Movement4)
}

