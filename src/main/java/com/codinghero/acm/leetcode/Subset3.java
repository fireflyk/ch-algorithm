package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset3 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return subsets(nums, nums.length - 1);
    }

    private List<List<Integer>> subsets(int[] nums, int end) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (end == -1) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<List<Integer>> prevResult = subsets(nums, end - 1);

        for (List<Integer> prevSubset : prevResult) {
            List<Integer> newSubset = new ArrayList<Integer>(prevSubset);
            newSubset.add(nums[end]);
            result.add(newSubset);
        }

        result.addAll(prevResult);
        return result;
    }
}
