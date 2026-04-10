package com.codinghero.oj.leetcode;

import java.util.HashMap;

/**
 * Q560. Subarray Sum Equals K. https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] == k) {
                result++;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sums[j] - sums[i - 1] == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
