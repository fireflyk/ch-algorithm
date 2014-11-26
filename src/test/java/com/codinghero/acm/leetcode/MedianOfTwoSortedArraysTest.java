package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

	private MedianOfTwoSortedArrays2 instance = new MedianOfTwoSortedArrays2();

	@Test
	public void test6() {
		Assert.assertEquals(
				1.5,
				instance.findMedianSortedArrays(new int[] { 1, 2 }, new int[] {
						1, 2 }));
	}

	@Test
	public void test5() {
		Assert.assertEquals(3.5, instance.findMedianSortedArrays(new int[] { 3,
				4 }, new int[] {}));
	}

	@Test
	public void test4() {
		Assert.assertEquals(2.5, instance.findMedianSortedArrays(new int[] {},
				new int[] { 2, 3 }));
	}

	@Test
	public void test1() {
		Assert.assertEquals(5.0, instance.findMedianSortedArrays(new int[] { 2,
				3, 4, 5, 6 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
	}

	@Test
	public void test2() {
		Assert.assertEquals(4.0, instance.findMedianSortedArrays(new int[] { 2,
				3, 4 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
	}

	@Test
	public void test3() {
		Assert.assertEquals(
				5.0,
				instance.findMedianSortedArrays(new int[] { 2 }, new int[] { 1,
						2, 3, 4, 5, 6, 7, 8, 9, 10 }));
	}
}
