package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class MajorityElementTest {
	
	private MajorityElement instance = new MajorityElement();
	
	@Test
	public void testOneElement() {
		Assert.assertEquals(10, instance.majorityElement(new int[] { 10 }));
	}
	
	@Test
	public void testSameElement1() {
		Assert.assertEquals(10, instance.majorityElement(new int[] { 10, 10 }));
	}
	
	@Test
	public void testSameElement2() {
		Assert.assertEquals(10, instance.majorityElement(new int[] { 10, 10, 10 }));
	}
	
	@Test
	public void testGeneral1() {
		Assert.assertEquals(10, instance.majorityElement(new int[] { 20, 10, 10 }));
	}
	
	@Test
	public void testGeneral2() {
		Assert.assertEquals(10, instance.majorityElement(new int[] { 10, 10, 5 }));
	}

	@Test
	public void testGeneral3() {
		Assert.assertEquals(10, instance.majorityElement(new int[] { 10, 10, 10, 30, 20, 5, 10, 10, 50, 10, 20, 10 }));
	}
}
