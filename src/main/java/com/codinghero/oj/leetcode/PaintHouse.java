package com.codinghero.oj.leetcode;

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] costsSum = new int[costs.length][3];
        costsSum[0][0] = costs[0][0];
        costsSum[0][1] = costs[0][1];
        costsSum[0][2] = costs[0][2];
        int min = Math.min(costsSum[0][0], Math.min(costsSum[0][1], costsSum[0][2]));
        for (int i = 1; i < costs.length; i++) {
            costsSum[i][0] = Math.min(costsSum[i - 1][1], costsSum[i - 1][2]) + costs[i][0];
            costsSum[i][1] = Math.min(costsSum[i - 1][0], costsSum[i - 1][2]) + costs[i][1];
            costsSum[i][2] = Math.min(costsSum[i - 1][0], costsSum[i - 1][1]) + costs[i][2];
            min = Math.min(costsSum[i][0], Math.min(costsSum[i][1], costsSum[i][2]));
        }
        return min;
    }
}
