package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ReverseWordsInAStringTest {

	private ReverseWordsInAString instance = new ReverseWordsInAString();
	
	@Test
	public void testReverseWords() {
//		Assert.assertEquals("", instance.reverseWords(""));
//		Assert.assertEquals("", instance.reverseWords(" "));
//		Assert.assertEquals("b a", instance.reverseWords("a b"));
//		Assert.assertEquals("b a", instance.reverseWords("a  b"));
		Assert.assertEquals("b a", instance.reverseWords(" a  b"));
		Assert.assertEquals("b a", instance.reverseWords(" a  b "));
		Assert.assertEquals("b a", instance.reverseWords("  a  b  "));
	}
}
