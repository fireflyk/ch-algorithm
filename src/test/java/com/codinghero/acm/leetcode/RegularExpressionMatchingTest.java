package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class RegularExpressionMatchingTest {
	
	@Test
	public void test1() {
		RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
		Assert.assertEquals(false, regularExpressionMatching.isMatch("aa", "a"));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aa", "aa"));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aa", "a*"));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aa", ".*"));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("ab", ".*"));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aab", "c*a*b"));
		
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aaa", "a*a"));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("bbbba", ".*a*a"));
		Assert.assertEquals(false, regularExpressionMatching.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
		Assert.assertEquals(false, regularExpressionMatching.isMatch("b", "bb.."));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("", ""));
		Assert.assertEquals(true, regularExpressionMatching.isMatch("", ".*"));
	}
}
