package com.codinghero.acm.leetcode;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author Tong Liu
 *
 */
public class MajorityElement {

	public int majorityElement(int[] num) {
		return split(num, 0, num.length - 1);
	}

	private int split(int[] num, final int start, final int end) {
		int leftMove = 0, pivot = start;
		for (int left = start, right = end; left < right;) {
			if (num[left] == num[right]) {
				leftMove++;
				pivot = right;
				left++;
			} else if (num[left] < num[right]) {
				if (pivot == left) {
					--right;
				} else {
					++left;
				}
			} else {
				swap(num, left, right);
				if (pivot == left) {
					pivot = right;
					++left;
				} else {
					pivot = left;
					--right;
				}
			}
		}
		if (leftMove + 1 > (end - start + 1) / 2) {
			return num[pivot];
		} else if (pivot - start > end - pivot) {
			return split(num, start, pivot - 1);
		} else {
			return split(num, pivot + 1, end);
		}
	}

	private void swap(int[] num, int i1, int i2) {
		int temp = num[i1];
		num[i1] = num[i2];
		num[i2] = temp;
	}
}
