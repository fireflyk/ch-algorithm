package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class DecodeWaysTest {
	@Test
	public void test1() {
		DecodeWays instance = new DecodeWays();
		Assert.assertEquals(2, instance.numDecodings("12"));
	}
}
