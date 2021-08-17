// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf enum {@code com.nkasenides.amc.proto.AudioType}
 */
public enum AudioType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>AMBIENT_AudioType = 0;</code>
   */
  AMBIENT_AudioType(0),
  /**
   * <code>NONE_AudioType = 1;</code>
   */
  NONE_AudioType(1),
  /**
   * <code>EVENT_AudioType = 2;</code>
   */
  EVENT_AudioType(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>AMBIENT_AudioType = 0;</code>
   */
  public static final int AMBIENT_AudioType_VALUE = 0;
  /**
   * <code>NONE_AudioType = 1;</code>
   */
  public static final int NONE_AudioType_VALUE = 1;
  /**
   * <code>EVENT_AudioType = 2;</code>
   */
  public static final int EVENT_AudioType_VALUE = 2;


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
  public static AudioType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static AudioType forNumber(int value) {
    switch (value) {
      case 0: return AMBIENT_AudioType;
      case 1: return NONE_AudioType;
      case 2: return EVENT_AudioType;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<AudioType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      AudioType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<AudioType>() {
          public AudioType findValueByNumber(int number) {
            return AudioType.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(9);
  }

  private static final AudioType[] VALUES = values();

  public static AudioType valueOf(
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

  private AudioType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.AudioType)
}

