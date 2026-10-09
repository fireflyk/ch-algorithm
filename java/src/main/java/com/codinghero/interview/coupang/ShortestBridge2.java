package com.codinghero.interview.coupang;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge2 {

    private static final int[] ROW_STEP = {-1, 1, 0, 0};
    private static final int[] COL_STEP = {0, 0, -1, 1};

    public int shortestBridge(int[][] grid) {
        int size = grid.length;
        boolean[][] visited = new boolean[size][size];
        Queue<Integer> frontier = new ArrayDeque<>();

        int first = -1;
        for (int row = 0; row < size && first < 0; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == 1) {
                    first = row * size + col;
                    break;
                }
            }
        }
        if (first < 0) {
            throw new IllegalArgumentException("No island found");
        }

        // Collect every cell of the first island as a multi-source BFS frontier.
        ArrayDeque<Integer> island = new ArrayDeque<>();
        island.push(first);
        visited[first / size][first % size] = true;
        while (!island.isEmpty()) {
            int cell = island.pop();
            int row = cell / size;
            int col = cell % size;
            frontier.offer(cell);
            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + ROW_STEP[direction];
                int nextCol = col + COL_STEP[direction];
                if (nextRow >= 0 && nextRow < size && nextCol >= 0 && nextCol < size
                    && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    island.push(nextRow * size + nextCol);
                }
            }
        }

        int flips = 0;
        while (!frontier.isEmpty()) {
            int cellsAtThisDistance = frontier.size();
            for (int i = 0; i < cellsAtThisDistance; i++) {
                int cell = frontier.remove();
                int row = cell / size;
                int col = cell % size;
                for (int direction = 0; direction < 4; direction++) {
                    int nextRow = row + ROW_STEP[direction];
                    int nextCol = col + COL_STEP[direction];
                    if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size
                        || visited[nextRow][nextCol]) {
                        continue;
                    }
                    if (grid[nextRow][nextCol] == 1) {
                        return flips;
                    }
                    visited[nextRow][nextCol] = true;
                    frontier.offer(nextRow * size + nextCol);
                }
            }
            flips++;
        }
        throw new IllegalArgumentException("Second island not found");
    }
}
