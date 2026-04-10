package com.codinghero.oj.leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		return addBinary(a.toCharArray(), b.toCharArray());
	}

	private String addBinary(char[] aArr, char[] bArr) {
		char[] result = new char[Math.max(aArr.length, bArr.length) + 1];
		int i = aArr.length - 1, j = bArr.length - 1, index = result.length - 1;
		int carryBit = 0;
		for (; i >= 0 && j >= 0; index--) {
			int sum = ((aArr[i--] - '0') + (bArr[j--] - '0') + carryBit);
			int remainder = sum % 2;
			result[index] = (char) (remainder + '0');
			carryBit = (sum - remainder) / 2;
		}
		while (i >= 0) {
			int sum = ((aArr[i--] - '0') + carryBit);
			int remainder = sum % 2;
			result[index--] = (char) (remainder + '0');
			carryBit = (sum - remainder) / 2;
		}
		while (j >= 0) {
			int sum = ((bArr[j--] - '0') + carryBit);
			int remainder = sum % 2;
			result[index--] = (char) (remainder + '0');
			carryBit = (sum - remainder) / 2;
		}
		if (carryBit == 1)
			result[index--] = '1';
		return new String(result, index + 1, result.length - index - 1);
	}
	
}
