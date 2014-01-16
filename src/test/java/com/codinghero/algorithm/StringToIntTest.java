package com.codinghero.algorithm;

import junit.framework.Assert;

import org.junit.Test;

public class StringToIntTest {

	@Test
	public void testAtoi() {
		Assert.assertEquals(1, new StringToInt().atoi("1"));
		Assert.assertEquals(0, new StringToInt().atoi("\"1\""));
		Assert.assertEquals(1, new StringToInt().atoi(" 1 \""));
		Assert.assertEquals(10, new StringToInt().atoi("010"));
		Assert.assertEquals(-1, new StringToInt().atoi("-1"));
		Assert.assertEquals(0, new StringToInt().atoi("- 1"));
		Assert.assertEquals(0, new StringToInt().atoi("-0"));
		Assert.assertEquals(-12, new StringToInt().atoi("-0012"));
		Assert.assertEquals(-10, new StringToInt().atoi("-10"));
		Assert.assertEquals(1, new StringToInt().atoi("1a2"));
		Assert.assertEquals(1, new StringToInt().atoi(" 1a2"));
		Assert.assertEquals(0, new StringToInt().atoi(" b"));
		Assert.assertEquals(-1, new StringToInt().atoi("-1a2"));
		Assert.assertEquals(1, new StringToInt().atoi("+1"));
		Assert.assertEquals(0, new StringToInt().atoi("+ 1"));
		Assert.assertEquals(Integer.MAX_VALUE, new StringToInt().atoi("11228552307"));
		Assert.assertEquals(Integer.MIN_VALUE, new StringToInt().atoi("-11228552307"));
		
	}
}
