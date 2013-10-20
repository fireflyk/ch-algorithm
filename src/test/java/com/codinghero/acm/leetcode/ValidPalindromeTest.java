package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ValidPalindromeTest {
	
	@Test
	public void testIsPalindrome() {
		Assert.assertEquals(true, new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
		Assert.assertEquals(false, new ValidPalindrome().isPalindrome("race a car"));
		Assert.assertEquals(false, new ValidPalindrome().isPalindrome("1a2"));
		Assert.assertEquals(true, new ValidPalindrome().isPalindrome(""));
	}
}
