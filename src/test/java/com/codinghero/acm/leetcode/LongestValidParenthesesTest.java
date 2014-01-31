package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class LongestValidParenthesesTest {
	
	@Test
	public void test1() {
		LongestValidParentheses instance = new LongestValidParentheses();
		Assert.assertEquals(8, instance.longestValidParentheses("((())())"));
	}
	
	@Test
	public void test2() {
		LongestValidParentheses instance = new LongestValidParentheses();
		Assert.assertEquals(6, instance.longestValidParentheses("((())))())"));
	}
	
	@Test
	public void test3() {
		LongestValidParentheses instance = new LongestValidParentheses();
		Assert.assertEquals(0, instance.longestValidParentheses("("));
	}
	
	@Test
	public void test4() {
		LongestValidParentheses instance = new LongestValidParentheses();
		Assert.assertEquals(2, instance.longestValidParentheses("()(()"));
	}
	
	@Test
	public void test5() {
		LongestValidParentheses instance = new LongestValidParentheses();
		Assert.assertEquals(2, instance.longestValidParentheses("(()"));
	}
}
