package com.codinghero.acm.leetcode;

public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] num) {
		return findInRotate(num, 0, num.length - 1);
	}

	private int findInRotate(int[] num, int start, int end) {
		if (start == end)
			return num[start];
		int mid = (start + end) / 2;
		int min = min(num[start], num[mid], num[end]);
		if (num[start] == min) {
			return min;
		} else if (num[mid] == min) {
			return findInRotate(num, start + 1, mid);
		} else {
			return findInRotate(num, mid + 1, end);
		}
	}

	private int min(int... nums) {
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		return min;
	}
}
