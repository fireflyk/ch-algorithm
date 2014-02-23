package com.codinghero.acm.leetcode;

public class JumpGameII {
	public int jump(int[] arr) {
		if (arr == null || arr.length <= 1)
			return 0;
		int curMax = 0, max = 0, jump = 0;
		for (int i = 0; i < arr.length - 1 && curMax < arr.length - 1; i++) {
			if (max < arr[i] + i) {
				max = arr[i] + i;
			}
			if (i >= curMax) {
				curMax = max;
				jump++;
			}
		}
		
		return jump;
	}
}
