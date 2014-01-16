package com.codinghero.acm.leetcode;

public class BuySellMultiStock {
	public int maxProfit(int[] price) {
		if (price == null || price.length == 0)
			return 0;

		int sum = 0;
		for (int i = 1; i < price.length; i++) {
			if (price[i] > price[i - 1])
				sum += (price[i] - price[i - 1]);
		}
		return sum;
	}
}
