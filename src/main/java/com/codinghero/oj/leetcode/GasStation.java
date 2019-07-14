package com.codinghero.oj.leetcode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0)
			return -1;
		
		int sum = 0;
		int i = 0;
		for (int j = 0; j < gas.length;) {
			int index = (i + j) % gas.length;
			sum += (gas[index] - cost[index]);
			if (sum >= 0) {
				j++;
			} else {
				j = 0;
				sum = 0;
				if (index >= i)
					i = index + 1;
				else
					return -1;
			}
		}
		return i;
	}
}
