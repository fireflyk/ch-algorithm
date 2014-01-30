package com.codinghero.acm.leetcode;

import java.util.Arrays;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		return "";
	}
	
	private class BigInteger {
		private int[] nums;
		
		public BigInteger(String str) {
			if (str == null || str.length() == 0)
				throw new IllegalArgumentException("Null BigInteger");
			char[] cArr = str.toCharArray();
			nums = new int[cArr.length];
			for (int i = 0; i < cArr.length; i++) {
				nums[i] = cArr[i] - '0';
			}
		}
		
		public BigInteger(int[] intArr) {
			Arrays.copyOf(intArr, intArr.length);
		}
		
		public BigInteger add(BigInteger bigInteger) {
			int[] nums2 = bigInteger.toIntArray();
			int[] result = new int[Math.max(nums.length, nums2.length) + 1];
			int i = nums.length - 1, j = nums2.length - 1, k = result.length - 1;
			int carry = 0;
			for (; i >= 0 && j >= 0; i--, j--, k--) {
				int temp = nums[i] + nums2[j] + carry;
				result[k] = temp % 10;
				carry = temp / 10;
			}
			if (i >= 0) {
				for (; i >= 0; i--, k--) {
					int temp = nums[i] + carry;
					result[k] = temp % 10;
					carry = temp / 10;
				}
			} else if (j >= 0) {
				int temp = nums2[j] + carry;
				result[k] = temp % 10;
				carry = temp / 10;
			} else {
				throw new RuntimeException();
			}
			if (k == 0) {
				result = Arrays.copyOf(result, result.length - 1);
			}
			
			return new BigInteger(result);
		}
		
		public int[] toIntArray() {
			return Arrays.copyOf(nums, nums.length);
		}
	}
}
