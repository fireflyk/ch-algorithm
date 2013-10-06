package com.codinghero.acm.leetcode;

public class KSmallInTwoSortedArray {
	public int find(int[] arr1, int[] arr2, int k) {
		if (arr1 == null || arr2 == null)
			throw new IllegalArgumentException();
		if (k > arr1.length + arr2.length)
			throw new IllegalArgumentException();
		
		if (k <= 0)
			throw new IllegalArgumentException();
		else if (k == 1)
			return Math.min(arr1[0], arr2[0]);
		else {
			k -= 2;
			return find(arr1, arr2, k / 2, k - k / 2, k / 4);
		}
	}
	
	private int find(int[] arr1, int[] arr2, int i, int j, int step) {
		if(arr1[i]>=arr2[j]) {
			if (j + 1 > arr2.length - 1 || arr1[i] <= arr2[j + 1]) {
				return arr1[i];
			} else {
				return find(arr1, arr2, i - step, j + step, Math.max(step / 2, 1));
			}
		} else {
			if (i + 1 > arr1.length - 1 || arr2[j] <= arr1[i + 1]) {
				return arr2[j];
			} else {
				return find(arr1, arr2, i + step, j - step, Math.max(step / 2, 1));
			}
		}
	}
}
