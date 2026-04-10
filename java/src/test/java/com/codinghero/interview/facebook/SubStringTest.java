package com.codinghero.interview.facebook;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class SubStringTest {

	private SubString3 instance = new SubString3();
	
	@Test
	public void test1() {
		Set<String> results = instance.getAll("ababc");
		
		Assert.assertTrue(results.contains(""));
		Assert.assertTrue(results.contains("a"));
		
		Assert.assertTrue(results.contains("b"));
		Assert.assertTrue(results.contains("ab"));
		
		Assert.assertTrue(results.contains("ba"));
		Assert.assertTrue(results.contains("aba"));

		Assert.assertTrue(results.contains("bab"));
		Assert.assertTrue(results.contains("abab"));

		Assert.assertTrue(results.contains("c"));
		Assert.assertTrue(results.contains("bc"));
		Assert.assertTrue(results.contains("abc"));
		Assert.assertTrue(results.contains("babc"));
		Assert.assertTrue(results.contains("ababc"));
		
		Assert.assertEquals(13, results.size());
	}
}
