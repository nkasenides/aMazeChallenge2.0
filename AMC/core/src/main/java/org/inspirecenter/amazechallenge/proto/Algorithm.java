// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

/**
 * Protobuf enum {@code Algorithm}
 */
public enum Algorithm
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>MANY_SOLUTIONS_Algorithm = 0;</code>
   */
  MANY_SOLUTIONS_Algorithm(0, "Many solutions"),
  /**
   * <code>SPARSE_Algorithm = 1;</code>
   */
  SPARSE_Algorithm(1, "Sparse"),
  /**
   * <code>SINGLE_SOLUTION_Algorithm = 2;</code>
   */
  SINGLE_SOLUTION_Algorithm(2, "Single solution"),
  /**
   * <code>EMPTY_Algorithm = 3;</code>
   */
  EMPTY_Algorithm(3, "Empty"),
  UNRECOGNIZED(-1, "None"),
  ;

  /**
   * <code>MANY_SOLUTIONS_Algorithm = 0;</code>
   */
  public static final int MANY_SOLUTIONS_Algorithm_VALUE = 0;
  /**
   * <code>SPARSE_Algorithm = 1;</code>
   */
  public static final int SPARSE_Algorithm_VALUE = 1;
  /**
   * <code>SINGLE_SOLUTION_Algorithm = 2;</code>
   */
  public static final int SINGLE_SOLUTION_Algorithm_VALUE = 2;
  /**
   * <code>EMPTY_Algorithm = 3;</code>
   */
  public static final int EMPTY_Algorithm_VALUE = 3;


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
  public static Algorithm valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Algorithm forNumber(int value) {
    switch (value) {
      case 0: return MANY_SOLUTIONS_Algorithm;
      case 1: return SPARSE_Algorithm;
      case 2: return SINGLE_SOLUTION_Algorithm;
      case 3: return EMPTY_Algorithm;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Algorithm>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Algorithm> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Algorithm>() {
          public Algorithm findValueByNumber(int number) {
            return Algorithm.forNumber(number);
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
    return AMCProto.getDescriptor().getEnumTypes().get(5);
  }

  private static final Algorithm[] VALUES = values();

  public static Algorithm valueOf(
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
  private final String friendlyName;

  private Algorithm(int value, String friendlyName) {
    this.value = value;
    this.friendlyName = friendlyName;
  }

  public String getFriendlyName() {
    return friendlyName;
  }

  public static int getPosition(Algorithm algorithm) {
    final Algorithm [] algorithms = values();
    for (int i = 0; i < algorithms.length; i++) {
      if (algorithm == algorithms[i]) return i;
    }
    throw new RuntimeException("The algorithm '" + algorithm + "' is not a valid algorithm.");
  }

  // @@protoc_insertion_point(enum_scope:Algorithm)
}

