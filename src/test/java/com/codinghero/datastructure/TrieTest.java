package com.codinghero.datastructure;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.datastructure.Trie.Node;

public class TrieTest {

	@Test
	public void test() {
		Trie t = new Trie();
		t.insert("le");
		t.insert("leet");
		Assert.assertTrue(t.exists("le"));
		Assert.assertFalse(t.exists("lee"));
		Assert.assertTrue(t.exists("leet"));
		
		
		Node le = t.get("le");
		Assert.assertTrue(t.exists(le, "et"));
		Assert.assertFalse(t.exists(le, "e"));
	}
}
