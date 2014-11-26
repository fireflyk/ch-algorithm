package com.codinghero.acm.leetcode;

/**
 * DFS, O(n)
 * 
 * @author Tong Liu
 *
 */
public class JumpGame {
	public boolean canJump(int[] arr) {
		if (arr == null || arr.length <= 1)
			return true;
		Boolean[] result = new Boolean[arr.length];
		canJump(arr, result, 0);
		return result[0];
	}
	
	private void canJump(int[] arr, Boolean[] result, int start) {
		if (result[start] != null)
			return;
		else if (start == arr.length - 1) {
			result[start] = true;
			return;
		}
		
		int distance = arr[start];
		for (int i = Math.min(arr.length - 1, start + distance); i > start; i--) {
			canJump(arr, result, i);
			if (result[i]) {
				result[start] = true;
				return;
			}
		}
		result[start] = false;
	}
}
