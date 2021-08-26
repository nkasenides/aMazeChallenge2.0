package com.nkasenides.amc.model;

import com.nkasenides.amc.proto.MatrixPositionProto;
import com.nkasenides.athlos.proto.Transmittable;
import com.raylabz.jsec.Hashing;

import java.io.Serializable;

public final class MatrixPosition implements Transmittable<MatrixPositionProto.Builder>, Serializable {

    private int row;
    private int col;

    public MatrixPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public MatrixPosition() {
        this.row = 0;
        this.col = 0;
    }

    public final int getRow() {
        return row;
    }

    public final void setRow(int row) {
        this.row = row;
    }

    public final int getCol() {
        return col;
    }

    public final void setCol(int col) {
        this.col = col;
    }

    public final GeoPosition toGeoPosition() {
        return new GeoPosition(col, row);
    }

    public final MatrixPositionProto.Builder toProto() {
        return MatrixPositionProto.newBuilder()
                .setRow(row)
                .setCol(col);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatrixPosition that = (MatrixPosition) o;

        if (row != that.row) return false;
        return col == that.col;
    }

    @Override
    public final int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    public final double distanceTo(MatrixPosition otherPosition) {
        return Math.sqrt((Math.pow((row - otherPosition.row), 2) + Math.pow((col - otherPosition.col), 2)));
    }

    public final String toHash() {
        return Hashing.hash(row + "," + col);
    }


    public MatrixPosition moveNorth() {
        return new MatrixPosition(row - 1, col);
    }

    public MatrixPosition moveSouth() {
        return new MatrixPosition(row + 1, col);
    }

    public MatrixPosition moveWest() {
        return new MatrixPosition(row, col - 1);
    }

    public MatrixPosition moveEast() {
        return new MatrixPosition(row, col + 1);
    }

}
