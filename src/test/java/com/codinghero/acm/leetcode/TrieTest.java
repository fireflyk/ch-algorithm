package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class TrieTest {
    
    @Test
    public void test1() {
        Trie trie = new Trie();
        trie.insert("a");
        Assert.assertTrue(trie.search("a"));
        Assert.assertTrue(trie.startsWith("a"));
    }
    
    @Test
    public void test2() {
        Trie trie = new Trie();
        trie.insert("ab");
        Assert.assertFalse(trie.search("a"));
        Assert.assertTrue(trie.startsWith("a"));
    }
}
