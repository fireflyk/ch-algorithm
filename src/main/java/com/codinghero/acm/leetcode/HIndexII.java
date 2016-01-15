package com.codinghero.acm.leetcode;

public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null)
            return 0;
        int start = 0, end = citations.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            int hIndex = citations.length - mid;
            if (citations[mid] < hIndex) {
                start = mid + 1;
            } else {
                if (mid == 0 || citations[mid - 1] < (hIndex + 1)) {
                    break;
                } else {
                    end = mid - 1;
                }
            }
            mid = start + (end - start) / 2;
        }
        return citations.length - mid;
    }

    public static void main(String[] args) {
        System.out.println(new HIndexII().hIndex(new int[] { 0, 0, 0 }));
    }
}
