package com.codinghero.oj.leetcode;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null)
            return 0;
        Arrays.sort(citations);
        int hIndex = citations.length;
        for (int i = 0; i < citations.length; i++, hIndex--) {
            if (citations[i] >= hIndex) {
                break;
            }
        }
        return hIndex;
    }
}
