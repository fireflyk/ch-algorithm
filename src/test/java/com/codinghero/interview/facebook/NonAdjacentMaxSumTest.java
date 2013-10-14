package com.codinghero.interview.facebook;

import junit.framework.Assert;

import org.junit.Test;

public class NonAdjacentMaxSumTest {
	
	@Test
	public void testCalculate() {
		Assert.assertEquals(12, new NonAdjacentMaxSum().calculate(new int[] {
				1, 2, 3, 4, 5, 6 }));
		Assert.assertEquals(14, new NonAdjacentMaxSum().calculate(new int[] {
				3, 1, 6, 4, 5, 2 }));
		Assert.assertEquals(8, new NonAdjacentMaxSum().calculate(new int[] {
				2, 1, 4, 3, -5, 2 }));
		Assert.assertEquals(5, new NonAdjacentMaxSum().calculate(new int[] {
				-2, -4, -1, 3, -5, 2 }));
	}
}
