package com.codinghero.algorithm;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.oj.leetcode.KSmallInTwoSortedArray;

public class KSmallInTwoSortedArrayTest {

	private static int[] arr1 = new int[] { 1, 3, 5 };
	private static int[] arr2 = new int[] { 2, 4, 6 };
	
	@Test
	public void testFind1() {
		int result = new KSmallInTwoSortedArray().find(arr1, arr2, 1);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testFind2() {
		int result = new KSmallInTwoSortedArray().find(arr1, arr2, 2);
		Assert.assertEquals(2, result);
	}

	@Test
	public void testFind3() {
		int result = new KSmallInTwoSortedArray().find(arr1, arr2, 6);
		Assert.assertEquals(6, result);
	}
}
