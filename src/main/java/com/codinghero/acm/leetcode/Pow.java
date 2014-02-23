package com.codinghero.acm.leetcode;

public class Pow {
	public double pow(double x, int n) {
		Double[] result = new Double[n + 1];
		pow(x, n, result);
		return result[n];
	}
	
	private void pow(double x, int n, Double[] result) {
		if (result[n] != null) {
			return;
		} else if (n == 1) {
			result[1] = x;
			return;
		} else if (n % 2 == 0) {
			pow(x, n / 2, result);
			result[n] = result[n / 2] * result[n / 2];
		} else {
			pow(x, (n - 1) / 2, result);
			result[n] = x * result[(n - 1) / 2] * result[(n - 1) / 2];
		}
	}
}
