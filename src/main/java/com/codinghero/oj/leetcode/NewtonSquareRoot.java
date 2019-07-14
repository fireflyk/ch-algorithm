package com.codinghero.oj.leetcode;

public class NewtonSquareRoot {
	public int sqrt(int num) {
		if (num == 0)
			return 0;
		long numLong = num;
		long sqrt = 1;
		while (!isSqrt(numLong, sqrt)) {
			sqrt = (sqrt + numLong / sqrt) / 2;
		}
		return (int) sqrt;
	}

	private boolean isSqrt(long num, long sqrt) {
		long sqr = sqrt * sqrt;
		if (sqr == num)
			return true;
		else if (sqr < num) {
			if ((sqrt + 1) * (sqrt + 1) > num) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
