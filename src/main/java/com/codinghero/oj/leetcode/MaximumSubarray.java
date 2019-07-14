package com.codinghero.oj.leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tempSum >= 0) {
                tempSum += nums[i];
            } else {
                tempSum = nums[i];
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { -2, 1 }));
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { 0 }));
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { -2, -1, -3 }));
        System.out.println(new MaximumSubarray().maxSubArray(new int[] { 1, 3, -2, 1, -5 }));
    }
}
