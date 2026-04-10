package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class MaxiumGapTest {
	
	private MaxiumGap instance = new MaxiumGap();
	
	@Test
	public void test() {
		Assert.assertEquals(99, instance.maximumGap(new int[]{1, 100}));
	}
}
