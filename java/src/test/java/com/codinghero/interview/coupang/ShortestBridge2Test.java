package com.codinghero.interview.coupang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShortestBridge2Test {

    private final ShortestBridge3 solver = new ShortestBridge3();

    @Test
    public void findsShortestBridgeFromAllFirstIslandCells() {
        assertEquals(1, solver.shortestBridge(new int[][]{
            {0, 1},
            {1, 0}
        }));
        assertEquals(2, solver.shortestBridge(new int[][]{
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        }));
        assertEquals(1, solver.shortestBridge(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        }));
    }

    @Test
    public void handlesLargeIslandWithoutRecursion() {
        int[][] grid = new int[100][100];
        for (int row = 0; row < 98; row++) {
            for (int col = 0; col < 100; col++) {
                grid[row][col] = 1;
            }
        }
        for (int col = 0; col < 100; col++) {
            grid[99][col] = 1;
        }
        assertEquals(1, solver.shortestBridge(grid));
    }
}
