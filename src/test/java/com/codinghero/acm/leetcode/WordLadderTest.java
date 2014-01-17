package com.codinghero.acm.leetcode;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

public class WordLadderTest {

	@Test
	public void test1() {
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		Assert.assertEquals(5, new WordLadder().ladderLength("hit", "cog", set));
	}

	@Test
	public void test2() {
		HashSet<String> set = new HashSet<String>();
		Assert.assertEquals(2, new WordLadder().ladderLength("hit", "hot", set));
	}

	@Test
	public void test3() {
		HashSet<String> set = new HashSet<String>();
		Assert.assertEquals(1, new WordLadder().ladderLength("hit", "hit", set));
	}
}
