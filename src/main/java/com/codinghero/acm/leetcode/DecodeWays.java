package com.codinghero.acm.leetcode;


public class DecodeWays {
	
	public int numDecodings(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] cArr = s.toCharArray();
		return numDecodings(cArr, 0, new Integer[cArr.length + 2]);
	}
	
	private int numDecodings(char[] cArr, int startIndex, Integer[] memo) {
		// cArr.length OR cArr.length + 1
		if (startIndex >= cArr.length) {
			memo[startIndex] = 1;
			return 1;
		}
		
		int total = 0;
		char c1 = cArr[startIndex];
		// i,{i+1...lenght-1}
		if (isLetter(c1)) {
			if (memo[startIndex + 1] == null)
				numDecodings(cArr, startIndex + 1, memo);
			total = memo[startIndex + 1];
		}

		// (i,i+1),{i+2...length-1}
		if (startIndex + 1 < cArr.length) {
			char c2 = cArr[startIndex + 1];
			if (isLetter(c1, c2)) {
				if (memo[startIndex + 2] == null)
					numDecodings(cArr, startIndex + 2, memo);
				total += memo[startIndex + 2];
			}
		}
		
		memo[startIndex] = total;
		return total;
	}
	
	private boolean isLetter(int num) {
		if (num >= 1 && num <= 26)
			return true;
		else
			return false;
	}
	
	private boolean isLetter(char c1) {
		int num1 = (int) (c1 - '0');
		return isLetter(num1);
	}
	
	private boolean isLetter(char c1, char c2) {
		int num1 = (int) (c1 - '0');
		if (num1 == 0)
			return false;
		int num2 = (int) (c2 - '0');
		return isLetter(num1 * 10 + num2);
	}
}
