package com.codinghero.oj.leetcode;

public class MaxiumGap2 {
	public int maximumGap(int[] num) {
		if (num.length < 2) {
			return 0;
		}

		int min = findMin(num);
		int max = findMax(num);
		final int BUCKET_RANGE = (int) Math.ceil((double) (max - min)
				/ (double) (num.length - 1));
		final int BUCKET_NUM = (max - min) / BUCKET_RANGE + 1;
		int[][] buckets = new int[BUCKET_NUM][num.length - 1];
		int[] indexInBuckets = new int[BUCKET_NUM];

		for (int i = 0; i < num.length; i++) {
			int index = (num[i] - min) / BUCKET_RANGE;
			buckets[index][indexInBuckets[index]++] = num[i];
		}

		int lastNonEmptyIndex = 0, maxNonEmptyIndex = 0, maxWidth = 0;
		for (int i = 1; i < BUCKET_NUM; i++) {
			if (indexInBuckets[i] > 0) {
				if (i - lastNonEmptyIndex > maxWidth) {
					maxNonEmptyIndex = lastNonEmptyIndex;
					maxWidth = i - lastNonEmptyIndex;
				}
				lastNonEmptyIndex = i;
			}
		}

		int left = findMax(buckets[maxNonEmptyIndex]);
		int right = findMin(buckets[maxNonEmptyIndex + maxWidth]);
		return right - left;
	}

	private int findMin(int[] num) {
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] < min) {
				min = num[i];
			}
		}
		return min;
	}

	private int findMax(int[] num) {
		int max = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		return max;
	}
}
