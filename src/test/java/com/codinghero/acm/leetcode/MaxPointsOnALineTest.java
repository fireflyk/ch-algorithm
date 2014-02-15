package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class MaxPointsOnALineTest {
	
	private MaxPointsOnALine instance = new MaxPointsOnALine();
	
	@Test
	public void test3() {
		Point[] points = new Point[] { new Point(0, 0), new Point(0, 0) };
		Assert.assertEquals(2, instance.maxPoints(points));
	}
	
	@Test
	public void test4() {
		Point[] points = new Point[] { new Point(0, 0), new Point(0, 0),
				new Point(1, 1), new Point(1, 1) };
		Assert.assertEquals(4, instance.maxPoints(points));
	}
	
	@Test
	public void test1() {
		Point[] points = new Point[] { new Point(0, 0), new Point(2, 0),
				new Point(0, 1), new Point(1, 1), new Point(2, 2),
				new Point(1, 1) };
		Assert.assertEquals(4, instance.maxPoints(points));
	}
	
	@Test
	public void test2() {
		Point[] points = new Point[] { new Point(0, 0) };
		Assert.assertEquals(1, instance.maxPoints(points));
	}
}
