package com.codinghero.acm.leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class PermutationsIITest {
	
	private PermutationsII instance = new PermutationsII();
	
	@Test
	public void test1() {
		ArrayList<ArrayList<Integer>> result = instance
				.permuteUnique(new int[] { 2, 2, 1, 1 });
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(1);
		result1.add(2);
		result1.add(1);
		result1.add(2);
		
		Assert.assertEquals(6, result.size());
		Assert.assertTrue(result.contains(result1));
	}
}
