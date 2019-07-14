package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset3 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return subsets(nums, nums.length - 1);
    }

    private List<List<Integer>> subsets(int[] nums, int end) {
        // add empty subset
        if (end == -1) {
            // ArrayList is better than LinkedList in performance, in this case
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }

        // previous result
        List<List<Integer>> prevResult = subsets(nums, end - 1);

        // append on previous result
        int size = prevResult.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newSubset = new ArrayList<Integer>(prevResult.get(i));
            newSubset.add(nums[end]);
            prevResult.add(newSubset);
        }
        return prevResult;
    }
}
