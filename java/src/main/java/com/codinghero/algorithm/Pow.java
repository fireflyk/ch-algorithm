package com.codinghero.algorithm;

public class Pow {
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				return 1 / pow(x, (n + 1) * -1) / x;
			} else {
				return 1 / pow(x, n * -1);
			}
		} else if (n == 1) {
			return x;
		} else if (n % 2 == 0) {
			double p = pow(x, n / 2);
			return p * p;
		} else {
			double p = pow(x, n / 2);
			return p * p * x;
		}
	}
}
