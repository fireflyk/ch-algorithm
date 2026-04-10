package com.codinghero.interview.openai;

public class InfectionSpeedSimulation {

    int timeToFullInfection(int[][] matrix) {
        int totalInfected = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell == 1) {
                    totalInfected++;
                }
            }
        }

        int time = 0;
        while (totalInfected < matrix.length * matrix[0].length) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0 && isInfected(matrix, i, j)) {
                        matrix[i][j] = 1;
                        totalInfected++;
                    }
                }
            }
            System.out.println(matrix);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            time++;
        }
        return time;
    }

    private boolean isInfected(int[][] matrix, int row, int col) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length) {
                if (matrix[newRow][newCol] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new InfectionSpeedSimulation().timeToFullInfection(new int[][]{
//            {0, 0, 0},
//            {0, 1, 0},
//            {0, 0, 0}
//        }));

        System.out.println(new InfectionSpeedSimulation().timeToFullInfection(new int[][]{
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        }));
    }
}
