package com.codinghero.oj.leetcode;

public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		int[] nums = new int[ratings.length];
		nums[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (ratings[i] > ratings[i - 1])
				nums[i] = nums[i - 1] + 1;
			else
				nums[i] = 1;
		}
		
		int sum = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && nums[i] <= nums[i + 1])
				nums[i] = nums[i + 1] + 1;
			sum += nums[i];
		}

		return sum;
	}
}
