package com.codinghero.acm.etc;

public class SubArrayMaxSumAns3 implements SubArrayMaxSum {
	public int calMaxSum(int[] arr) {
		int tempSum = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 && arr[i] < tempSum) {
				if (tempSum > maxSum)
					maxSum = tempSum;
				if (tempSum + arr[i] > 0)
					tempSum += arr[i];
				else
					tempSum = arr[i];
			} else if (arr[i] > 0 && tempSum > 0) {
				tempSum += arr[i];
			} else { // tempSum<0&&tempSum<arr[i]
				tempSum = arr[i];
			}
		}
		if (tempSum > maxSum)
			maxSum = tempSum;
		return maxSum;
	}
}
