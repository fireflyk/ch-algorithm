package com.codinghero.oj.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {
	@Test
	public void test1() {
		Candy candy = new Candy();
		
		Assert.assertEquals(9, candy.candy(new int[] { 4, 2, 3, 4, 1 }));
		
		Assert.assertEquals(21,
				candy.candy(new int[] { 10, 20, 20, 15, 10, 5, 20, 20, 10, 5 }));
		
		Assert.assertEquals(1, candy.candy(new int[] { 10 }));

		Assert.assertEquals(0, candy.candy(null));
	}
}
