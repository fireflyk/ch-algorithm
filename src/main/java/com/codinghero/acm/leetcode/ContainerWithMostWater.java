package com.codinghero.acm.leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null)
			return 0;
		int max = 0;
		for (int i = 0, j = height.length - 1; i < j;) {
			int cur = Math.min(height[i], height[j]) * (j - i);
			if (cur > max)
				max = cur;
			if (height[i] <= height[j])
				i++;
			else
				j--;
		}
		return max;
	}
}
