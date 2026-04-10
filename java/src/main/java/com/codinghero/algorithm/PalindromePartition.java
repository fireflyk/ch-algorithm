package com.codinghero.algorithm;

import java.util.ArrayList;

/**
 * DP<br/>
 * head palindrome + recursively find palindrome list of the tail
 * 
 * @author Tong Liu
 *
 */
public class PalindromePartition {
	public ArrayList<ArrayList<String>> partition(String s) {
		if (s.length() == 0)
			return new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<ArrayList<String>>> memo = new ArrayList<ArrayList<ArrayList<String>>>();
		for (int i = 0; i < s.length(); i++) {
			memo.add(null);
		}
		partition(s, 0, memo);
		return memo.get(0);
	}

	private boolean partition(String s, int start, ArrayList<ArrayList<ArrayList<String>>> memo) {
		// use memo to prevent duplicate calculating
		if (memo.get(start) != null)
			return true;
		
		ArrayList<ArrayList<String>> curResult = new ArrayList<ArrayList<String>>();
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				// reach the end
				if (i + 1 == s.length()) {
					ArrayList<String> oneResult = new ArrayList<String>();
					oneResult.add(s.substring(start, i + 1));
					curResult.add(oneResult);
				}
				// recursively to find in the tail
				else if (partition(s, i + 1, memo)) {
					for (int j = 0; j < memo.get(i + 1).size(); j++) {
						ArrayList<String> oneResult = new ArrayList<String>();
						oneResult.add(s.substring(start, i + 1));
						oneResult.addAll(memo.get(i + 1).get(j));
						curResult.add(oneResult);
					}
				}
			}
		}
		memo.set(start, curResult);
		
		return memo.get(start) != null;
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
