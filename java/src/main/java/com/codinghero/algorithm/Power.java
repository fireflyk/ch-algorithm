package com.codinghero.algorithm;


public class Power {
	
	public long cal(int base, int index) {
		if (index == 0)
			return 1;
		else if (index % 2 == 0) {
			long tempResult = cal(base, index / 2);
			return tempResult * tempResult;
		} else {
			long tempResult = cal(base, (index - 1) / 2);
			return ((long) base) * tempResult * tempResult;
		}
	}
}
