package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class PlusOneTest {
	
	@Test
	public void test1() {
		PlusOne plusOne = new PlusOne();
		Assert.assertArrayEquals(new int[] { 1, 0 },
				plusOne.plusOne(new int[] { 9 }));
	}
	
	@Test
	public void test2() {
		PlusOne plusOne = new PlusOne();
		Assert.assertArrayEquals(new int[] { 1, 0, 2 },
				plusOne.plusOne(new int[] { 1, 0, 1 }));
	}
}
