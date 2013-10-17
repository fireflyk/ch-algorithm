package com.codinghero.algorithm;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class ThreeSumTest {

	@Test
	public void threeSum() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		answer1.add(-1);
		answer1.add(0);
		answer1.add(1);
		ArrayList<Integer> answer2 = new ArrayList<Integer>();
		answer2.add(-1);
		answer2.add(-1);
		answer2.add(2);
		result.add(answer2);
		result.add(answer1);

		Assert.assertEquals(result, new ThreeSum().threeSum(nums));
	}

	@Test
	public void threeSum2() {
		int[] nums = { 0, 0, 0, 0, 0 };
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		answer1.add(0);
		answer1.add(0);
		answer1.add(0);
		result.add(answer1);

		Assert.assertEquals(result, new ThreeSum().threeSum(nums));
	}

	@Test
	public void threeSum3() {
		int[] nums = { 0, 0, 0 };
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		answer1.add(0);
		answer1.add(0);
		answer1.add(0);
		result.add(answer1);

		Assert.assertEquals(result, new ThreeSum().threeSum(nums));
	}

	@Test
	public void threeSum4() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Assert.assertEquals(result, new ThreeSum().threeSum(new int[] {}));
		Assert.assertEquals(result, new ThreeSum().threeSum(new int[] { 0 }));
		Assert.assertEquals(result, new ThreeSum().threeSum(new int[] { 0, 0 }));
	}
}
