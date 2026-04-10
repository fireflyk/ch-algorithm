package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LetterCombinationsOfAPhoneNumber {
	
	private static char[][] dict = { {}, {}, { 'a', 'b', 'c' },
			{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
			{ 'w', 'x', 'y', 'z' } };
	
	public ArrayList<String> letterCombinations(String digits) {
		Set<String> result = new HashSet<String>();
		if (digits.equals("")) {
			result.add("");
			return new ArrayList<String>(result);
		}
		for (int i = 0; i < digits.length(); i++) {
			this.letterCombinations(digits, 0, new StringBuilder(), result);
		}
		return new ArrayList<String>(result);
	}
	
	private void letterCombinations(String digits, int i, StringBuilder prefix, Set<String> result) {
		if (i == digits.length()) {
			result.add(prefix.toString());
		} else {
			int cInt = numStrToNumInt(digits.charAt(i));
			for (int j = 0; j < dict[cInt].length; j++) {
				// append this bit char
				prefix.append(dict[cInt][j]);
				// append next bit char recursively
				this.letterCombinations(digits, i + 1, prefix, result);
				// delete this bit char
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}
	}
	
	private int numStrToNumInt(char c) {
		return c - '0';
	}
}
