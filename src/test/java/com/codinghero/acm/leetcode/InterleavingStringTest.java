package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class InterleavingStringTest {
	
	@Test
	public void test1() {
		InterleavingString instance = new InterleavingString();
		Assert.assertEquals(true, instance.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

	@Test
	public void test2() {
		InterleavingString instance = new InterleavingString();
		Assert.assertEquals(false, instance.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

	@Test
	public void test3() {
		InterleavingString instance = new InterleavingString();
		Assert.assertEquals(true, instance.isInterleave("dbbea", "aabbc", "aadbbebbca"));
	}

	@Test
	public void test4() {
		InterleavingString instance = new InterleavingString();
		Assert.assertEquals(true, instance.isInterleave("", "", ""));
	}

	@Test
	public void test5() {
		InterleavingString instance = new InterleavingString();
		Assert.assertEquals(true, instance.isInterleave("aabcc", "dbbca", "aadbcbbcac"));
	}
}
