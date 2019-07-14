package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class LargestRectangleInHistogramTest {
	@Test
	public void test1() {
		LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
		Assert.assertEquals(10, instance.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	@Test
	public void test2() {
		LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
		Assert.assertEquals(12, instance.largestRectangleArea(new int[] { 3, 2, 5, 6, 2, 3 }));
	}

	@Test
	public void test3() {
		LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
		Assert.assertEquals(1, instance.largestRectangleArea(new int[] { 1 }));
	}

	@Test
	public void test4() {
		LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
		Assert.assertEquals(0, instance.largestRectangleArea(new int[] {}));
	}
}
