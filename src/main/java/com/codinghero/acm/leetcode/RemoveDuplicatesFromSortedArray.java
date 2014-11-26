package com.codinghero.acm.leetcode;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] arr) {
		if (arr == null)
			return 0;
		int[] leftMoveStep = new int[arr.length];
		int duplicateNum = 0;
		// calculate left move step
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i]) {
				duplicateNum++;
			}
			leftMoveStep[i] = duplicateNum;
		}
		
		// left move, O(n)
		for (int i = 1; i < arr.length; i++) {
			leftMove(arr, i, leftMoveStep[i]);
		}
		
		return arr.length - duplicateNum;
	}
	
	private void leftMove(int[] arr, int index, int step) {
		if (step > 0) {
			arr[index - step] = arr[index];
			arr[index] = 0;
		}
	}
}
