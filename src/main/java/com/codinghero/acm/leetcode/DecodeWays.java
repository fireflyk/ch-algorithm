package com.codinghero.acm.leetcode;

import java.util.LinkedList;

public class DecodeWays {
	
	public int numDecodings(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] cArr = s.toCharArray();
		return numDecodings(cArr, 0, null);
	}
	
	private int numDecodings(char[] cArr, int startIndex, int[] memo) {
		if (startIndex == cArr.length - 1)
			return 1;
		else if (startIndex == cArr.length)
			return 0;
		
		char c1 = cArr[startIndex];
		Character ch1 = getChar(c1);
		
//		result.add(ch1.toString());
		int total = numDecodings(cArr, startIndex + 1, result);
//		result.removeLast();

		if (startIndex + 1 < cArr.length) {
			char c2 = cArr[startIndex + 1];
			Character ch2 = getChar(c1, c2);
			if (ch2 != null) {
//				result.add(ch2.toString());
				total += numDecodings(cArr, startIndex + 2, result);
//				result.removeLast();
			}
		}
		
		return total;
	}
	
	private Character getChar(int num) {
		if (num >= 1 && num <= 26)
			return (char) ('A' + num - 1);
		else
			return null;
	}

	private Character getChar(char c1) {
		int num1 = (int) (c1 - '0');
		return getChar(num1);
	}
	
	private Character getChar(char c1, char c2) {
		int num1 = (int) (c1 - '0');
		int num2 = (int) (c2 - '0');
		return getChar(num1 * 10 + num2);
	}
}
