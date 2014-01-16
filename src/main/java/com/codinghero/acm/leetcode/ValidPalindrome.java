package com.codinghero.acm.leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (!isValid(s.charAt(i))) {
				i++;
			} else if (!isValid(s.charAt(j))) {
				j--;
			} else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	private boolean isValid(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
			return true;
		else
			return false;
	}
}
