package com.codinghero.acm.leetcode;

public class Divide {

	private static int[] pow2 = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
			2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288,
			1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864,
			134217728, 268435456, 536870912, 1073741824 };

	public int divide(int dividend, int divisor) {
		if (dividend < 0 && divisor < 0)
			return divideOperation(0L - (long) dividend, 0L - (long) divisor);
		else if (dividend < 0)
			return (int) (0L - divideOperation(0L - (long) dividend, divisor));
		else if (divisor < 0)
			return (int) (0L - divideOperation(dividend, 0L - (long) divisor));
		else
			return divideOperation(dividend, divisor);
	}
	
	private int divideOperation(long dividend, long divisor) {
		if (dividend < divisor)
			return 0;
		
		int i = 0;
		long sumDivisor = divisor;
		for (; i < pow2.length && (sumDivisor + sumDivisor) < dividend
				&& sumDivisor < pow2[pow2.length - 1]; i++) {
			sumDivisor = sumDivisor + sumDivisor;
		}
		return pow2[i--] + divideOperation(dividend - sumDivisor, divisor);
	}

	// private int divide(int dividend, int divisor, int level) {
	// if (dividend < divisor)
	// return result;
	// else {
	// int newDivisor = divisor + divisor;
	// if (dividend < newDivisor) {
	// return result + 1;
	// } else {
	// return divide(dividend, newDivisor, result) + result;
	// }
	// }
	// }
}