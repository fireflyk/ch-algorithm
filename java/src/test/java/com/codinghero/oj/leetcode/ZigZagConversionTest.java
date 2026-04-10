package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ZigZagConversionTest {
	@Test
	public void test() {
		ZigZagConversion instance = new ZigZagConversion();
		Assert.assertEquals("AB", instance.convert("AB", 2));
		Assert.assertEquals("PAHNAPLSIIGYIR", instance.convert("PAYPALISHIRING", 3));
	}
}
