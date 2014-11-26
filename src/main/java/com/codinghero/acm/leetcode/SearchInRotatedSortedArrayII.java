package com.codinghero.acm.leetcode;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] arr, int target) {
		if (arr == null)
			return false;
		return search(arr, target, 0, arr.length - 1);
	}

	private boolean search(int[] arr, int target, int start, int end) {
		if (start == end) {
			if (arr[start] == target)
				return true;
			else
				return false;
		} else if (start > end) {
			return false;
		}
		
		int mid = (start + end) / 2;
		if (arr[mid] == target)
			return true;
		if (arr[start] < arr[mid]) {
			if (arr[start] <= target && target < arr[mid])
				return search(arr, target, start, mid - 1);
			else
				return search(arr, target, mid + 1, end);
		} else if (arr[mid] < arr[end]) {
			if (arr[mid] < target && target <= arr[end])
				return search(arr, target, mid + 1, end);
			else
				return search(arr, target, start, mid - 1);
		} else {
			return search(arr, target, start, mid - 1)
					|| search(arr, target, mid + 1, end);
		}
	}
}
