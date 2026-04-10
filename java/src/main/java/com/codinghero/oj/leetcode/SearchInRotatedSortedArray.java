package com.codinghero.oj.leetcode;

/**
 * There is at least one part of left and right part, which is ascending
 * 
 * @author liutong01
 * 
 */
public class SearchInRotatedSortedArray {
	public int search(int[] arr, int target) {
		if (arr == null || arr.length == 0)
			return -1;
		else
			return search(arr, 0, arr.length - 1, target);
	}
	
	private int search(int[] arr, final int start, final int end, final int target) {
		if (start == end) {
			if (arr[start] == target)
				return start;
			else
				return -1;
		}
		int mid = (start + end) / 2;
		if (arr[start] < arr[mid]) {
			if (arr[start] <= target && target <= arr[mid]) {
				return search(arr, start, mid, target);
			} else {
				return search(arr, mid + 1, end, target);
			}
		} else {
			if (arr[mid + 1] <= target && target <= arr[end]) {
				return search(arr, mid + 1, end, target);
			} else {
				return search(arr, start, mid, target);
			}
		}
	}
}
