package com.codinghero.algorithm;

public class Knapsack01 {

	public int cal(int n, int wSum, int[] w, int[] v) {
		int[] result = new int[wSum + 1];
		for (int i = 0; i < n; i++) {
			for (int j = wSum; j >= w[i]; j--) {
				result[j] = Math.max(result[j - w[i]] + v[i], result[j]);
			}
		}
		return result[wSum];
	}
}
