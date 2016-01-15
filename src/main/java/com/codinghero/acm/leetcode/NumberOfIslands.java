package com.codinghero.acm.leetcode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandNum = 0;

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visitIsland(grid, visited, i, j) > 0) {
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    private int visitIsland(char[][] grid, boolean[][] visited, int i, int j) {
        int nodeNum = 0;
        if (isVisited(visited, i, j)) {
            return nodeNum;
        } else {
            visited[i][j] = true;
            if (grid[i][j] == '0') {
                return nodeNum;
            } else {
                nodeNum = 1;
            }
        }
        nodeNum += visitIsland(grid, visited, i - 1, j);
        nodeNum += visitIsland(grid, visited, i + 1, j);
        nodeNum += visitIsland(grid, visited, i, j - 1);
        nodeNum += visitIsland(grid, visited, i, j + 1);
        return nodeNum;
    }

    private boolean isVisited(boolean[][] visited, int i, int j) {
        return (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j]);
    }
}
