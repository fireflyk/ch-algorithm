package com.codinghero.algorithm;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.codinghero.acm.etc.SubArrayMaxSum;
import com.codinghero.acm.etc.SubArrayMaxSumAns1;
import com.codinghero.acm.etc.SubArrayMaxSumAns2;
import com.codinghero.acm.etc.SubArrayMaxSumAns3;

public class SubArrayMaxSumTest {
	
	@Test
	public void testCal() {
		testCal(new SubArrayMaxSumAns1());
		testCal(new SubArrayMaxSumAns2());
		testCal(new SubArrayMaxSumAns3());
	}
	
	private void testCal(SubArrayMaxSum s) {
		assertEquals(0, s.calMaxSum(new int[] { 0 }));
		assertEquals(1, s.calMaxSum(new int[] { 1, -1 }));
		assertEquals(1, s.calMaxSum(new int[] { -1, 1 }));
		assertEquals(-1, s.calMaxSum(new int[] { -1, -2 }));
		assertEquals(-1, s.calMaxSum(new int[] { -3, -1, -2 }));
		assertEquals(2, s.calMaxSum(new int[] { -3, 1, -2, 2 }));
		// sub array: 3,-2,5,-1,3,-5,9
		assertEquals(12,
				s.calMaxSum(new int[] { -7, 3, -2, 5, -1, 3, -5, 9 }));
		// sub array: 3,-2,5,-1,3
		assertEquals(8,
				s.calMaxSum(new int[] { -7, 3, -2, 5, -1, 3, -5}));
		// sub array: 1,3,-2,5,-1,3
		assertEquals(9,
				s.calMaxSum(new int[] { 1, 3, -2, 5, -1, 3, -5, -1 }));
	}
}
