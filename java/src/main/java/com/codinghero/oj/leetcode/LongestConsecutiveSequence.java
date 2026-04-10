package com.codinghero.oj.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                Integer left = map.get(nums[i] - 1);
                if (left == null) {
                    left = 0;
                }
                Integer right = map.get(nums[i] + 1);
                if (right == null) {
                    right = 0;
                }
                int curLength = left + right + 1;
                map.put(nums[i], curLength);

                // update
                if (left > 0)
                    map.put(nums[i] - left, curLength);
                if (right > 0)
                    map.put(nums[i] + right, curLength);

                if (curLength > max) {
                    max = curLength;
                }
            }
        }
        return max;
    }
}
