package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class JumpGameIITest {
	
	private JumpGameII instance = new JumpGameII();
	
	@Test
	public void test1() {
		Assert.assertEquals(2, instance.jump(new int[] { 2, 3, 1, 1, 4 }));
		Assert.assertEquals(3, instance.jump(new int[] { 1, 1, 1, 1 }));
		Assert.assertEquals(1, instance.jump(new int[] { 2, 3, 1 }));
		Assert.assertEquals(
				2,
				instance.jump(new int[] { 7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2,
						9, 0, 3 }));
	}
}
