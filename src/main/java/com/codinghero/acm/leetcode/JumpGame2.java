package com.codinghero.acm.leetcode;

public class JumpGame2 {
	public boolean canJump(int[] arr) {
		if (arr == null || arr.length <= 1)
			return true;
		int max = 0;
		for (int i = 0; i < arr.length - 1 && i <= max; i++) {
			max = Math.max(max, arr[i] + i);
		}
		if (max >= arr.length - 1)
			return true;
		else
			return false;
	}
}
