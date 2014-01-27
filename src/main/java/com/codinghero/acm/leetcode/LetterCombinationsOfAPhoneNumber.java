package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	private static int CHAR_NUM = 26;
	
	public ArrayList<String> letterCombinations(String digits) {
		int[] map = this.init(digits);
		this.letterCombinations(map, digits.length(), prefix, result);
	}
	
	private void letterCombinations(int[] map, int n, StringBuilder prefix, ArrayList<String> result) {
		if (n == 0)
			result.add(prefix.toString());
		for (int i = 0; i < CHAR_NUM; i++) {
			if (map[i] != 0) {
				map[i]--;
				letterCombinations(map, n - 1, prefix.append(getChar(i)), result);
				prefix.deleteCharAt(prefix.length() - 1);
				map[i]++;
			}
		}
	}

	private int[] init(String digits) {
		int[] map = new int[CHAR_NUM];
		for (int i = 0; i < digits.length(); i++) {
			
		}
		return map;
	}
	
	private char getChar(int n) {
		return (char) ('a' + n);
	}
}
