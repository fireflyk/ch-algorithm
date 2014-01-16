package com.codinghero.acm.etc;

public class SubArrayMaxSumAns2 implements SubArrayMaxSum {

	public int calMaxSum(int[] arr) {
		int sumIminus1 = arr[0], maxSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			// sum(i-1) is the max one
			int aIplusSumIminus1 = arr[i] + sumIminus1;
			if (sumIminus1 > aIplusSumIminus1 && sumIminus1 > arr[i]) {
				if (sumIminus1 > maxSum)
					maxSum = sumIminus1;
				// the sumIminus1 value is depend on the 2 below
			}
			
			// a[i]+sum(i-1) is the max one
			if (aIplusSumIminus1 > arr[i]) {
				sumIminus1 = aIplusSumIminus1;
			}
			
			// a[i] is the max one
			else {
				sumIminus1 = arr[i];
			}
		}
		if (sumIminus1 > maxSum)
			maxSum = sumIminus1;
		return maxSum;
	}

}
