package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.oj.leetcode.MultiplyStrings.BigInteger;

public class MultiplyStringsTest {
	@Test
	public void test1() {
		BigInteger num1 = new BigInteger("1");
		BigInteger num2 = new BigInteger("2");
		BigInteger result = num1.add(num2);
		Assert.assertEquals("3", result.toString());
	}

	@Test
	public void test2() {
		BigInteger num1 = new BigInteger("11");
		BigInteger num2 = new BigInteger("2");
		BigInteger result = num1.add(num2);
		Assert.assertEquals("13", result.toString());
	}

	@Test
	public void test6() {
		BigInteger num1 = new BigInteger("99");
		BigInteger num2 = new BigInteger("99");
		BigInteger result = num1.add(num2);
		Assert.assertEquals("198", result.toString());
	}

	@Test
	public void test3() {
		BigInteger num1 = new BigInteger("1");
		BigInteger num2 = new BigInteger("2");
		BigInteger result = num1.multiply(num2);
		Assert.assertEquals("2", result.toString());
	}

	@Test
	public void test4() {
		BigInteger num1 = new BigInteger("10");
		BigInteger num2 = new BigInteger("10");
		BigInteger result = num1.multiply(num2);
		Assert.assertEquals("100", result.toString());
	}

	@Test
	public void test5() {
		BigInteger num1 = new BigInteger("99");
		BigInteger num2 = new BigInteger("99");
		BigInteger result = num1.multiply(num2);
		Assert.assertEquals("9801", result.toString());
	}

	@Test
	public void test7() {
		BigInteger num1 = new BigInteger("0");
		BigInteger num2 = new BigInteger("0");
		BigInteger result = num1.multiply(num2);
		Assert.assertEquals("0", result.toString());
	}

	@Test
	public void test8() {
		BigInteger num1 = new BigInteger("11");
		BigInteger num2 = new BigInteger("0");
		BigInteger result = num1.multiply(num2);
		Assert.assertEquals("0", result.toString());
	}
}
