package com.codinghero.acm.leetcode;

public class BuySellOneStock {
	public StockOperation operate(int[] price) {
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
		return so;
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
