package com.codinghero.interview.coupang;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge3 {

    public int shortestBridge(int[][] grid) {
        int[][] travel = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                travel[i][j] = 0;
            }
        }
        final Position firstPiece = findFirstPiece(grid, travel);

        final Queue<Position> positions = new ArrayDeque<>();
        travelFirstIsland(grid, travel, firstPiece.row, firstPiece.col, positions);
        return findSecondIsland(grid, travel, positions);
    }

    private Position findFirstPiece(int[][] grid, int[][] travel) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    return new Position(i, j);
                } else {
                    travel[i][j] = -1;
                }
            }
        }
        throw new IllegalArgumentException("No island found");
    }

    private void travelFirstIsland(
        int[][] grid, int[][] travel, int row, int col, Queue<Position> positions) {
        // System.out.printf("Might visit (%d,%d)%n", row, col);
        if (row < 0 || row >= grid.length
            || col < 0 || col >= grid.length
            || travel[row][col] == -1) {
            // already visited
            // System.out.println("Ignore");
            return;
        } else {
            // System.out.printf("Visting (%d,%d)=%d%n", row, col, grid[row][col]);
            if (grid[row][col] == 1) {
                travel[row][col] = 1;
                positions.offer(new Position(row, col));
                // right
                travelFirstIsland(grid, travel, row, col + 1, positions);
                // down
                travelFirstIsland(grid, travel, row + 1, col, positions);
                // left
                travelFirstIsland(grid, travel, row, col - 1, positions);
                // up
                travelFirstIsland(grid, travel, row - 1, col, positions);
            } else {
                travel[row][col] = -1;
            }
        }
    }

    // 1,1  1,2  1,3  2,1  2,3  3,1  3,2  3,3
    private int findSecondIsland(int[][] grid, int[][] travel, Queue<Position> positions) {
        // System.out.println("-----");
        while (!positions.isEmpty()) {
            Queue<Position> nextSteps = new ArrayDeque<>();
            for (Position position : positions) {
                // System.out.printf("Position (%d,%d)=%d%n", position.row, position.col,travel[position.row][position.col]);
                for (Position next : new Position[]{
                    new Position(position.row - 1, position.col),
                    new Position(position.row + 1, position.col),
                    new Position(position.row, position.col - 1),
                    new Position(position.row, position.col + 1),
                }) {
                    // System.out.printf("Next (%d,%d)%n", next.row, next.col);
                    if (next.row < 0 || next.row >= grid.length
                        || next.col < 0 || next.col >= grid.length) {
                        continue;
                    } else if (grid[next.row][next.col] == 1) {
                        if (travel[next.row][next.col] != 1) {
                            // find the second island
                            return travel[position.row][position.col] - 1;
                        }
                    } else {
                        if (travel[next.row][next.col] <= 0) {
                            travel[next.row][next.col] = travel[position.row][position.col] + 1;
                            nextSteps.offer(next);
                        }
                    }
                }
            }
            positions = nextSteps;
        }
        throw new IllegalArgumentException("No island found");
    }

    private record Position(int row, int col) {

    }
}
