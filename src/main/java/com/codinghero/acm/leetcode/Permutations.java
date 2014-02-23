package com.codinghero.acm.leetcode;

import java.util.ArrayList;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] nums) {
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
			swap(nums, start, i);
			permute(nums, start + 1, result);
			swap(nums, start, i);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
