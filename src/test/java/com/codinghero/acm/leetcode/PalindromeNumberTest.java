package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class PalindromeNumberTest {
	
	private PalindromeNumber instance = new PalindromeNumber();
	
	@Test
	public void test1() {
		Assert.assertTrue(instance.isPalindrome(0));
		Assert.assertTrue(instance.isPalindrome(1));
		Assert.assertTrue(instance.isPalindrome(11));
		Assert.assertTrue(instance.isPalindrome(121));
		Assert.assertTrue(instance.isPalindrome(12321));
		Assert.assertTrue(instance.isPalindrome(1221));
		
		Assert.assertFalse(instance.isPalindrome(1201));
		Assert.assertFalse(instance.isPalindrome(-2147447412));
	}
}
