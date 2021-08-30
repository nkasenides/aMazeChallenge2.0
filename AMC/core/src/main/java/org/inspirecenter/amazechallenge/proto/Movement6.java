// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

/**
 * Protobuf enum {@code Movement6}
 */
public enum Movement6
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>FORWARD6 = 0;</code>
   */
  FORWARD6(0),
  /**
   * <code>FORWARD_RIGHT = 1;</code>
   */
  FORWARD_RIGHT(1),
  /**
   * <code>BACKWARD_RIGHT = 2;</code>
   */
  BACKWARD_RIGHT(2),
  /**
   * <code>BACKWARD6 = 3;</code>
   */
  BACKWARD6(3),
  /**
   * <code>BACKWARD_LEFT = 4;</code>
   */
  BACKWARD_LEFT(4),
  /**
   * <code>FORWARD_LEFT = 5;</code>
   */
  FORWARD_LEFT(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>FORWARD6 = 0;</code>
   */
  public static final int FORWARD6_VALUE = 0;
  /**
   * <code>FORWARD_RIGHT = 1;</code>
   */
  public static final int FORWARD_RIGHT_VALUE = 1;
  /**
   * <code>BACKWARD_RIGHT = 2;</code>
   */
  public static final int BACKWARD_RIGHT_VALUE = 2;
  /**
   * <code>BACKWARD6 = 3;</code>
   */
  public static final int BACKWARD6_VALUE = 3;
  /**
   * <code>BACKWARD_LEFT = 4;</code>
   */
  public static final int BACKWARD_LEFT_VALUE = 4;
  /**
   * <code>FORWARD_LEFT = 5;</code>
   */
  public static final int FORWARD_LEFT_VALUE = 5;


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
  public static Movement6 valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Movement6 forNumber(int value) {
    switch (value) {
      case 0: return FORWARD6;
      case 1: return FORWARD_RIGHT;
      case 2: return BACKWARD_RIGHT;
      case 3: return BACKWARD6;
      case 4: return BACKWARD_LEFT;
      case 5: return FORWARD_LEFT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Movement6>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Movement6> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Movement6>() {
          public Movement6 findValueByNumber(int number) {
            return Movement6.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(20);
  }

  private static final Movement6[] VALUES = values();

  public static Movement6 valueOf(
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

  private Movement6(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Movement6)
}
