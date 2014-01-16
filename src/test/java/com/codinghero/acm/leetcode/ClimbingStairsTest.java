package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ClimbingStairsTest {
	
	@Test
	public void test() {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		Assert.assertEquals(1, climbingStairs.climbStairs(0));
		Assert.assertEquals(1, climbingStairs.climbStairs(1));
		Assert.assertEquals(2, climbingStairs.climbStairs(2));
		Assert.assertEquals(3, climbingStairs.climbStairs(3));
		Assert.assertEquals(5, climbingStairs.climbStairs(4));
		Assert.assertEquals(8, climbingStairs.climbStairs(5));
	}
}
