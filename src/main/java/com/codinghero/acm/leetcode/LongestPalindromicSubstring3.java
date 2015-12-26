package com.codinghero.acm.leetcode;

public class LongestPalindromicSubstring3 {
	
	public String longestPalindrome(String s) {
		int maxStartIndex = 0, maxEndIndex = 0;
		for (int i = s.length() / 2; i < s.length(); i++) {
			// step1
			int subStartIndex = palindromeIndex(s, i);
			int subEndIndex = i * 2 - subStartIndex;

			if (subEndIndex - subStartIndex > maxEndIndex - maxStartIndex) {
				maxStartIndex = subStartIndex;
				maxEndIndex = subEndIndex;
			}

			int nextEndIndex = s.length() - 1;
			int nextStartIndex = (i + 1) * 2 - nextEndIndex;

			if (nextEndIndex - nextStartIndex < maxEndIndex - maxStartIndex) {
				return s.substring(maxStartIndex, maxEndIndex + 1);
			}

			// step2
			int j = (s.length() - 1) - i;
			if (i == j)
				continue;

			// step3
			subStartIndex = palindromeIndex(s, j);
			subEndIndex = j * 2 - subStartIndex;

			if (subEndIndex - subStartIndex > maxEndIndex - maxStartIndex) {
				maxStartIndex = subStartIndex;
				maxEndIndex = subEndIndex;
			}

			nextStartIndex = 0;
			nextEndIndex = (j - 1) * 2 - nextStartIndex;

			if (nextEndIndex - nextStartIndex < maxEndIndex - maxStartIndex) {
				return s.substring(maxStartIndex, maxEndIndex + 1);
			}
		}
		return s.substring(maxStartIndex, maxEndIndex + 1);
	}

	private int palindromeIndex(String s, int i) {
		int offset = 1;
		for (; i - offset >= 0 && i + offset < s.length(); offset++) {
			if (s.charAt(i - offset) != s.charAt(i + offset)) {
				break;
			}
		}
		offset--;
		return i - offset;
	}
}
