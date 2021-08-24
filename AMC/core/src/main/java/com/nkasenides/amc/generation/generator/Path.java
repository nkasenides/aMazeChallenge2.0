package com.nkasenides.amc.generation.generator;

import com.nkasenides.amc.model.MatrixPosition;

import java.util.Vector;

class Path {

    private Vector<MatrixPosition> orderedPositions = new Vector<>();

    Path() {
        // constructs empty path
    }

    void addNextPoint(final MatrixPosition position) {
        if(!orderedPositions.isEmpty()) {
            // check if new point is adjacent to last one
            final MatrixPosition lastPosition = orderedPositions.lastElement();
            if(areIdentical(lastPosition, position)) throw new RuntimeException("Identical with last position" + position);
            if(!areAdjacent(lastPosition, position)) throw new RuntimeException("Cannot add a non-adjacent position: " + position + " to path: " + this);
            if(positionCrossesPath(position, this)) throw new RuntimeException("Cannot add a position that crosses the path: " + position);
        }
        orderedPositions.add(position);
    }

    private MatrixPosition getSourcePosition() {
        return orderedPositions.firstElement();
    }

    MatrixPosition getTargetPosition() {
        return orderedPositions.lastElement();
    }

    int getSize() {
        return orderedPositions.size();
    }

    boolean isEmpty() {
        return orderedPositions.isEmpty();
    }

    void clear() {
        orderedPositions.clear();
    }

    MatrixPosition getPosition(final int index) {
        return orderedPositions.elementAt(index);
    }

    static boolean areIdentical(final MatrixPosition position1, final MatrixPosition position2) {
        return position1.equals(position2);
    }

    private static boolean areAdjacent(final MatrixPosition position1, final MatrixPosition position2) {
        return Math.abs(position1.getCol() - position2.getCol()) <= 1 && Math.abs(position1.getRow() - position2.getRow()) <= 1;
    }

    static boolean positionCrossesPath(final MatrixPosition position, final Path path) {
        final int pathSize = path.getSize();
        for(int i = 0; i < pathSize; i++) {
            if(areIdentical(position, path.getPosition(i))) {
                return true;
            }
        }
        return false;
    }

    static boolean positionCrossesAnyPath(final MatrixPosition position, final Vector<Path> allPaths) {
        for(final Path path : allPaths) {
            if(positionCrossesPath(position, path)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkPathLeft(final MatrixPosition position, final Vector<Path> paths) {
        if (position.getCol() == 0) return false;
        final MatrixPosition leftPosition = new MatrixPosition(position.getRow(), position.getCol() - 1);
        return checkPath(position, leftPosition, paths);
    }

    static boolean checkPathRight(final MatrixPosition position, final Vector<Path> paths, final int gridSize) {
        if (position.getCol() == gridSize-1) return false;
        final MatrixPosition rightPosition = new MatrixPosition(position.getRow(), position.getCol() + 1);
        return checkPath(position, rightPosition, paths);
    }

    static boolean checkPathUp(final MatrixPosition position, final Vector<Path> paths) {
        if (position.getRow() == 0) return false;
        final MatrixPosition upPosition = new MatrixPosition(position.getRow() - 1, position.getCol());
        return checkPath(position, upPosition, paths);
    }

    static boolean checkPathDown(final MatrixPosition position, final Vector<Path> paths, final int gridSize) {
        if (position.getRow() == gridSize-1) return false;
        final MatrixPosition downPosition = new MatrixPosition(position.getRow() + 1, position.getCol());
        return checkPath(position, downPosition, paths);
    }

    private static boolean checkPath(final MatrixPosition position1, final MatrixPosition position2, final Vector<Path> paths) {
        for(final Path path : paths) {
            MatrixPosition p1 = path.getSourcePosition();
            for(int i = 1; i < path.getSize(); i++) {
                final MatrixPosition p2 = path.getPosition(i);
                if(p1.equals(position1) && p2.equals(position2)) return true;
                if(p1.equals(position2) && p2.equals(position1)) return true;
                p1 = p2;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = 0; i < getSize(); i++) {
            final MatrixPosition position = orderedPositions.elementAt(i);
            stringBuilder.append(position.toString());
            if(i < getSize()-1) stringBuilder.append("-");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}