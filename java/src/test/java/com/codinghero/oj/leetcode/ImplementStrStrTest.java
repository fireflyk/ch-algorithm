package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ImplementStrStrTest {
	
	private ImplementStrStr instance = new ImplementStrStr();
	
	@Test
	public void test1() {
		Assert.assertEquals("", instance.strStr("", ""));
		Assert.assertEquals("a", instance.strStr("a", ""));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("a", instance.strStr("a", "a"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("abcabcd", instance.strStr("aababcabcd", "abc"));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(null, instance.strStr("aaabb", "baba"));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(null, instance.strStr("mississippi", "a"));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals("bbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba", instance.strStr("bbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba", "bbbbbbaa"));
	}
}
