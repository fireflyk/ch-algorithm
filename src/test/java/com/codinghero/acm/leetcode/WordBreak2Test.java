package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class WordBreak2Test {

	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("le");
		dict.add("leet");
		dict.add("leets");
		dict.add("cod");
		dict.add("code");
		dict.add("codec");
		dict.add("e");
		Assert.assertEquals(Arrays.asList(new String[]{"leet cod e", "leet code"}), new WordBreak2().wordBreak("leetcode", dict));
	}

	@Test
	public void test2() {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaaa");
		ArrayList<String> list = new WordBreak2().wordBreak("aaaaaaa", dict);
		Assert.assertEquals(31, list.size());
	}

	@Test
	public void test3() {
		Set<String> dict = new HashSet<String>();
		Assert.assertEquals(new ArrayList<String>(), new WordBreak2().wordBreak("", dict) );
	}

	@Test
	public void test4() {
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
		dict.add("aaaaaaaaaaa");
		dict.add("aaaaaaaaaaaa");
		dict.add("aaaaaaaaaaaaa");
		
		Assert.assertEquals(new ArrayList<String>(), new WordBreak2().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict) );
	}
}
