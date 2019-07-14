package com.codinghero.oj.leetcode;

import java.util.Arrays;

/**
 * 755. Pour Water
 * https://leetcode.com/problems/pour-water/
 */
public class PourWater {
    public int[] pourWater(int[] heights, int volume, int pourIndex) {
        int[] result = Arrays.copyOf(heights, heights.length);
        for (int i = 0; i < volume; i++) {
            int leftIndex = findLeft(result, pourIndex, pourIndex);
            if (leftIndex < pourIndex) {
                result[leftIndex] = result[leftIndex] + 1;
            } else {
                int rightIndex = findRight(result, pourIndex, pourIndex);
                if (rightIndex > pourIndex) {
                    result[rightIndex] = result[rightIndex] + 1;
                } else {
                    result[pourIndex] = result[pourIndex] + 1;
                }
            }
        }
        return result;
    }

    private int findLeft(int[] heights, int curIndex, int targetIndex) {
        if (curIndex == 0) {
            return targetIndex;
        } else if (heights[curIndex - 1] > heights[curIndex]) {
            return targetIndex;
        } else if (heights[curIndex - 1] == heights[curIndex]) {
            return findLeft(heights, curIndex - 1, targetIndex);
        } else {
            return findLeft(heights, curIndex - 1, curIndex - 1);
        }
    }

    private int findRight(int[] heights, int curIndex, int targetIndex) {
        if (curIndex == heights.length - 1) {
            return targetIndex;
        } else if (heights[curIndex + 1] > heights[curIndex]) {
            return targetIndex;
        } else if (heights[curIndex + 1] == heights[curIndex]) {
            return findRight(heights, curIndex + 1, targetIndex);
        } else {
            return findRight(heights, curIndex + 1, curIndex + 1);
        }
    }

    private int getIndex(int[] heights, int curIndex, int edgeIndex) {
        if (heights[curIndex] == heights[edgeIndex]) {
            return edgeIndex;
        } else {
            return curIndex;
        }
    }
}
