package com.nkasenides.amc.generation.generator;

import java.io.Serializable;

/**
 * @author Nearchos
 *         Created: 15-Aug-17
 */

class Position implements Serializable {

    private int row;
    private int col;

    public Position() {
        super();
    }

    public Position(final int row, final int col) {
        this();
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Position moveNorth() {
        return new Position(row - 1, col);
    }

    public Position moveSouth() {
        return new Position(row + 1, col);
    }

    public Position moveWest() {
        return new Position(row, col - 1);
    }

    public Position moveEast() {
        return new Position(row, col + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Position position = (Position) o;

        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "{" + row + "," + col + "}";
    }
}