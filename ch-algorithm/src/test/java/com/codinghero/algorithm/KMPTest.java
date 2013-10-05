package com.codinghero.algorithm;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.algorithm.KMP;

public class KMPTest {
	
	@Test
	public void testGetImprovedKmpNext() {
		// simple match
		Assert.assertEquals((new KMP().contains("abcdefg", "bcd")), 1);
		// not match
		Assert.assertEquals((new KMP().contains("ababcabcacbab", "abaabcac")), -1);
		// match from first letter
		Assert.assertEquals((new KMP().contains("abaabcacab", "abaabcac")), 0);
		// match
		Assert.assertEquals((new KMP().contains("ababaabcacab", "abaabcac")), 2);
	}
}
