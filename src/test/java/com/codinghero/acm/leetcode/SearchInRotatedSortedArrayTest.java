package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
	
	SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
	
	@Test
	public void test1() {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		Assert.assertEquals(0, instance.search(arr, 4));
		Assert.assertEquals(2, instance.search(arr, 6));
		Assert.assertEquals(5, instance.search(arr, 1));
		Assert.assertEquals(6, instance.search(arr, 2));
		Assert.assertEquals(-1, instance.search(arr, -10));
		Assert.assertEquals(-1, instance.search(arr, 3));
		Assert.assertEquals(-1, instance.search(arr, 8));
	}
	
	@Test
	public void test2() {
		int[] arr = { 4, 5, 6, 6, 7, 0, 1, 2 };
		Assert.assertEquals(0, instance.search(arr, 4));
		Assert.assertTrue(instance.search(arr, 6) == 2
				|| instance.search(arr, 6) == 3);
		Assert.assertEquals(6, instance.search(arr, 1));
		Assert.assertEquals(7, instance.search(arr, 2));
		Assert.assertEquals(-1, instance.search(arr, -10));
		Assert.assertEquals(-1, instance.search(arr, 3));
		Assert.assertEquals(-1, instance.search(arr, 8));
	}
}
