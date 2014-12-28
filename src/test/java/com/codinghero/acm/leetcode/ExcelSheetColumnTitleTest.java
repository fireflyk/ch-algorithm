package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ExcelSheetColumnTitleTest {

	private ExcelSheetColumnTitle instance = new ExcelSheetColumnTitle();

	@Test
	public void testA() {
		Assert.assertEquals("A", instance.convertToTitle(1));
	}

	@Test
	public void testZ() {
		Assert.assertEquals("Z", instance.convertToTitle(26));
	}

	@Test
	public void testAA() {
		Assert.assertEquals("AA", instance.convertToTitle(27));
	}

	@Test
	public void testBB() {
		Assert.assertEquals("BB", instance.convertToTitle(54));
	}

	@Test
	public void testCZE() {
		Assert.assertEquals("CZE", instance.convertToTitle(2709));
	}
}
