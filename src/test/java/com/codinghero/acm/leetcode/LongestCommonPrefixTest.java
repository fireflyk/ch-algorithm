package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class LongestCommonPrefixTest {
	
	private LongestCommonPrefix instance = new LongestCommonPrefix();
	
	@Test
	public void test1() {
		Assert.assertEquals("", instance.longestCommonPrefix(new String[] {}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("a",
				instance.longestCommonPrefix(new String[] { "a", "ab" }));
	}

	@Test
	public void test3() {
		Assert.assertEquals(
				"abc",
				instance.longestCommonPrefix(new String[] { "abcd", "abcde",
						"abc" }));
	}
}
