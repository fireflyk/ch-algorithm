package com.codinghero.oj.leetcode;

public class TrappingRainWater {
	public int trap(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		
		int[] water = new int[arr.length];
		water[0] = 0;
		water[arr.length - 1] = 0;
		
		this.calculateStep1(arr, water);
		this.calculateStep2(arr, water);
		
		int sum = 0;
		for (int i = 1; i < water.length - 1; i++)
			sum += water[i];
		return sum;
	}
	
	private void calculateStep1(int[] arr, int[] water) {
		boolean desc = false;
		int prevPeak = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			// judge the current state, desc/asc
			if (desc) {
				if (arr[i] > arr[i - 1]) {
					desc = false;
				}
			}
			else {
				if (arr[i] < arr[i - 1]) {
					desc = true;
					if (arr[i - 1] > prevPeak)
						prevPeak = arr[i - 1];
				}
			}
			// calculate
			if (desc) {
				water[i] = prevPeak - arr[i];
			}
			else {
				if (arr[i] < prevPeak)
					water[i] = prevPeak - arr[i];
			}
		}
	}

	private void calculateStep2(int[] arr, int[] water) {
		boolean desc = false;
		int prevPeak = 0;
		for (int i = arr.length - 2; i >= 1; i--) {
			// judge the current state, desc/asc
			if (desc) {
				if (arr[i] > arr[i + 1]) {
					desc = false;
				}
			}
			else {
				if (arr[i] < arr[i + 1]) {
					desc = true;
					if (arr[i + 1] > prevPeak)
						prevPeak = arr[i + 1];
				}
			}
			// calculate
			if (desc) {
				int amountByRightTraverse = prevPeak - arr[i];
				if (water[i] > amountByRightTraverse)
					water[i] = amountByRightTraverse;
			}
			else {
				if (arr[i] < prevPeak) {
					int amountByRightTraverse = prevPeak - arr[i];
					if (water[i] > amountByRightTraverse)
						water[i] = amountByRightTraverse;
				} else {
					water[i] = 0;
				}
			}
		}
	}
}
