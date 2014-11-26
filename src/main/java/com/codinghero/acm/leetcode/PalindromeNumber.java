package com.codinghero.acm.leetcode;

public class PalindromeNumber {

	public boolean isPalindrome(int num) {
		return isPalindrome((long) num);
	}

	private boolean isPalindrome(long num) {
		if (num < 0)
			return false;
		long tempNum = num;
		long palinNum = 0;
		while (tempNum != 0) {
			long remainder = tempNum % 10;
			tempNum = (tempNum - remainder) / 10;
			palinNum *= 10;
			palinNum += remainder;
		}
		if (palinNum == num)
			return true;
		else
			return false;
	}
}
