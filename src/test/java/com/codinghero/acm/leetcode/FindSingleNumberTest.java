package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class FindSingleNumberTest {
	
	@Test
	public void testSingleNumber() {
		Assert.assertEquals(1, new FindSingleNumber().singleNumber(new int[] { 3,
				6, 3, 1, 6 }));
	}
}
