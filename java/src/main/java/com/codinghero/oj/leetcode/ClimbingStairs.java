package com.codinghero.oj.leetcode;

/**
 * DP Problem
 * 
 * @author Tong Liu
 *
 */
public class ClimbingStairs {
	
	public int climbStairs(int n) {
		if (n == 0)
			return 1;
		return climbStairs(n, new Integer[n + 1]);
	}
	
	private int climbStairs(int n, Integer[] memo) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		
		// recursively to calculate
		if (memo[n] == null) {
			memo[n] = climbStairs(n - 2, memo) + climbStairs(n - 1, memo);
		}
		return memo[n];
	}
}
