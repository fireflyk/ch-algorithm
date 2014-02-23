package com.codinghero.acm.leetcode;

import java.util.ArrayList;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.length == 0)
			return result;
		
		permute(nums, 0, result);
		return result;
	}
	
	private void permute(int[] nums, int start, ArrayList<ArrayList<Integer>> result) {
		if (start == nums.length) {
			ArrayList<Integer> curResult = new ArrayList<Integer>();
			for (int num : nums) {
				curResult.add(num);
			}
			result.add(curResult);
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			if (!isDuplicated(nums, start, i)) {
				swap(nums, start, i);
				permute(nums, start + 1, result);
				swap(nums, start, i);
			}
		}
	}
	
	private boolean isDuplicated(int[] nums, int start, int cur) {
		for (int i = start; i < cur; i++) {
			if (nums[i] == nums[cur])
				return true;
		}
		return false;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
