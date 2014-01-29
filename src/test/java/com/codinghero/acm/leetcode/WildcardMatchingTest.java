package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class WildcardMatchingTest {
	@Test
	public void test() {
		WildcardMatching instance = new WildcardMatching();
		Assert.assertEquals(false, instance.isMatch("aa", "a"));
		Assert.assertEquals(true, instance.isMatch("aa", "aa"));
		Assert.assertEquals(false, instance.isMatch("aaa", "aa"));
		Assert.assertEquals(true, instance.isMatch("aa", "*"));
		Assert.assertEquals(true, instance.isMatch("aa", "a*"));
		Assert.assertEquals(true, instance.isMatch("ab", "?*"));
		Assert.assertEquals(false, instance.isMatch("aab", "c*a*b"));
		
		Assert.assertEquals(true, instance.isMatch("aaa", "a*a"));
		Assert.assertEquals(true, instance.isMatch("a.b", "a.*b"));
		Assert.assertEquals(false, instance.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
		Assert.assertEquals(true, instance.isMatch("", ""));
		Assert.assertEquals(true, instance.isMatch("", "*"));
	}
}
