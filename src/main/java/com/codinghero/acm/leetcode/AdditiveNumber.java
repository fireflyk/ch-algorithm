package com.codinghero.acm.leetcode;

public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		for (int sumStartIndex = num.length() - 1, sumEndIndex = num.length() - 1; sumStartIndex >= 2; sumStartIndex--) {
			if (isHeadZero(num, sumStartIndex, sumEndIndex)) {
				continue;
			}
			for (int si2 = sumStartIndex - 1, ei2 = sumStartIndex - 1; ei2 - si2 <= sumEndIndex - sumStartIndex && si2 >= 0; si2--) {
				if (isHeadZero(num, si2, ei2)) {
					continue;
				} else if (isAdditiveNumber(num, si2, ei2, sumEndIndex)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isAdditiveNumber(String num, int si2, int ei2, int sumEndIndex) {
		int sumStartIndex = ei2 + 1;
		for (int si1 = si2 - 1, ei1 = si2 - 1; ei1 - si1 <= sumEndIndex - sumStartIndex && si1 >= 0; si1--) {
			if (isHeadZero(num, si1, ei1)) {
				continue;
			} else if (isSum(num, si1, ei1, si2, ei2, sumEndIndex)) {
				// End Statement
				if (si1 == 0) {
					return true;
				} else if (isAdditiveNumber(num, si1, ei1, ei2)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isHeadZero(String num, int startIndex, int endIndex) {
		return '0' == num.charAt(startIndex) && startIndex != endIndex;
	}

	private boolean isSum(String num, int si1, int ei1, int si2, int ei2, int sumEndIndex) {
		return isSum(num, si1, ei1, si2, ei2, sumEndIndex, 0);
	}

	private boolean isSum(String str, int si1, int ei1, int si2, int ei2, int sumEndIndex, int carryBit) {
		int n1 = 0, n2 = 0;
		if (si1 > ei1 && si2 > ei2) {
			return true;
		}
		if (si1 <= ei1) {
			n1 = ctoi(str.charAt(ei1));
		}
		if (si2 <= ei2) {
			n2 = ctoi(str.charAt(ei2));
		}
		int curSum = n1 + n2 + carryBit;
		if (curSum % 10 == ctoi(str.charAt(sumEndIndex))) {
			return isSum(str, si1, ei1 - 1, si2, ei2 - 1, sumEndIndex - 1, curSum / 10);
		} else {
			return false;
		}
	}

	private int ctoi(char c) {
		return (c - '0');
	}
}
