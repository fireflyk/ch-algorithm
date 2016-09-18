package com.codinghero.acm.leetcode;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[] min = min(costs, 0);
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                if (costs[i - 1][j] != min[0]) {
                    costs[i][j] += min[0];
                } else {
                    costs[i][j] += min[1];
                }
            }
            min = min(costs, i);
        }
        return min[0];
    }

    private int[] min(int[][] costs, int index) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < costs[index].length; i++) {
            if (costs[index][i] < min) {
                secondMin = min;
                min = costs[index][i];
            } else if (costs[index][i] < secondMin) {
                secondMin = costs[index][i];
            }
        }
        return new int[] { min, secondMin };
    }

    public static void main(String[] args) {
        new PaintHouseII().minCostII(new int[][] { { 1, 5, 3 }, { 2, 9, 4 } });
    }
}
