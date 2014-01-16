package com.codinghero.acm.leetcode;

public class FindSingleNumber {
	public int singleNumber(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp ^= arr[i];
		}
		return temp;
	}
}
