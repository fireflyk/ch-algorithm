package com.codinghero.algorithm;

import junit.framework.Assert;

import org.junit.Test;

public class PalindromePartition2Test {
	
	@Test
	public void minCut() {
		Assert.assertEquals(1, new PalindromePartition2().minCut("aab"));
		Assert.assertEquals(0, new PalindromePartition2().minCut(""));
	}
}
