package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class DecodeWaysTest {
	@Test
	public void test1() {
		DecodeWays instance = new DecodeWays();
		Assert.assertEquals(2, instance.numDecodings("12"));
	}

	@Test
	public void test2() {
		DecodeWays instance = new DecodeWays();
		Assert.assertEquals(3, instance.numDecodings("123"));
	}

	@Test
	public void test3() {
		DecodeWays instance = new DecodeWays();
		Assert.assertEquals(8, instance.numDecodings("12123"));
	}

	@Test
	public void test4() {
		DecodeWays instance = new DecodeWays();
		Assert.assertEquals(0, instance.numDecodings("0"));
	}

	@Test
	public void test5() {
		DecodeWays instance = new DecodeWays();
		Assert.assertEquals(0, instance.numDecodings("01"));
	}
}
