package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset4 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return null;

        // sort
        Arrays.sort(nums);

        // init
        // ArrayList is better than LinkedList in performance, in this case
        List<List<Integer>> prev = new ArrayList<List<Integer>>();
        prev.add(new ArrayList<Integer>());

        // append in loop
        for (int i = 0; i < nums.length; i++) {
            int size = prev.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<Integer>(prev.get(j));
                temp.add(nums[i]);
                prev.add(temp);
            }
        }
        return prev;
    }
}
