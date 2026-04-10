package com.codinghero.interview.facebook;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class StringPermutationTest {
	
	private StringPermutation instance = new StringPermutation();
	
	@Test
	public void test1() {
		Set<String> results = instance.getAll("aabc");
		Assert.assertTrue(results.contains("aabc"));
		Assert.assertTrue(results.contains("aacb"));
		Assert.assertTrue(results.contains("abac"));
		Assert.assertTrue(results.contains("abca"));
		Assert.assertTrue(results.contains("acab"));
		Assert.assertTrue(results.contains("acba"));
		
		Assert.assertTrue(results.contains("baac"));
		Assert.assertTrue(results.contains("baca"));
		Assert.assertTrue(results.contains("bcaa"));
		
		Assert.assertTrue(results.contains("caab"));
		Assert.assertTrue(results.contains("caba"));
		Assert.assertTrue(results.contains("cbaa"));
		
		Assert.assertEquals(12, results.size());
	}
}
