package com.codinghero.oj.leetcode;

public class SquareRoot {
	public int sqrt(int num) {
		return (int) sqrt(0, num, num);
	}

	private long sqrt(long low, long high, long num) {
		if (low == high)
			return low;

		long mid = (low + high) / 2;
		long result = isSqrt(num, mid);
		if (result == 0) {
			return mid;
		} else if (result == 1) {
			return sqrt(low, mid, num);
		} else {
			return sqrt(mid + (low + high) % 2, high, num);
		}

	}

	private long isSqrt(long num, long sqrt) {
		long sqr = sqrt * sqrt;
		if (sqr == num)
			return 0;
		else if (sqr < num) {
			if ((sqrt + 1) * (sqrt + 1) > num) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return 1;
		}
	}
}
