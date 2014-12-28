package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class FractionToRecurringDecimalTest {
	
	private FractionToRecurringDecimal instance = new FractionToRecurringDecimal();

	@Test
	public void test0Divide1() {
		Assert.assertEquals("0", instance.fractionToDecimal(0, 1));
	}
	
	@Test
	public void test0Divide_1() {
		Assert.assertEquals("0", instance.fractionToDecimal(0, -1));
	}
	
	@Test
	public void test2Divide1() {
		Assert.assertEquals("2", instance.fractionToDecimal(2, 1));
	}

	@Test
	public void test1Divide2() {
		Assert.assertEquals("0.5", instance.fractionToDecimal(1, 2));
	}

	@Test
	public void test40Divide3() {
		Assert.assertEquals("13.(3)", instance.fractionToDecimal(40, 3));
	}

	@Test
	public void test_40Divide13() {
		Assert.assertEquals("-3.(076923)", instance.fractionToDecimal(-40, 13));
	}

	@Test
	public void test700Divide310() {
		Assert.assertEquals("2.3(6)", instance.fractionToDecimal(710, 300));
	}

	@Test
	public void test_700Divide_310() {
		Assert.assertEquals("2.3(6)", instance.fractionToDecimal(-710, -300));
	}
}
