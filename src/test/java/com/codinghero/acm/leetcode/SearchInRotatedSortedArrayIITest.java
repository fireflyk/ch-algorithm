package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class SearchInRotatedSortedArrayIITest {
	
	private SearchInRotatedSortedArrayII instance = new SearchInRotatedSortedArrayII();
	
	@Test
	public void test3() {
		Assert.assertEquals(true, instance.search(new int[] { 3, 1 }, 1));
	}

	@Test
	public void test2() {
		Assert.assertEquals(true,
				instance.search(new int[] { 6, 2, 2, 6, 6, 6, 6, 6 }, 2));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, instance.search(new int[] { 2, 2, 2 }, 2));
	}
}
