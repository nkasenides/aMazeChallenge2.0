package org.inspirecenter.amazechallenge.generation.generator;

import org.inspirecenter.amazechallenge.model.MatrixPosition;
import org.inspirecenter.amazechallenge.proto.Algorithm;
import org.inspirecenter.amazechallenge.generation.AMCTerrainGenerator;

import java.util.Collections;
import java.util.Vector;

public class MazeGenerator {

    private static final int MIN_MAZE_SIZE = 5;
    private static final int MAX_MAZE_SIZE = 30;

    public static String generate(Algorithm algorithm, int gridSize, final MatrixPosition startingPosition, final MatrixPosition targetPosition) {

        if(gridSize < MIN_MAZE_SIZE) gridSize = MIN_MAZE_SIZE;
        if(gridSize > MAX_MAZE_SIZE) gridSize = MAX_MAZE_SIZE;

        switch (algorithm) {
            case SINGLE_SOLUTION_Algorithm:
                return generateSingleSolution(gridSize, startingPosition, targetPosition);
            case MANY_SOLUTIONS_Algorithm:
                return generateManySolutions(gridSize, startingPosition, targetPosition);
            case SPARSE_Algorithm:
                return generateSparse(gridSize, startingPosition, targetPosition);
            case EMPTY_Algorithm:
                return generateEmpty(gridSize);
            default:
                return generateSingleSolution(gridSize, startingPosition, targetPosition);
        }
    }

    private static String generateSingleSolution(int gridSize, final MatrixPosition startingPosition, final MatrixPosition targetPosition) {

        // generate
        Vector<Path> mazePaths = generateRandomMaze(1, startingPosition, targetPosition, gridSize);

        return getGrid(mazePaths, gridSize);
    }

    private static String generateManySolutions(int gridSize, final MatrixPosition startingPosition, final MatrixPosition targetPosition) {

        // generate
        final int numOfSolutions = gridSize / 2;
        Vector<Path> mazePaths = generateRandomMaze(numOfSolutions, startingPosition, targetPosition, gridSize);

        return getGrid(mazePaths, gridSize);
    }

    private static String generateSparse(int gridSize, final MatrixPosition startingPosition, final MatrixPosition targetPosition) {
        // generate
        Vector<Path> mazePaths = generateRandomMazeWithLoops(startingPosition, targetPosition, gridSize);

        return getGrid(mazePaths, gridSize);
    }

    private static String generateEmpty(int gridSize) {
        // calculate grid with only boundary walls
        final StringBuilder data = new StringBuilder();
        for(int row = 0; row < gridSize; row++) {
            for(int col = 0; col < gridSize; col++) {
                final MatrixPosition position = new MatrixPosition(row, col);

                final boolean hasWallToLeft = col == 0;
                final boolean hasWallToRight = col == gridSize - 1;
                final boolean hasWallToUp = row == 0;
                final boolean hasWallToDown= row == gridSize - 1;

                int shape = 0x0;

                if(hasWallToLeft)  shape |= AMCTerrainGenerator.SHAPE_ONLY_LEFT_SIDE;
                if(hasWallToRight) shape |= AMCTerrainGenerator.SHAPE_ONLY_RIGHT_SIDE;
                if(hasWallToUp)    shape |= AMCTerrainGenerator.SHAPE_ONLY_UPPER_SIDE;
                if(hasWallToDown)  shape |= AMCTerrainGenerator.SHAPE_ONLY_LOWER_SIDE;

                data.append(Integer.toHexString(shape));
            }
        }
        return data.toString();
    }

    private static String getGrid(Vector<Path> paths, final int gridSize) {
        // calculate grid based on paths
        final StringBuilder data = new StringBuilder();
        for(int row = 0; row < gridSize; row++) {
            for(int col = 0; col < gridSize; col++) {
                final MatrixPosition position = new MatrixPosition(row, col);

                final boolean existsPathToLeft = Path.checkPathLeft(position, paths);
                final boolean existsPathToRight = Path.checkPathRight(position, paths, gridSize);
                final boolean existsPathToUp = Path.checkPathUp(position, paths);
                final boolean existsPathToDown= Path.checkPathDown(position, paths, gridSize);

                int shape = 0xF;

                if(existsPathToLeft) shape &= ~AMCTerrainGenerator.SHAPE_ONLY_LEFT_SIDE;
                if(existsPathToRight) shape &= ~AMCTerrainGenerator.SHAPE_ONLY_RIGHT_SIDE;
                if(existsPathToUp) shape &= ~AMCTerrainGenerator.SHAPE_ONLY_UPPER_SIDE;
                if(existsPathToDown) shape &= ~AMCTerrainGenerator.SHAPE_ONLY_LOWER_SIDE;

                data.append(Integer.toHexString(shape));
            }
        }
        return data.toString();
    }

    private static Vector<Path> generateRandomMazeWithLoops(final MatrixPosition sourcePosition, final MatrixPosition targetPosition, final int gridSize) {

        final Vector<Path> allPaths = new Vector<>();

        final BooleanGrid grid = new BooleanGrid(gridSize);

        // first generate the exit path
        {
            final Path path = generateRandomPath(sourcePosition, targetPosition, gridSize);
            allPaths.add(path);
            grid.setGrid(path);
        }

        // then add more paths--possibly with loops--until all cells are 'busy'
        while(!grid.isFull()) {
            final MatrixPosition position = grid.randomSetPosition();
            final Path path = generateRandomPathWithLoops(position, allPaths, gridSize);
            allPaths.add(path);
            grid.setGrid(path);
        }

        return allPaths;
    }

    private static Vector<Path> generateRandomMaze(final int numOfSolutions, final MatrixPosition sourcePosition, final MatrixPosition targetPosition, final int gridSize) {

        final Vector<Path> allPaths = new Vector<>();

        final BooleanGrid grid = new BooleanGrid(gridSize);

        // first generate the exit paths
        for(int i = 0; i < numOfSolutions; i++) {
            final Path path = generateRandomPath(sourcePosition, targetPosition, gridSize);
            allPaths.add(path);
            grid.setGrid(path);
        }

        // then add more paths until all cells are 'busy'
        while(!grid.isFull()) {
            final MatrixPosition position = grid.randomUnsetPosition();
            final Path path = generateRandomPath(position, allPaths, gridSize);
            allPaths.add(path);
            grid.setGrid(path);
        }

        return allPaths;
    }

    private static Path generateRandomPath(final MatrixPosition startingPosition, final Vector<Path> allPaths, final int gridSize) {
        final Path path = new Path();
        while (path.isEmpty()) {
            path.addNextPoint(startingPosition);
            while(true) {
                final MatrixPosition currentPosition = path.getTargetPosition();
                final Vector<MatrixPosition> shuffledAdjacentPositions = getShuffledAdjacentPositions(currentPosition, gridSize);
                boolean added = false;
                for(final MatrixPosition position : shuffledAdjacentPositions) {
                    if(!Path.positionCrossesPath(position, path)) {
                        path.addNextPoint(position);
                        added = true;
                        break;
                    }
                }
                if(!added) { // no adjacent point - we need to restart
                    path.clear();
                    System.out.println("Failed! Trying again...");
                    break;
                }
                if(Path.positionCrossesAnyPath(path.getTargetPosition(), allPaths)) {
                    // we are done!
                    break;
                }
            }
        }
        return path;
    }

    private static Path generateRandomPathWithLoops(final MatrixPosition startingPosition, final Vector<Path> allPaths, final int gridSize) {
        final Path path = new Path();
        while (path.isEmpty()) {
            path.addNextPoint(startingPosition);
            while(true) {
                final MatrixPosition currentPosition = path.getTargetPosition();
                final Vector<MatrixPosition> shuffledAdjacentPositions = getShuffledAdjacentPositions(currentPosition, gridSize);
                boolean added = false;
                for(final MatrixPosition position : shuffledAdjacentPositions) {
                    if(Path.positionCrossesPath(position, path)) {

                    } else {
                        path.addNextPoint(position);
                        added = true;
                        break;
                    }
                }
                if(!added) { // no adjacent point - we need to restart
                    path.clear();
                    System.out.println("Failed! Trying again...");
                    break;
                }
                if(Path.positionCrossesAnyPath(path.getTargetPosition(), allPaths)) {
                    // we are done!
                    break;
                }
            }
        }
        return path;
    }

    private static Path generateRandomPath(final MatrixPosition fromPosition, final MatrixPosition toPosition, final int gridSize) {
        final Path path = new Path();
        while (path.isEmpty()) {
            path.addNextPoint(fromPosition);
            while(!Path.areIdentical(path.getTargetPosition(), toPosition)) { // repeat until the last added position matches the toPosition
                final MatrixPosition currentPosition = path.getTargetPosition();
                final Vector<MatrixPosition> shuffledAdjacentPositions = getShuffledAdjacentPositions(currentPosition, gridSize);
                boolean added = false;
                for(final MatrixPosition position : shuffledAdjacentPositions) {
                    if(!Path.positionCrossesPath(position, path)) {
                        path.addNextPoint(position);
                        added = true;
                        break;
                    }
                }
                if(!added) { // no adjacent point - we need to restart
                    path.clear();
//                    System.out.println("Failed! Trying again...");
                    break;
                }
            }
        }
        return path;
    }

    private static Vector<MatrixPosition> getShuffledAdjacentPositions(final MatrixPosition fromPosition, final int gridSize) {
        final Vector<MatrixPosition> randomAdjacentPositions = new Vector<>();
        final int col = fromPosition.getCol();
        final int row = fromPosition.getRow();
        if(col > 0) randomAdjacentPositions.add(new MatrixPosition(row, col - 1));
        if(row > 0) randomAdjacentPositions.add(new MatrixPosition(row  - 1, col));
        if(col < gridSize-1) randomAdjacentPositions.add(new MatrixPosition(row, col + 1));
        if(row < gridSize-1) randomAdjacentPositions.add(new MatrixPosition(row + 1, col));
        Collections.shuffle(randomAdjacentPositions); // shuffle

        return randomAdjacentPositions;
    }
}