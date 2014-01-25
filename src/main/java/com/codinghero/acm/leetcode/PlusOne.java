package com.codinghero.acm.leetcode;


public class PlusOne {
	public int[] plusOne(int[] digits) {
		return this.plusOne(digits, digits.length - 1);
	}
	
	private int[] plusOne(int[] digits, int index) {
		// plus one to add an extra bit
		if (index == -1) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			for (int i = 1; i < result.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;
		}
		
		// add
		digits[index]++;
		if (digits[index] < 10)
			return digits;
		else {
			digits[index] %= 10;
			return plusOne(digits, --index);
		}
	}
}
