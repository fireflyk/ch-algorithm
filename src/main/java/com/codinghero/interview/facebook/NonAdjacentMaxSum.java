package com.codinghero.interview.facebook;

public class NonAdjacentMaxSum {
	public int calculate(int[] arr) {
		if(arr.length==1)
			return arr[0];
		else if(arr.length==2)
			return Math.max(arr[0], arr[1]);
		else if(arr.length==3)
			return Math.max(
				Math.max(arr[0], arr[1]), 
				Math.max(arr[2], arr[0] + arr[2])
			);
		else {
			int[] sum = new int[arr.length];
			sum[0] = arr[0];
			sum[1] = Math.max(arr[0], arr[1]);
			sum[2] = Math.max(
						Math.max(arr[0], arr[1]), 
						Math.max(arr[2], arr[0] + arr[2])
					);
			calculate(arr, sum);
			return sum[sum.length - 1];
		}
	}
	
	private void calculate(int[] arr, int[] sum) {
		for (int i = 3; i < arr.length; i++) {
			int tempMax1 = Math.max(sum[i - 2] + arr[i], sum[i - 3] + arr[i - 1]);
			int tempMax2 = Math.max(Math.max(arr[i], arr[i - 1]), sum[i - 2]);
			sum[i] = Math.max(tempMax1, tempMax2);
		}
	}
}
