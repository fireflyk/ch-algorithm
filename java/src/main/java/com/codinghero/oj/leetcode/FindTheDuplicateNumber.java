package com.codinghero.oj.leetcode;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums.length, fast = nums.length;
        do {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        } while (slow != fast);
        fast = nums.length;
        do {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        } while (slow != fast);
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[] { 1, 2, 1 }));
    }
}
