package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

	private LongestPalindromicSubstring2 instance = new LongestPalindromicSubstring2();

//	@Test
//	public void test1() {
//		Assert.assertEquals("aabaa", instance.longestPalindrome("xyaabaax"));
//	}
//
//	@Test
//	public void test2() {
//		Assert.assertEquals("aa", instance.longestPalindrome("aa"));
//	}

	@Test
	public void test3() {
		Assert.assertEquals("aa", instance.longestPalindrome("aab"));
	}
}
