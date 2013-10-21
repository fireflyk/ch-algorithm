package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SquareRootTest {
	
	@Test
	public void testSqrt() {
		Assert.assertEquals(0, new SquareRoot().sqrt(0));
		Assert.assertEquals(1, new SquareRoot().sqrt(1));
		Assert.assertEquals(1, new SquareRoot().sqrt(2));
		Assert.assertEquals(1, new SquareRoot().sqrt(3));
		Assert.assertEquals(2, new SquareRoot().sqrt(4));
		Assert.assertEquals(2, new SquareRoot().sqrt(5));
		Assert.assertEquals(2, new SquareRoot().sqrt(6));
		Assert.assertEquals(2, new SquareRoot().sqrt(7));
		Assert.assertEquals(2, new SquareRoot().sqrt(8));
		Assert.assertEquals(3, new SquareRoot().sqrt(9));
		Assert.assertEquals(46339, new SquareRoot().sqrt(2147395599));
	}
}
