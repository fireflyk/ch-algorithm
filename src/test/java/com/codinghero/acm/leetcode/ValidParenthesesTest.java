package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ValidParenthesesTest {
	
	@Test
	public void test() {
		ValidParentheses validParentheses = new ValidParentheses();
		Assert.assertEquals(true, validParentheses.isValid("()"));
		Assert.assertEquals(true, validParentheses.isValid("([]){}"));
		
		Assert.assertEquals(false, validParentheses.isValid("([)]"));
		Assert.assertEquals(false, validParentheses.isValid("()["));
		Assert.assertEquals(false, validParentheses.isValid("{"));
		Assert.assertEquals(false, validParentheses.isValid("]"));
	}
}
