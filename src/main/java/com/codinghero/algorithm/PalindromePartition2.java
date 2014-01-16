package com.codinghero.algorithm;

import java.util.ArrayList;

public class PalindromePartition2 {

	public int minCut(String s) {
		ArrayList<Integer> partitionMemo = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			partitionMemo.add(null);
		}
		int[][] palindromeMemo = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (i != j)
					palindromeMemo[i][j] = -1;
				else
					palindromeMemo[i][j] = 1;
			}
		}

		partition(s, 0, partitionMemo, palindromeMemo);
		return partitionMemo.get(0);
	}

	private void partition(String s, int start, ArrayList<Integer> memo, int[][] palindromeMemo) {

		if (s.length() == 0) {
			memo.add(0);
			return;
		} else if (start == s.length() - 1) {
			memo.set(start, 0);
			return;
		} else if (memo.get(start) != null) {
			return;
		} else if (isPalindrome(s, start, s.length() - 1, palindromeMemo)) {
			memo.set(start, 0);
			return;
		}

		int minCut = Integer.MAX_VALUE;
		for (int i = start; i < s.length() - 1; i++) {
			if (isPalindrome(s, start, i, palindromeMemo)) {
				partition(s, i + 1, memo, palindromeMemo);
				if (memo.get(i + 1) + 1 < minCut) {
					minCut = memo.get(i + 1) + 1;
				}
			}
		}

		memo.set(start, minCut);
	}

	private boolean isPalindrome(String s, final int start, final int end,
			int[][] memo) {
		int i = start, j = end;
		while (i < j) {
			if (memo[i][j] == 0)
				return false;
			else if (memo[i][j] == 1)
				return true;
			else if (s.charAt(i++) != s.charAt(j--)) {
				memo[start][end] = 0;
				return false;
			}
		}
		memo[start][end] = 1;
		return true;
	}
}
