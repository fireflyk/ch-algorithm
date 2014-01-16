package com.codinghero.acm.leetcode;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class WordBreakTest {

	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("le");
		dict.add("leet");
		dict.add("leets");
		dict.add("cod");
		dict.add("code");
		dict.add("codec");
		Assert.assertTrue(new WordBreak().wordBreak("leetcode", dict));
		Assert.assertFalse(new WordBreak().wordBreak("leecode", dict));
	}
	
	@Test
	public void test2() {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		Assert.assertFalse(new WordBreak().wordBreak(s, dict));
	}
}
