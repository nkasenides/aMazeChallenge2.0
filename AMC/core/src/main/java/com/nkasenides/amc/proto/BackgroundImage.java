// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package com.nkasenides.amc.proto;

/**
 * Protobuf enum {@code com.nkasenides.amc.proto.BackgroundImage}
 */
public enum BackgroundImage
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>TEXTURE_WATER_BackgroundImage = 0;</code>
   */
  TEXTURE_WATER_BackgroundImage(0, "Water", "texture_water", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_ROCKY_BackgroundImage = 1;</code>
   */
  TEXTURE_ROCKY_BackgroundImage(1, "Rocky", "texture_rocky", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_SPACE_BackgroundImage = 2;</code>
   */
  TEXTURE_SPACE_BackgroundImage(2, "Space", "texture_space", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_METAL_BackgroundImage = 3;</code>
   */
  TEXTURE_METAL_BackgroundImage(3, "Metal", "texture_metal", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_MOON_BackgroundImage = 4;</code>
   */
  TEXTURE_MOON_BackgroundImage(4, "Moon", "texture_moon", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_LAVA_BackgroundImage = 5;</code>
   */
  TEXTURE_LAVA_BackgroundImage(5, "Lava", "texture_lava", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_GRAVEL_BackgroundImage = 6;</code>
   */
  TEXTURE_GRAVEL_BackgroundImage(6, "Gravel", "texture_gravel", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_WOOD_BackgroundImage = 7;</code>
   */
  TEXTURE_WOOD_BackgroundImage(7, "Wood", "texture_wood", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_GRASS_BackgroundImage = 8;</code>
   */
  TEXTURE_GRASS_BackgroundImage(8, "Grass", "texture_grass", BackgroundImageType.JPG_BackgroundImageType),
  /**
   * <code>TEXTURE_TILES_BackgroundImage = 9;</code>
   */
  TEXTURE_TILES_BackgroundImage(9, "Tiles", "texture_tiles", BackgroundImageType.JPG_BackgroundImageType),
  UNRECOGNIZED(-1, "", "", BackgroundImageType.JPG_BackgroundImageType),
  ;

  /**
   * <code>TEXTURE_WATER_BackgroundImage = 0;</code>
   */
  public static final int TEXTURE_WATER_BackgroundImage_VALUE = 0;
  /**
   * <code>TEXTURE_ROCKY_BackgroundImage = 1;</code>
   */
  public static final int TEXTURE_ROCKY_BackgroundImage_VALUE = 1;
  /**
   * <code>TEXTURE_SPACE_BackgroundImage = 2;</code>
   */
  public static final int TEXTURE_SPACE_BackgroundImage_VALUE = 2;
  /**
   * <code>TEXTURE_METAL_BackgroundImage = 3;</code>
   */
  public static final int TEXTURE_METAL_BackgroundImage_VALUE = 3;
  /**
   * <code>TEXTURE_MOON_BackgroundImage = 4;</code>
   */
  public static final int TEXTURE_MOON_BackgroundImage_VALUE = 4;
  /**
   * <code>TEXTURE_LAVA_BackgroundImage = 5;</code>
   */
  public static final int TEXTURE_LAVA_BackgroundImage_VALUE = 5;
  /**
   * <code>TEXTURE_GRAVEL_BackgroundImage = 6;</code>
   */
  public static final int TEXTURE_GRAVEL_BackgroundImage_VALUE = 6;
  /**
   * <code>TEXTURE_WOOD_BackgroundImage = 7;</code>
   */
  public static final int TEXTURE_WOOD_BackgroundImage_VALUE = 7;
  /**
   * <code>TEXTURE_GRASS_BackgroundImage = 8;</code>
   */
  public static final int TEXTURE_GRASS_BackgroundImage_VALUE = 8;
  /**
   * <code>TEXTURE_TILES_BackgroundImage = 9;</code>
   */
  public static final int TEXTURE_TILES_BackgroundImage_VALUE = 9;


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
  public static BackgroundImage valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static BackgroundImage forNumber(int value) {
    switch (value) {
      case 0: return TEXTURE_WATER_BackgroundImage;
      case 1: return TEXTURE_ROCKY_BackgroundImage;
      case 2: return TEXTURE_SPACE_BackgroundImage;
      case 3: return TEXTURE_METAL_BackgroundImage;
      case 4: return TEXTURE_MOON_BackgroundImage;
      case 5: return TEXTURE_LAVA_BackgroundImage;
      case 6: return TEXTURE_GRAVEL_BackgroundImage;
      case 7: return TEXTURE_WOOD_BackgroundImage;
      case 8: return TEXTURE_GRASS_BackgroundImage;
      case 9: return TEXTURE_TILES_BackgroundImage;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<BackgroundImage>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      BackgroundImage> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<BackgroundImage>() {
          public BackgroundImage findValueByNumber(int number) {
            return BackgroundImage.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(7);
  }

  private static final BackgroundImage[] VALUES = values();

  public static BackgroundImage valueOf(
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
  private final String name;
  private final String resourceName;
  private final BackgroundImageType type;

  private BackgroundImage(int value, String name, String resourceName, BackgroundImageType type) {
    this.value = value;
    this.name = name;
    this.resourceName = resourceName;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getResourceName() {
    return resourceName;
  }

  public BackgroundImageType getType() {
    return type;
  }

  // @@protoc_insertion_point(enum_scope:com.nkasenides.amc.proto.BackgroundImage)
}

