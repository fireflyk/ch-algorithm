package com.codinghero.oj.leetcode;

public class BuySellOneStock {
	public int maxProfit(int[] price) {
		if (price == null || price.length == 0)
			return 0;
		
		int min = price[0];
		StockOperation so = new StockOperation(price[0], price[0]);
		for (int i = 1; i < price.length; i++) {
			if (price[i] < min)
				min = price[i];
			else if (price[i] - min > so.getProfit()) {
				so.buyPrice = min;
				so.sellPrice = price[i];
			}
		}
		return so.getProfit();
	}

	public class StockOperation {
		public int buyPrice;
		public int sellPrice;

		public StockOperation(int buyPrice, int sellPrice) {
			this.buyPrice = buyPrice;
			this.sellPrice = sellPrice;
		}

		public int getProfit() {
			return sellPrice - buyPrice;
		}
	}
}
