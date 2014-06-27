package com.codinghero.interview.tango;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class Q2Test {
	
	@Test
	public void testFindTopK() {
		Integer[] arr = new Integer[] { 30, 50, 20, 40, 70, 10, 60 };
		List<Integer> result = new Q2().findTopK(Arrays.asList(arr), 3);
		Assert.assertEquals(3, result.size());
		Assert.assertTrue(result.contains(70));
		Assert.assertTrue(result.contains(60));
		Assert.assertTrue(result.contains(50));
	}
}
