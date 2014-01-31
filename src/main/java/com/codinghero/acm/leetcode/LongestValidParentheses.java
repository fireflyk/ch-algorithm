package com.codinghero.acm.leetcode;


public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		char[] cArr = s.toCharArray();
		int[] lengths = new int[cArr.length];
		int maxLength = 0;
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			if (c == '(') {
				lengths[i] = 0;
			} else if (c == ')') {
				// find the dp[i-1]
				if (i - 1 >= 0) {
					int j = i - 1 - lengths[i - 1];
					// find '('
					if (j >= 0 && cArr[j] == '(') {
						lengths[i] = lengths[i - 1] + 2;
						// merge the previous result, ex. '()(())' 2+4
						if (j - 1 >= 0)
							lengths[i] += lengths[j - 1];
						if (lengths[i] > maxLength)
							maxLength = lengths[i];
					}
					// can't find '('
					else {
						lengths[i] = 0;
					}
				}
				// can't find the dp[i-1]
				else {
					lengths[i] = 0;
				}
			} else {
				throw new RuntimeException();
			}
		}
		return maxLength;
	}
}
