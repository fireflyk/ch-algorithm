package com.codinghero.acm.leetcode;

import java.util.Arrays;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		return "";
	}
	
	static class BigInteger {
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
			nums = Arrays.copyOf(intArr, intArr.length);
		}
		
		public BigInteger add(BigInteger bigInteger) {
			int[] nums2 = bigInteger.toIntArray();
			return new BigInteger(this.add(nums, nums2));
		}
		
		public BigInteger multiply(BigInteger bigInteger) {
			int[] nums2 = bigInteger.toIntArray();
			int[] result = this.multipy(nums, nums2);
			return new BigInteger(result);
		}
		
		private int[] add(int[] nums1, int[] nums2) {
			int[] result = new int[Math.max(nums1.length, nums2.length) + 1];
			int i = nums1.length - 1, j = nums2.length - 1, k = result.length - 1;
			int carry = 0;
			// add every bit
			for (; i >= 0 && j >= 0; i--, j--, k--) {
				int temp = nums1[i] + nums2[j] + carry;
				result[k] = temp % 10;
				carry = temp / 10;
			}
			// add the left bit, if the 2 nums has different length
			if (i >= 0) {
				for (; i >= 0; i--, k--) {
					int temp = nums1[i] + carry;
					result[k] = temp % 10;
					carry = temp / 10;
				}
			} else if (j >= 0) {
				for (; j >= 0; j--, k--) {
					int temp = nums2[j] + carry;
					result[k] = temp % 10;
					carry = temp / 10;
				}
			}
			// if the carry bit is not used, remove the highest bit
			if (carry == 0) {
				result = Arrays.copyOfRange(result, 1, result.length);
			} else {
				result[k] = carry;
			}
			return result;
		}
		
		private int[] multipy(int[] nums1, int[] nums2) {
			int[] result = new int[] { 0 };
			// int[] result = new int[nums.length * nums2.length];
			int j = nums2.length - 1;
			for (; j >= 0; j--) {
				int[] temp = this.multipy(nums1, nums2[j], nums2.length - 1 - j);
				result = this.add(result, temp);
			}
			return result;
		}
		
		private int[] multipy(int[] nums1, int nums2, int leftMove) {
			int[] result = new int[nums1.length + 1 + leftMove];
			int carry = 0;
			int i = nums1.length - 1, k = result.length - 1 - leftMove;
			for (; i >= 0; i--, k--) {
				int temp = nums1[i] * nums2 + carry;
				result[k] = temp % 10;
				carry = temp / 10;
			}
			if (carry == 0) {
				result = Arrays.copyOfRange(result, 1, result.length);
			} else {
				result[k] = carry;
			}
			return result;
		}
		
		public int[] toIntArray() {
			return Arrays.copyOf(nums, nums.length);
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < nums.length; i++) {
				sb.append(nums[i]);
			}
			return sb.toString();
		}
	}
}
