// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/AMCProto.proto

package org.inspirecenter.amazechallenge.proto;

import org.inspirecenter.amazechallenge.model.MatrixPosition;

/**
 * Protobuf type {@code MatrixPositionProto}
 */
public final class MatrixPositionProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<MatrixPosition> ,
    // @@protoc_insertion_point(message_implements:MatrixPositionProto)
    MatrixPositionProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MatrixPositionProto.newBuilder() to construct.
  private MatrixPositionProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MatrixPositionProto() {
    cellHash_ = "";
    chunkHash_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new MatrixPositionProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MatrixPositionProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            row_ = input.readSInt32();
            break;
          }
          case 16: {

            col_ = input.readSInt32();
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            cellHash_ = s;
            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();

            chunkHash_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_MatrixPositionProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_MatrixPositionProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            MatrixPositionProto.class, Builder.class);
  }

  public static final int ROW_FIELD_NUMBER = 1;
  private int row_;
  /**
   * <code>sint32 row = 1;</code>
   * @return The row.
   */
  @Override
  public int getRow() {
    return row_;
  }

  public static final int COL_FIELD_NUMBER = 2;
  private int col_;
  /**
   * <code>sint32 col = 2;</code>
   * @return The col.
   */
  @Override
  public int getCol() {
    return col_;
  }

  public static final int CELLHASH_FIELD_NUMBER = 3;
  private volatile Object cellHash_;
  /**
   * <code>string cellHash = 3;</code>
   * @return The cellHash.
   */
  @Override
  public String getCellHash() {
    Object ref = cellHash_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      cellHash_ = s;
      return s;
    }
  }
  /**
   * <code>string cellHash = 3;</code>
   * @return The bytes for cellHash.
   */
  @Override
  public com.google.protobuf.ByteString
      getCellHashBytes() {
    Object ref = cellHash_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      cellHash_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHUNKHASH_FIELD_NUMBER = 4;
  private volatile Object chunkHash_;
  /**
   * <code>string chunkHash = 4;</code>
   * @return The chunkHash.
   */
  @Override
  public String getChunkHash() {
    Object ref = chunkHash_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      chunkHash_ = s;
      return s;
    }
  }
  /**
   * <code>string chunkHash = 4;</code>
   * @return The bytes for chunkHash.
   */
  @Override
  public com.google.protobuf.ByteString
      getChunkHashBytes() {
    Object ref = chunkHash_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      chunkHash_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (row_ != 0) {
      output.writeSInt32(1, row_);
    }
    if (col_ != 0) {
      output.writeSInt32(2, col_);
    }
    if (!getCellHashBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, cellHash_);
    }
    if (!getChunkHashBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, chunkHash_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (row_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(1, row_);
    }
    if (col_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt32Size(2, col_);
    }
    if (!getCellHashBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, cellHash_);
    }
    if (!getChunkHashBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, chunkHash_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof MatrixPositionProto)) {
      return super.equals(obj);
    }
    MatrixPositionProto other = (MatrixPositionProto) obj;

    if (getRow()
        != other.getRow()) return false;
    if (getCol()
        != other.getCol()) return false;
    if (!getCellHash()
        .equals(other.getCellHash())) return false;
    if (!getChunkHash()
        .equals(other.getChunkHash())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ROW_FIELD_NUMBER;
    hash = (53 * hash) + getRow();
    hash = (37 * hash) + COL_FIELD_NUMBER;
    hash = (53 * hash) + getCol();
    hash = (37 * hash) + CELLHASH_FIELD_NUMBER;
    hash = (53 * hash) + getCellHash().hashCode();
    hash = (37 * hash) + CHUNKHASH_FIELD_NUMBER;
    hash = (53 * hash) + getChunkHash().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static MatrixPositionProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MatrixPositionProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MatrixPositionProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MatrixPositionProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MatrixPositionProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MatrixPositionProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MatrixPositionProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MatrixPositionProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static MatrixPositionProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static MatrixPositionProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static MatrixPositionProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MatrixPositionProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(MatrixPositionProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code MatrixPositionProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:MatrixPositionProto)
      MatrixPositionProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_MatrixPositionProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_MatrixPositionProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MatrixPositionProto.class, Builder.class);
    }

    // Construct using MatrixPositionProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      row_ = 0;

      col_ = 0;

      cellHash_ = "";

      chunkHash_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AMCProto.internal_static_org_inspirecenter_amazechallenge_proto_MatrixPositionProto_descriptor;
    }

    @Override
    public MatrixPositionProto getDefaultInstanceForType() {
      return MatrixPositionProto.getDefaultInstance();
    }

    @Override
    public MatrixPositionProto build() {
      MatrixPositionProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public MatrixPositionProto buildPartial() {
      MatrixPositionProto result = new MatrixPositionProto(this);
      result.row_ = row_;
      result.col_ = col_;
      result.cellHash_ = cellHash_;
      result.chunkHash_ = chunkHash_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof MatrixPositionProto) {
        return mergeFrom((MatrixPositionProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(MatrixPositionProto other) {
      if (other == MatrixPositionProto.getDefaultInstance()) return this;
      if (other.getRow() != 0) {
        setRow(other.getRow());
      }
      if (other.getCol() != 0) {
        setCol(other.getCol());
      }
      if (!other.getCellHash().isEmpty()) {
        cellHash_ = other.cellHash_;
        onChanged();
      }
      if (!other.getChunkHash().isEmpty()) {
        chunkHash_ = other.chunkHash_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      MatrixPositionProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (MatrixPositionProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int row_ ;
    /**
     * <code>sint32 row = 1;</code>
     * @return The row.
     */
    @Override
    public int getRow() {
      return row_;
    }
    /**
     * <code>sint32 row = 1;</code>
     * @param value The row to set.
     * @return This builder for chaining.
     */
    public Builder setRow(int value) {
      
      row_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 row = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearRow() {
      
      row_ = 0;
      onChanged();
      return this;
    }

    private int col_ ;
    /**
     * <code>sint32 col = 2;</code>
     * @return The col.
     */
    @Override
    public int getCol() {
      return col_;
    }
    /**
     * <code>sint32 col = 2;</code>
     * @param value The col to set.
     * @return This builder for chaining.
     */
    public Builder setCol(int value) {
      
      col_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint32 col = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCol() {
      
      col_ = 0;
      onChanged();
      return this;
    }

    private Object cellHash_ = "";
    /**
     * <code>string cellHash = 3;</code>
     * @return The cellHash.
     */
    public String getCellHash() {
      Object ref = cellHash_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        cellHash_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string cellHash = 3;</code>
     * @return The bytes for cellHash.
     */
    public com.google.protobuf.ByteString
        getCellHashBytes() {
      Object ref = cellHash_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        cellHash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string cellHash = 3;</code>
     * @param value The cellHash to set.
     * @return This builder for chaining.
     */
    public Builder setCellHash(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      cellHash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string cellHash = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCellHash() {
      
      cellHash_ = getDefaultInstance().getCellHash();
      onChanged();
      return this;
    }
    /**
     * <code>string cellHash = 3;</code>
     * @param value The bytes for cellHash to set.
     * @return This builder for chaining.
     */
    public Builder setCellHashBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      cellHash_ = value;
      onChanged();
      return this;
    }

    private Object chunkHash_ = "";
    /**
     * <code>string chunkHash = 4;</code>
     * @return The chunkHash.
     */
    public String getChunkHash() {
      Object ref = chunkHash_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        chunkHash_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string chunkHash = 4;</code>
     * @return The bytes for chunkHash.
     */
    public com.google.protobuf.ByteString
        getChunkHashBytes() {
      Object ref = chunkHash_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        chunkHash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string chunkHash = 4;</code>
     * @param value The chunkHash to set.
     * @return This builder for chaining.
     */
    public Builder setChunkHash(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      chunkHash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string chunkHash = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearChunkHash() {
      
      chunkHash_ = getDefaultInstance().getChunkHash();
      onChanged();
      return this;
    }
    /**
     * <code>string chunkHash = 4;</code>
     * @param value The bytes for chunkHash to set.
     * @return This builder for chaining.
     */
    public Builder setChunkHashBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      chunkHash_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:MatrixPositionProto)
  }

  // @@protoc_insertion_point(class_scope:MatrixPositionProto)
  private static final MatrixPositionProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new MatrixPositionProto();
  }

  public static MatrixPositionProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MatrixPositionProto>
      PARSER = new com.google.protobuf.AbstractParser<MatrixPositionProto>() {
    @Override
    public MatrixPositionProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MatrixPositionProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MatrixPositionProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<MatrixPositionProto> getParserForType() {
    return PARSER;
  }

  @Override
  public MatrixPositionProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public MatrixPosition toObject() {
        MatrixPosition item = new MatrixPosition();
        item.setCol(getCol());        
        item.setRow(getRow());        
        return item;        
    }    
    


    public final double distanceTo(MatrixPositionProto otherPosition) {
        return Math.sqrt((Math.pow((getRow() - otherPosition.getRow()), 2) + Math.pow((getCol() - otherPosition.getCol()), 2)));
    }

    public final String toHash() {
        return com.raylabz.jsec.Hashing.hash(getRow() + "," + getCol());
    }
    public final GeoPositionProto toGeoPosition() {
      return GeoPositionProto.newBuilder().setX(getCol()).setY(getRow()).build();
    }

}

