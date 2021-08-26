package org.inspirecenter.amazechallenge.model;

import org.inspirecenter.amazechallenge.proto.GeoPositionProto;
import com.nkasenides.athlos.proto.Transmittable;
import com.raylabz.jsec.Hashing;

public final class GeoPosition implements Transmittable<GeoPositionProto.Builder> {

    private float x = 0;
    private float y = 0;
    private float z = 0;

    public GeoPosition(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public GeoPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public GeoPosition() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public final float getX() {
        return x;
    }

    public final void setX(float x) {
        this.x = x;
    }

    public final float getY() {
        return y;
    }

    public final void setY(float y) {
        this.y = y;
    }

    public final float getZ() {
        return z;
    }

    public final void setZ(float z) {
        this.z = z;
    }

    public final MatrixPosition toMatrixPosition() {
        return new MatrixPosition(Math.round(y), Math.round(x));
    }

    public final GeoPositionProto.Builder toProto() {
        return GeoPositionProto.newBuilder()
                .setX(x)
                .setY(y)
                .setZ(z);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoPosition that = (GeoPosition) o;

        if (Float.compare(that.x, x) != 0) return false;
        if (Float.compare(that.y, y) != 0) return false;
        return Float.compare(that.z, z) == 0;
    }

    @Override
    public final int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result = 31 * result + (z != +0.0f ? Float.floatToIntBits(z) : 0);
        return result;
    }

    public final double distanceTo(GeoPosition otherGeoPosition) {
        return Math.sqrt((Math.pow((x - otherGeoPosition.x), 2) + Math.pow((y - otherGeoPosition.y), 2) + Math.pow(z - otherGeoPosition.z, 2)));
    }

    public final String toHash() {
        return Hashing.hash(x + "," + y + "," + z);
    }

}