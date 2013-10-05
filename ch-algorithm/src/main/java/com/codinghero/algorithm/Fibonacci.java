package com.codinghero.algorithm;

/**
 * fibonacci sequence
 * 
 * @author liutong01
 * 
 */
public class Fibonacci {
	public int cal(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		
		int fNMinusTwo = -1, fNMinusOne = 1, fN = 0;	// f(-2)=-1, f(-1)=1, f(0)=0
		for (int i = 0; i <= n; i++) {
			fN = fNMinusTwo + fNMinusOne;				// f(n)=f(n-2)+f(n-1)
			fNMinusTwo = fNMinusOne;
			fNMinusOne = fN;
		}
		return fN;
	}
}
