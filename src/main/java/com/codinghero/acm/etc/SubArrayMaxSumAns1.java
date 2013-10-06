package com.codinghero.acm.etc;

/**
 * Find the max sum of a sub array in an array
 * 
 * @author liutong01
 * 
 */
public class SubArrayMaxSumAns1 implements SubArrayMaxSum {
	public int calMaxSum(int[] arr) {
		int tempSum = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
		for (int i : arr) {
			if (tempSum < 0 && i > tempSum)
				tempSum = i;
			else
				tempSum += i;
			if (tempSum > maxSum)
				maxSum = tempSum;
		}
		return maxSum;
	}
}
