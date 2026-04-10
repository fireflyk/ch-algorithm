package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            int dup = 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
                dup++;
            }
            int size = prev.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = prev.get(j);
                for (int k = 0; k < dup; k++) {
                    temp = new ArrayList<Integer>(temp);
                    temp.add(nums[i]);
                    prev.add(temp);
                }
            }
        }
        return prev;
    }
}
