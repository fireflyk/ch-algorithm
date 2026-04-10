package com.codinghero.oj.leetcode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[] { 0, 1, 3 }));
    }
}
