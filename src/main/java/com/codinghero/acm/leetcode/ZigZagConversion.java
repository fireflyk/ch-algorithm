package com.codinghero.acm.leetcode;

public class ZigZagConversion {
	public String convert(String s, int height) {
		if (height == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int period = (height - 1) * 2;
		for (int i = 0; i < height && i < s.length(); i++) {
			final int plus = period - 2 * i;
			for (int j = i; j < s.length(); j += period) {
				if (i > 0 && i < height - 1) {
					sb.append(s.charAt(j));
					if (j + plus < s.length()) {
						sb.append(s.charAt(j + plus));
					}
				} else {
					sb.append(s.charAt(j));
				}
			}
		}
		return sb.toString();
	}
}
