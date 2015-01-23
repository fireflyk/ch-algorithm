package com.codinghero.acm.leetcode;

public class FindMinimumInRotatedSortedArrayII {

	public int findMin(int[] num) {
		return findInRotate(num, 0, num.length - 1);
	}

	private int findInRotate(int[] num, int start, int end) {
		if (start == end)
			return num[start];
		int mid = (start + end) / 2;
		if (num[start] == num[mid] && num[mid] == num[end]) {
			if (end - start > 1)
				return findInRotate(num, start + 1, end - 1);
			else
				return num[start];
		} else if (num[start] <= num[mid] && num[mid] <= num[end]) {
			return num[start];
		} else if (num[start] >= num[mid] && num[mid] <= num[end]) {
			return findInRotate(num, start + 1, mid);
		} else if (num[start] <= num[mid] && num[mid] >= num[end]) {
			return findInRotate(num, mid + 1, end);
		} else {
			throw new RuntimeException();
		}
	}
}
