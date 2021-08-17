// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf enum {@code com.nkasenides.amc.proto.Direction6}
 */
public enum Direction6
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NORTH6 = 0;</code>
   */
  NORTH6(0),
  /**
   * <code>NORTH_EAST = 1;</code>
   */
  NORTH_EAST(1),
  /**
   * <code>SOUTH_EAST = 2;</code>
   */
  SOUTH_EAST(2),
  /**
   * <code>SOUTH6 = 3;</code>
   */
  SOUTH6(3),
  /**
   * <code>SOUTH_WEST = 4;</code>
   */
  SOUTH_WEST(4),
  /**
   * <code>NORTH_WEST = 5;</code>
   */
  NORTH_WEST(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NORTH6 = 0;</code>
   */
  public static final int NORTH6_VALUE = 0;
  /**
   * <code>NORTH_EAST = 1;</code>
   */
  public static final int NORTH_EAST_VALUE = 1;
  /**
   * <code>SOUTH_EAST = 2;</code>
   */
  public static final int SOUTH_EAST_VALUE = 2;
  /**
   * <code>SOUTH6 = 3;</code>
   */
  public static final int SOUTH6_VALUE = 3;
  /**
   * <code>SOUTH_WEST = 4;</code>
   */
  public static final int SOUTH_WEST_VALUE = 4;
  /**
   * <code>NORTH_WEST = 5;</code>
   */
  public static final int NORTH_WEST_VALUE = 5;


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
  public static Direction6 valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Direction6 forNumber(int value) {
    switch (value) {
      case 0: return NORTH6;
      case 1: return NORTH_EAST;
      case 2: return SOUTH_EAST;
      case 3: return SOUTH6;
      case 4: return SOUTH_WEST;
      case 5: return NORTH_WEST;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Direction6>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Direction6> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Direction6>() {
          public Direction6 findValueByNumber(int number) {
            return Direction6.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(17);
  }

  private static final Direction6[] VALUES = values();

  public static Direction6 valueOf(
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

  private Direction6(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.Direction6)
}

