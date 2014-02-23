package com.codinghero.acm.leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class PermutationsTest {
	
	private Permutations instance = new Permutations();
	
	@Test
	public void test1() {
		ArrayList<ArrayList<Integer>> result = instance.permute(new int[] { 1, 2, 3 });
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(1);
		result1.add(3);
		result1.add(2);
		
		Assert.assertEquals(6, result.size());
		Assert.assertTrue(result.contains(result1));
	}
}
