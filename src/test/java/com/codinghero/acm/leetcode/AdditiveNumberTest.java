package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class AdditiveNumberTest {

	private AdditiveNumber instance = new AdditiveNumber();
	
	@Test
	public void test1() {
		Assert.assertTrue(instance.isAdditiveNumber("112358"));
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(instance.isAdditiveNumber("199100199"));
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(instance.isAdditiveNumber("125"));
	}
	
	@Test
	public void test4() {
		Assert.assertFalse(instance.isAdditiveNumber("1203"));
	}
	
	@Test
	public void test5() {
		Assert.assertFalse(instance.isAdditiveNumber("0235813"));
	}
}