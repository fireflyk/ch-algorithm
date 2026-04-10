package com.codinghero.oj.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {
	
	@Test
	public void test1() {
		TrappingRainWater trappingRainWater = new TrappingRainWater();
		// 0,1,0,2,1,0,1,3,2,1,2,1
		// 0,0,1,0,1,2,1,0,1,2,1,0
		// 0,0,1,0,1,2,1,0,0,1,0,0
		Assert.assertEquals(6, trappingRainWater.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		// 5,2,1,2,1,5
		// 0,3,4,3,4,0
		Assert.assertEquals(14, trappingRainWater.trap(new int[] { 5, 2, 1, 2, 1, 5 }));
		
		Assert.assertEquals(0, trappingRainWater.trap(new int[] { 0 }));
		Assert.assertEquals(0, trappingRainWater.trap(new int[] { 0, 0 }));
		Assert.assertEquals(0, trappingRainWater.trap(new int[] { 0, 1, 0 }));
		Assert.assertEquals(1, trappingRainWater.trap(new int[] { 1, 0, 1 }));
		
	}
}
