package com.codinghero.interview.facebook;

import junit.framework.Assert;

import org.junit.Test;

public class MinimumWindowSubstringTest {

    private MinimumWindowSubstring3 instance = new MinimumWindowSubstring3();

    @Test
    public void testFindShortestSubstring() {
        Assert.assertEquals("a", instance.minWindow("a", "a"));
        Assert.assertEquals("abc", instance.minWindow("abc", "abc"));
        Assert.assertEquals("", instance.minWindow("a", "aa"));
        Assert.assertEquals("", instance.minWindow("a", "b"));
        Assert.assertEquals("abc", instance.minWindow("aaabc", "abc"));
        Assert.assertEquals("bcda", instance.minWindow("ecdaebbcdaf", "abc"));
        Assert.assertEquals("eca", instance.minWindow("cabeca", "cae"));
    }
}
