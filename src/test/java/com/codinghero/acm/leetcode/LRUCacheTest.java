package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    /**
     * Set will rearrange the order
     */
    @Test
    public void testSet() {
        LRUCache2 cache = new LRUCache2(2);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(1, 1);
        cache.set(3, 3);
        Assert.assertEquals(-1, cache.get(2));
    }

    /**
     * Get will rearrange the order
     */
    @Test
    public void testGet() {
        LRUCache2 cache = new LRUCache2(2);
        cache.set(1, 1);
        cache.set(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.set(3, 3);
        Assert.assertEquals(-1, cache.get(2));
    }
    
    /**
     * Both of get and set will rearrange the order
     */
    @Test
    public void testGetAndSet() {
        LRUCache2 cache = new LRUCache2(2);
        cache.set(1, 1);
        cache.set(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.set(2, 2);
        cache.set(3, 3);
        Assert.assertEquals(-1, cache.get(1));
    }
}
