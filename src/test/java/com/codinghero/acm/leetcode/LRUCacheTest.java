package com.codinghero.acm.leetcode;

import org.junit.*;

public class LRUCacheTest {
	
	@Test
	public void test() {
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		Assert.assertEquals(1, cache.get(2));
		
		cache.set(4, 2);
		Assert.assertEquals(2, cache.get(4));
		Assert.assertEquals(-1, cache.get(2));
		
		cache.set(4, 1);
		Assert.assertEquals(1, cache.get(4));
	}
}
