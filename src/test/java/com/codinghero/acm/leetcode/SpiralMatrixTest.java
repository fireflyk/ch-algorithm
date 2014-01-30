package com.codinghero.acm.leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class SpiralMatrixTest {
	@Test
	public void test() {
		SpiralMatrix instance = new SpiralMatrix();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		ArrayList<Integer> result = instance.spiralOrder(matrix);
		Assert.assertEquals(5, result.get(8).intValue());
		
		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		result = instance.spiralOrder(matrix);
		Assert.assertEquals(7, result.get(11).intValue());
	}
}
