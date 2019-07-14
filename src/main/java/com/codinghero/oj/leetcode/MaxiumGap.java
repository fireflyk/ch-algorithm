package com.codinghero.oj.leetcode;

import java.util.Arrays;

public class MaxiumGap {
	public int maximumGap(int[] num) {
		if (num.length < 2) {
			return 0;
		}
		Arrays.sort(num);

		int diff = num[1] - num[0];
		for (int i = 1; i < num.length; i++) {
			int newDiff = num[i] - num[i - 1];
			if (newDiff > diff) {
				diff = newDiff;
			}
		}
		return diff;
	}
}
