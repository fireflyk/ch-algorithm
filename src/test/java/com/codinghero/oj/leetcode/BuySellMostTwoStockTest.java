package com.codinghero.oj.leetcode;

import org.junit.Test;

public class BuySellMostTwoStockTest {
	@Test
	public void test() {
		System.out.println(new BuySellMostTwoStock().maxProfit(
				new int[] { 1, 5, 3, 7 }));
		System.out.println(new BuySellMostTwoStock().maxProfit(
				new int[] { 1, 2 }));
	}
}
