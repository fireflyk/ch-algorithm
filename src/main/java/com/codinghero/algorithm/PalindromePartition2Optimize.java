package com.codinghero.algorithm;

public class PalindromePartition2Optimize {
	public int minCut(String str) {

		int[] dp = new int[str.length() + 1];
		boolean[][] palindrome = new boolean[str.length()][str.length()];

		for (int i = 0; i <= str.length(); i++)
			dp[i] = str.length() - i;
		for (int i = 0; i < str.length(); i++)
			for (int j = 0; j < str.length(); j++)
				palindrome[i][j] = false;

		for (int i = str.length() - 1; i >= 0; i--) {
			for (int j = i; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j) && (j - i < 2 || palindrome[i + 1][j - 1])) {
					palindrome[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0] - 1;
	}
}
