package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class DivideTest {

	@Test
	public void testDivide() {
		Assert.assertEquals(1, new Divide().divide(1, 1));
		Assert.assertEquals(2, new Divide().divide(2, 1));
		Assert.assertEquals(2, new Divide().divide(7, 3));
		Assert.assertEquals(3, new Divide().divide(9, 3));
		Assert.assertEquals(-2147483648, new Divide().divide(-2147483648, 1));
		Assert.assertEquals(-2147483647, new Divide().divide(2147483647, -1));
		
		Assert.assertEquals(1, new Divide().divide(-1, -1));
		Assert.assertEquals(-1, new Divide().divide(-1, 1));
		Assert.assertEquals(-2, new Divide().divide(7, -3));
	}
}
