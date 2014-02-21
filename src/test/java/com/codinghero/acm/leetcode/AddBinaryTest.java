package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class AddBinaryTest {
	
	AddBinary instance = new AddBinary();
	
	@Test
	public void test1() {
		Assert.assertEquals("0", instance.addBinary("0", "0"));
		Assert.assertEquals("1", instance.addBinary("0", "1"));
		Assert.assertEquals("10", instance.addBinary("1", "1"));
		Assert.assertEquals("100", instance.addBinary("1", "11"));
		Assert.assertEquals("1000", instance.addBinary("1", "111"));
	}
}
