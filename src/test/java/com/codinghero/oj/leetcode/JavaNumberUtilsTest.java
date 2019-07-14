package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class JavaNumberUtilsTest {
	@Test
	public void testIsNumber() {
		double d = +.1e+0;
		Assert.assertFalse(new JavaNumberUtils().isNumber("1e1e"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("0"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("1"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-1"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("10"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("0.1"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("0.01"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("0.10"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("1.00"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-0.10"));
		Assert.assertTrue(new JavaNumberUtils().isNumber(".1"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-.1"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-1."));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-0"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("01"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("0e0"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-0e0"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-0.e0"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("-.1e0"));
		
		Assert.assertTrue(new JavaNumberUtils().isNumber("+.1e0"));
		Assert.assertTrue(new JavaNumberUtils().isNumber("+.1e+0"));
		
		Assert.assertFalse(new JavaNumberUtils().isNumber(" "));
		Assert.assertFalse(new JavaNumberUtils().isNumber("."));
		Assert.assertFalse(new JavaNumberUtils().isNumber("1e"));
		Assert.assertFalse(new JavaNumberUtils().isNumber("e0"));
		Assert.assertFalse(new JavaNumberUtils().isNumber("0.."));
		Assert.assertFalse(new JavaNumberUtils().isNumber("1e1e1"));
		Assert.assertFalse(new JavaNumberUtils().isNumber("1ee"));
	}
}
