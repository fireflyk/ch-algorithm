package com.codinghero.algorithm;

import junit.framework.Assert;

import org.junit.Test;

public class NumberUtilsTest {
	@Test
	public void testIsNumber() {
		Assert.assertTrue(new NumberUtils().isNumber("0"));
		Assert.assertTrue(new NumberUtils().isNumber("1"));
		Assert.assertTrue(new NumberUtils().isNumber("-1"));
		Assert.assertTrue(new NumberUtils().isNumber("10"));
		Assert.assertTrue(new NumberUtils().isNumber("0.1"));
		Assert.assertTrue(new NumberUtils().isNumber("0.01"));
		Assert.assertTrue(new NumberUtils().isNumber("0.10"));
		Assert.assertTrue(new NumberUtils().isNumber("1.00"));
		Assert.assertTrue(new NumberUtils().isNumber("-0.10"));
		Assert.assertTrue(new NumberUtils().isNumber(".1"));
		Assert.assertTrue(new NumberUtils().isNumber("-.1"));
		
		Assert.assertFalse(new NumberUtils().isNumber("-0"));
		Assert.assertFalse(new NumberUtils().isNumber("01"));
	}
}
