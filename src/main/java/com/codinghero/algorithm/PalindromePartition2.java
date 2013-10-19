package com.codinghero.algorithm;

import java.util.ArrayList;

public class PalindromePartition2 {

	public int minCut(String s) {
		ArrayList<Integer> memo = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			memo.add(null);
		}
		partition(s, 0, memo);
		return memo.get(0);
	}

	private void partition(String s, int start, ArrayList<Integer> memo) {

		if (s.length() == 0) {
			memo.add(0);
			return;
		} else if (start == s.length() - 1) {
			memo.set(start, 0);
			return;
		} else if (memo.get(start) != null) {
			return;
		} else if (isPalindrome(s, start, s.length() - 1)) {
			memo.set(start, 0);
			return;
		}

		int minCut = Integer.MAX_VALUE;
		for (int i = start; i < s.length() - 1; i++) {
			if (isPalindrome(s, start, i)) {
				partition(s, i + 1, memo);
				if (memo.get(i + 1) + 1 < minCut) {
					minCut = memo.get(i + 1) + 1;
				}
			}
		}

		memo.set(start, minCut);
	}

	private boolean isPalindrome(String s, final int start, final int end) {
		
		int i = start, j = end;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		}
		return true;
	}
}
