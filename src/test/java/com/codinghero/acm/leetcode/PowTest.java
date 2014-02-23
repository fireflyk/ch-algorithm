package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class PowTest {

	private Pow2 instance = new Pow2();
	
	@Test
	public void test1() {
		Assert.assertTrue(Math.abs(Math.pow(0.1d, 0) - instance.pow(0.1d, 0)) < 0.00001);
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(Math.abs(Math.pow(0.1d, 1) - instance.pow(0.1d, 1)) < 0.00001);
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(Math.abs(Math.pow(0.1d, 2) - instance.pow(0.1d, 2)) < 0.00001);
	}
	
	@Test
	public void test4() {
		Assert.assertTrue(Math.abs(Math.pow(0.1d, 3) - instance.pow(0.1d, 3)) < 0.00001);
	}
	
	@Test
	public void test5() {
		Assert.assertTrue(Math.abs(Math.pow(0.1d, 4) - instance.pow(0.1d, 4)) < 0.00001);
	}
	
	@Test
	public void test6() {
		Assert.assertTrue(Math.abs(Math.pow(0.1d, -3) - instance.pow(0.1d, -3)) < 0.00001);
	}
}
