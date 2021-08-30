// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

/**
 * Protobuf enum {@code AudioFormat}
 */
public enum AudioFormat
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>MP4_AudioFormat = 0;</code>
   */
  MP4_AudioFormat(0),
  /**
   * <code>MP3_AudioFormat = 1;</code>
   */
  MP3_AudioFormat(1),
  /**
   * <code>UNDEFINED_FORMAT_AudioFormat = 2;</code>
   */
  UNDEFINED_FORMAT_AudioFormat(2),
  /**
   * <code>WAV_AudioFormat = 3;</code>
   */
  WAV_AudioFormat(3),
  /**
   * <code>OGG_AudioFormat = 4;</code>
   */
  OGG_AudioFormat(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>MP4_AudioFormat = 0;</code>
   */
  public static final int MP4_AudioFormat_VALUE = 0;
  /**
   * <code>MP3_AudioFormat = 1;</code>
   */
  public static final int MP3_AudioFormat_VALUE = 1;
  /**
   * <code>UNDEFINED_FORMAT_AudioFormat = 2;</code>
   */
  public static final int UNDEFINED_FORMAT_AudioFormat_VALUE = 2;
  /**
   * <code>WAV_AudioFormat = 3;</code>
   */
  public static final int WAV_AudioFormat_VALUE = 3;
  /**
   * <code>OGG_AudioFormat = 4;</code>
   */
  public static final int OGG_AudioFormat_VALUE = 4;


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
  public static AudioFormat valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static AudioFormat forNumber(int value) {
    switch (value) {
      case 0: return MP4_AudioFormat;
      case 1: return MP3_AudioFormat;
      case 2: return UNDEFINED_FORMAT_AudioFormat;
      case 3: return WAV_AudioFormat;
      case 4: return OGG_AudioFormat;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<AudioFormat>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      AudioFormat> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<AudioFormat>() {
          public AudioFormat findValueByNumber(int number) {
            return AudioFormat.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(10);
  }

  private static final AudioFormat[] VALUES = values();

  public static AudioFormat valueOf(
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

  private AudioFormat(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:AudioFormat)
}
