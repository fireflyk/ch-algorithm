package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
	@Test
	public void test1() {
		SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
		int[] arr = {4,5,6,7,0,1,2};
		Assert.assertEquals(0, searchInRotatedSortedArray.search(arr, 4));
		Assert.assertEquals(2, searchInRotatedSortedArray.search(arr, 6));
		Assert.assertEquals(5, searchInRotatedSortedArray.search(arr, 1));
		Assert.assertEquals(6, searchInRotatedSortedArray.search(arr, 2));
		Assert.assertEquals(-1, searchInRotatedSortedArray.search(arr, -10));
		Assert.assertEquals(-1, searchInRotatedSortedArray.search(arr, 3));
		Assert.assertEquals(-1, searchInRotatedSortedArray.search(arr, 8));
	}
}
