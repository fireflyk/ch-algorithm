package com.codinghero.acm.leetcode;

public class NumberOfIslands2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islandNum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (findNewIsland(grid, i, j)) {
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    private boolean findNewIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return false;
        } else {
            grid[i][j] = '0';
        }
        findNewIsland(grid, i - 1, j);
        findNewIsland(grid, i + 1, j);
        findNewIsland(grid, i, j - 1);
        findNewIsland(grid, i, j + 1);
        return true;
    }
}
