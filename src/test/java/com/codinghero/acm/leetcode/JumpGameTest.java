package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class JumpGameTest {
	
	private JumpGame2 instance = new JumpGame2();
	
	@Test
	public void test1() {
		Assert.assertFalse(instance.canJump(new int[] { 4, 3, 2, 1, 0, 0 }));
		Assert.assertFalse(instance.canJump(new int[] { 4, 3, 2, 1, 0, 1, 0 }));
		Assert.assertTrue(instance.canJump(new int[] { 2, 0 }));
		Assert.assertTrue(instance.canJump(new int[] { 2, 3, 1, 1, 4 }));
		Assert.assertFalse(instance.canJump(new int[] { 3, 2, 1, 0, 4 }));
	}
}
