package com.codinghero.oj.leetcode;

public class Pow2 {
	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return x;
		else if (n < 0)
			return 1 / pow(x, (-1) * n);
		else if (n == Integer.MAX_VALUE)
			return x * pow(x, n - 1);

		int totalExp = 0, curExp = 2;
		Double[] results = new Double[n + 1];
		double result = 1;
		results[1] = 0.1d;

		// find big exp
		while (true) {
			// *2 again
			if (curExp < n) {
				results[curExp] = results[curExp / 2] * results[curExp / 2];
				curExp *= 2;
			}
			// find
			else if (curExp == n) {
				results[curExp] = results[curExp / 2] * results[curExp / 2];
				break;
			}
			// find the previous one, /2
			else {
				curExp /= 2;
				//result = results[curExp];
				break;
			}
		}

		// calculate x^i (i mod 2 = 0)
		while (true) {
			if (totalExp + curExp < n) {
				totalExp += curExp;
				result *= results[curExp];
				curExp /= 2;
			} else if (totalExp + curExp == n) {
				// totalExp += curExp;
				result *= results[curExp];
				// curExp /= 2;
				break;
			} else {
				curExp /= 2;
			}
		}
		
		return result;
	}
}
