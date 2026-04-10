package com.codinghero.oj.leetcode;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        int leftIndex = start, rightIndex = end;
        int pivotIndex = start;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] < nums[rightIndex]) {
                swap(nums, leftIndex, rightIndex);
                pivotIndex = (pivotIndex == leftIndex ? rightIndex : leftIndex);
            }
            if (pivotIndex == leftIndex) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        final int leftCount = pivotIndex - start;
        if (leftCount == k - 1) {
            return nums[pivotIndex];
        } else if (leftCount < k - 1) {
            return findKthLargest(nums, pivotIndex + 1, end, k - leftCount - 1);
        } else {
            return findKthLargest(nums, start, pivotIndex - 1, k);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        final int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
