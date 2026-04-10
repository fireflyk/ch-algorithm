package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        List<Integer> list0 = toList(nums1);
        List<Integer> list1 = toList(nums2);
        List<List<Integer>> lists = new ArrayList<List<Integer>>(2);
        lists.add(list0);
        lists.add(list1);
        return result;
    }

//    private int[] getMaxIndex(List<List<Integer>> lists) {
//        Integer maxIndex0 = getMaxIndex(lists.get(0));
//        Integer maxIndex1 = getMaxIndex(lists.get(1));
//        if (maxIndex0 == null) {
//            return new int[] { 1, maxIndex1 };
//        } else if (maxIndex1 == null) {
//            return new int[] { 0, maxIndex0 };
//        } else {
//            if (lists.get(0).get(maxIndex0) > lists.get(1).get(maxIndex1)) {
//
//            }
//            return new int[] {};
//        }
//    }

    private Integer getMaxIndex(List<Integer> list) {
        Integer maxIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(maxIndex)) {
                i = maxIndex;
            }
        }
        return maxIndex;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums != null) {
            for (int num : nums) {
                result.add(num);
            }
        }
        return result;
    }
}
