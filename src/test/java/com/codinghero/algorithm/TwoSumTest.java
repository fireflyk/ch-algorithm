package com.codinghero.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

	@Test
	public void testTwoSum() {
		Assert.assertArrayEquals(new int[] { 1, 2 },
				new TwoSum().twoSum(new int[] { 2, 1 }, 3));
		Assert.assertArrayEquals(new int[] { 1, 3 },
				new TwoSum().twoSum(new int[] { 2, 3, 1 }, 3));
		Assert.assertArrayEquals(new int[] { 2, 3 },
				new TwoSum().twoSum(new int[] { 5, 75, 25 }, 100));
		Assert.assertArrayEquals(new int[] { 4, 5 },
				new TwoSum().twoSum(new int[] { 2, 1, 9, 4, 4, 56, 90, 3 }, 8));

	}
}
