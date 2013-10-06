package com.codinghero.acm.leetcode;


public class BuySellMostTwoStock {
	public int maxProfit(int[] price) {
		if (price == null || price.length == 0)
			return 0;

		int[] profit = new int[price.length];
		int min = price[0];
		int maxProfit = 0;
		for (int i = 1; i < price.length; i++) {
			if (price[i] < min)
				min = price[i];
			else if (price[i] - min > maxProfit) {
				maxProfit = price[i] - min;
			}
			profit[i] = maxProfit;
		}
		
		int max = price[price.length - 1];
		maxProfit = 0;
		for (int i = price.length - 2; i >= 0; i++) {
			if (price[i] > max)
				max = price[i];
			else if (max - price[i] > maxProfit) {
				maxProfit = max - price[i];
			}
			profit[i] += maxProfit;
		}
		
		
		// find max
		int totalMaxProfit = 0;
		for (int i = 0; i < price.length; i++) {
			if (profit[i] > totalMaxProfit)
				totalMaxProfit = profit[i];
		}
		return totalMaxProfit;
	}
}
