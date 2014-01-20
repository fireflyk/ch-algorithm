package com.codinghero.acm.leetcode;

public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		int[] nums = new int[ratings.length];
		nums[0] = 1;
		int min = 1;
		for (int i = 1; i < nums.length; i++) {
			if (ratings[i] > ratings[i - 1])
				nums[i] = nums[i - 1] + 1;
			else if (ratings[i] == ratings[i - 1])
				nums[i] = 1;
			else {
				nums[i] = nums[i - 1] - 1;
				if (nums[i] < min)
					min = nums[i];
			}
		}

		int addNum = 1 - min;
		nums[nums.length - 1] += addNum;
		int sum = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if(ratings[i]==ratings[i+1])
				
			nums[i] += addNum;
			sum += nums[i];
		}

		return sum;
	}
}
