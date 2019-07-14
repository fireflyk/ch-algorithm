package com.codinghero.oj.leetcode;

public class ValidPalindromeOptimize {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		boolean leftFlag = false;
		while (i < j) {
			if (!leftFlag && !isValid(s.charAt(i))) {
				i++;
				leftFlag = false;
			} else if (!isValid(s.charAt(j))) {
				j--;
				leftFlag = true;
			} else if (Character.toLowerCase(s.charAt(i)) != Character
					.toLowerCase(s.charAt(j))) {
				return false;
			} else {
				i++;
				j--;
				leftFlag = false;
			}
		}
		return true;
	}

	private boolean isValid(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
				|| (c >= '0' && c <= '9'))
			return true;
		else
			return false;
	}
}
