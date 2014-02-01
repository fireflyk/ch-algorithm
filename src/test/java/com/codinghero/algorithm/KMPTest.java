package com.codinghero.algorithm;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.algorithm.KMP;

public class KMPTest {
	
	@Test
	public void testGetImprovedKmpNext() {
		Assert.assertEquals((new KMP().contains("", "abc")), -1);
		// simple match
		Assert.assertEquals((new ImprovedKMP().contains("abcdefg", "bcd")), 1);
		// not match
		Assert.assertEquals((new ImprovedKMP().contains("ababcabcacbab", "abaabcac")), -1);
		// match from first letter
		Assert.assertEquals((new ImprovedKMP().contains("abaabcacab", "abaabcac")), 0);
		// match
		Assert.assertEquals((new ImprovedKMP().contains("ababaabcacab", "abaabcac")), 2);
	}
}
