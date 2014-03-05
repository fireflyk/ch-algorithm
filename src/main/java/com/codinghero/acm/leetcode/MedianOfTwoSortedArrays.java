package com.codinghero.acm.leetcode;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] a, int[] b) {
		int totalLength = a.length + b.length;
		// odd
		if ((totalLength & 0x1) == 0x1) {
			return findMedianSortedArrays(a, b, 0, a.length - 1, 0,
					b.length - 1, (totalLength + 1) / 2);
		}
		// even
		else {
			return ((double) findMedianSortedArrays(a, b, 0, a.length - 1, 0,
					b.length - 1, totalLength / 2) + (double) findMedianSortedArrays(
					a, b, 0, a.length - 1, 0, b.length - 1, totalLength / 2 + 1)) / 2;
		}
	}
	
	private int findMedianSortedArrays(int[] a, int[] b, int startA, int endA,
			int startB, int endB, int k) {
		if (endA - startA > endB - startB) {
			return findMedianSortedArrays(b, a, startB, endB, startA, endA, k);
		} else if (startA > endA) {
			return b[startB + k - 1];
		} else if (k == 1) {
			return Math.min(a[startA], b[startB]);
		}
		
		final int lengthA = endA - startA + 1;
		// final int lengthB = endB - startB + 1;
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
			return a[indexA];
		}
	}
}
