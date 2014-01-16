package com.codinghero.algorithm;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class PalindromePartitionTest {
	
	@Test
	public void testPartition() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		Assert.assertEquals(result, new PalindromePartition().partition(""));
		
		ArrayList<String> result1 = new ArrayList<String>();
		result1.add("aa");
		result1.add("b");	
		ArrayList<String> result2 = new ArrayList<String>();
		result2.add("a");
		result2.add("a");
		result2.add("b");
		result.add(result2);
		result.add(result1);
		Assert.assertEquals(result, new PalindromePartition().partition("aab"));
	}
	
	@Test
	public void testPartition2() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> result1 = new ArrayList<String>();
		result1.add("a");
		result.add(result1);
		Assert.assertEquals(result, new PalindromePartition().partition("a"));
	}
	
	@Test
	public void testPartition3() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> result1 = new ArrayList<String>();
		result1.add("abcba");
		ArrayList<String> result2 = new ArrayList<String>();
		result2.add("a");
		result2.add("bcb");
		result2.add("a");
		ArrayList<String> result3 = new ArrayList<String>();
		result3.add("a");
		result3.add("b");
		result3.add("c");
		result3.add("b");
		result3.add("a");
		result.add(result3);
		result.add(result2);
		result.add(result1);
		Assert.assertEquals(result, new PalindromePartition().partition("abcba"));
	}
}
