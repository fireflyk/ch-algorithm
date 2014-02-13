package com.codinghero.acm.leetcode;

public class MedianOfTwoSortedArrays2 {
	public double findMedianSortedArrays(int[] a, int[] b) {
		int totalLength = a.length + b.length;
		if ((totalLength & 0x1) == 0x1) {
			Result result = findMedianSortedArrays(a, b, 0, a.length - 1, 0,
					b.length - 1, (totalLength + 1) / 2);
			return result.value;
		} else {
			Result result1 = findMedianSortedArrays(a, b, 0, a.length - 1, 0,
					b.length - 1, totalLength / 2);
			Integer value2;
			if (result1.nextIndexA == a.length)
				value2 = b[result1.nextIndexB];
			else if (result1.nextIndexB == b.length)
				value2 = a[result1.nextIndexA];
			else
				value2 = Math.min(a[result1.nextIndexA], b[result1.nextIndexB]);
			return ((double) result1.value + (double) value2) / 2;
		}
	}
	
	private Result findMedianSortedArrays(int[] a, int[] b, int startA, int endA,
			int startB, int endB, int k) {
		if (endA - startA > endB - startB) {
			Result result = findMedianSortedArrays(b, a, startB, endB, startA, endA, k);
			return new Result(result.value, result.nextIndexB, result.nextIndexA);
		} else if (startA > endA) {
			return new Result(b[startB + k - 1], startA, startB + k);
		} else if (k == 1) {
			if (a[startA] <= b[startB]) {
				return new Result(a[startA], startA + 1, startB);
			} else {
				return new Result(b[startB], startA, startB + 1);
			}
			
		}
		
		final int lengthA = endA - startA + 1;
		final int amountA = Math.min(k / 2, lengthA);
		final int amountB = k - amountA;
		final int indexA = startA + amountA - 1;
		final int indexB = startB + amountB - 1;
		if (a[indexA] < b[indexB]) {
			return findMedianSortedArrays(a, b, indexA + 1, endA, startB,
					indexB, k - amountA);
		} else if (a[indexA] > b[indexB]) {
			return findMedianSortedArrays(a, b, startA, indexA, indexB + 1,
					endB, k - amountB);
		} else {
			return new Result(a[indexA], indexA + 1, indexB + 1);
		}
	}
	
	private class Result {
		private int nextIndexA;
		private int nextIndexB;
		private int value;

		public Result(int value, int nextIndexA, int nextIndexB) {
			this.value = value;
			this.nextIndexA = nextIndexA;
			this.nextIndexB = nextIndexB;
		}
	}
}
