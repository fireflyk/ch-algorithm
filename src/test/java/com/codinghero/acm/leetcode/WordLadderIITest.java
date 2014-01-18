package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

public class WordLadderIITest {

	@Test
	public void test1() {
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		
		ArrayList<ArrayList<String>> result = new WordLadderII().findLadders("hit", "cog", set);
		ArrayList<String> result0 = new ArrayList<String>();
		result0.add("hit");
		result0.add("hot");
		result0.add("dot");
		result0.add("dog");
		result0.add("cog");
		ArrayList<String> result1 = new ArrayList<String>();
		result1.add("hit");
		result1.add("hot");
		result1.add("lot");
		result1.add("log");
		result1.add("cog");
		Assert.assertEquals(result0, result.get(1));
		Assert.assertEquals(result1, result.get(0));
	}
	
	@Test
	public void test4() {
		HashSet<String> set = new HashSet<String>();
		set.add("ted");
		set.add("tex");
		set.add("red");
		set.add("tax");
		set.add("tad");
		set.add("den");
		set.add("rex");
		set.add("pee");
		
		ArrayList<ArrayList<String>> result = new WordLadderII().findLadders("red", "tax", set);
		ArrayList<String> result0 = new ArrayList<String>();
		result0.add("red");
		result0.add("ted");
		result0.add("tex");
		result0.add("tax");
		ArrayList<String> result1 = new ArrayList<String>();
		result1.add("red");
		result1.add("ted");
		result1.add("tad");
		result1.add("tax");
		ArrayList<String> result2 = new ArrayList<String>();
		result2.add("red");
		result2.add("rex");
		result2.add("tex");
		result2.add("tax");
		Assert.assertEquals(result0, result.get(1));
		Assert.assertEquals(result1, result.get(2));
		Assert.assertEquals(result2, result.get(0));
	}

	@Test
	public void test2() {
		HashSet<String> set = new HashSet<String>();
		ArrayList<ArrayList<String>> result = new WordLadderII().findLadders("hit", "hot", set);
		ArrayList<String> result0 = new ArrayList<String>();
		result0.add("hit");
		result0.add("hot");
		Assert.assertEquals(result0, result.get(0));
	}

	@Test
	public void test3() {
		HashSet<String> set = new HashSet<String>();
		ArrayList<ArrayList<String>> result = new WordLadderII().findLadders("hit", "hit", set);
		ArrayList<String> result0 = new ArrayList<String>();
		result0.add("hit");
		Assert.assertEquals(result0, result.get(0));
	}
	
	@Test
	public void test5() {
		HashSet<String> set = new HashSet<String>();
		ArrayList<ArrayList<String>> result = new WordLadderII().findLadders("abc", "def", set);
		Assert.assertNotNull(result);
	}
}
