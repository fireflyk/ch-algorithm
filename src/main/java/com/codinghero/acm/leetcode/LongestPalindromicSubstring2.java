package com.codinghero.acm.leetcode;

public class LongestPalindromicSubstring2 {

	private int maxStartIndex = 0;
	private int maxEndIndex = 0;

	public String longestPalindrome(String s) {
		if (s == null || s.equals(""))
			return s;
		for (int mid = (s.length() - 1) / 2; mid >= 0 && (maxEndIndex - maxStartIndex + 1) < (mid + 1) * 2; mid--) {
			findPalindrome(s, mid, mid);
			findPalindrome(s, mid, mid + 1);
			int mirrorMid = s.length() - 1 - mid;
			if (mirrorMid != mid) {
				findPalindrome(s, mirrorMid, mirrorMid);
				findPalindrome(s, mirrorMid, mirrorMid + 1);
			}
		}
		return s.substring(maxStartIndex, maxEndIndex + 1);
	}

	private void findPalindrome(String s, int i, int j) {
		int offset = 0;
		for (; i - offset >= 0 && j + offset < s.length(); offset++) {
			if (s.charAt(i - offset) != s.charAt(j + offset)) {
				break;
			}
		}
		offset--;

		if (offset >= 0) {
			if (offset * 2 + (j - i) + 1 > maxEndIndex - maxStartIndex) {
				maxStartIndex = i - offset;
				maxEndIndex = j + offset;
			}
		}
	}
}
