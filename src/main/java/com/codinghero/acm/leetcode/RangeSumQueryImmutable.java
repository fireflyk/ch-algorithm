package com.codinghero.acm.leetcode;

public class RangeSumQueryImmutable {

	public RangeSumQueryImmutable(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		sums = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return i == 0 ? sums[j] : sums[j] - sums[i - 1];
	}

	private int[] sums;
}
