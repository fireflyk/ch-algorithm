package com.codinghero.acm.leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class SubsetTest {

	@Test
	public void testSubsets1() {
		int[] arr = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> result = new Subset().subsets(arr);
		Assert.assertEquals(8, result.size());
	}

	@Test
	public void testSubsets2() {
		int[] arr = { 1, 2, 2, 3 };
		ArrayList<ArrayList<Integer>> result = new Subset().subsets(arr);
		Assert.assertEquals(12, result.size());
	}
}
