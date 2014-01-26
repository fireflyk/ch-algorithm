package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTest {
	@Test
	public void test() {
		NextPermutation nextPermutation = new NextPermutation();
		
		int[] num = new int[] { 1, 3, 6, 4, 2, 7, 5 };
		nextPermutation.nextPermutation(num);
		Assert.assertArrayEquals(new int[] { 1, 3, 6, 4, 5, 2, 7 }, num);

		num = new int[] { 1, 3, 6, 7, 7, 5, 2 };
		nextPermutation.nextPermutation(num);
		Assert.assertArrayEquals(new int[] { 1, 3, 7, 2, 5, 6, 7 }, num);
		
		num = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		nextPermutation.nextPermutation(num);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7 }, num);
		
		num = new int[] { 5, 1, 1 };
		nextPermutation.nextPermutation(num);
		Assert.assertArrayEquals(new int[] { 1, 1, 5 }, num);
		
		
		num = new int[] { 5, 4, 7, 5, 3, 2 };
		nextPermutation.nextPermutation(num);
		Assert.assertArrayEquals(new int[] { 5, 5, 2, 3, 4, 7 }, num);
		
		num = new int[] { 2, 2, 7, 5, 4, 3, 2, 2, 1 };
		nextPermutation.nextPermutation(num);
		Assert.assertArrayEquals(new int[] { 2, 3, 1, 2, 2, 2, 4, 5, 7 }, num);
	}
}
