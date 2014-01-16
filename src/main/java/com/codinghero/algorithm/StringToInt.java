package com.codinghero.algorithm;

public class StringToInt {
	public int atoi(String str) {
		// 0-9 (2)end
		// (2) 0-9 (2)end
		// - (3)
		// (3) 0-9 (4)end
		// (4) 0-9 (4)end
		// + (2)
		final long MAX_INT = Integer.MAX_VALUE;
		final long MIN_INT = Integer.MIN_VALUE;
		int state = 0;
		long num = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (state == 0) {
				if (c == '-') {
					state = 3;
				} else if (c == '+') {
					state = 2;
				} else if (c == ' ') {
					continue;
				} else if (c < '0' || c > '9') {
					return 0;
				} else {
					num = (c - '0');
					state = 2;
				}
			} else if (state == 2) {
				if (c == '-')
					return 0;
				else if (c < '0' || c > '9') {
					break;
				} else {
					num *= 10;
					num += (c - '0');
					// state no change
				}
			} else if (state == 3) {
				if (c == '-')
					return 0;
				else if (c < '0' || c > '9') {
					break;
				} else {
					num = -1 * (c - '0');
					state = 4;
				}
			} else if (state == 4) {
				if (c == '-')
					return 0;
				else if (c < '0' || c > '9') {
					break;
				} else {
					num *= 10;
					num -= (c - '0');
				}
			}
			if (num > MAX_INT)
				return Integer.MAX_VALUE;
			else if (num < MIN_INT)
				return Integer.MIN_VALUE;
		}
		return (int) num;
	}
}
