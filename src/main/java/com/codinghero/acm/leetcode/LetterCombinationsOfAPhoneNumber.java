package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	private static int CHAR_NUM = 26;
	
	private static char[][] dict = { {}, {}, { 'a', 'b', 'c' },
			{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
			{ 'w', 'x', 'y', 'z' } };
	
	public ArrayList<String> letterCombinations(String digits) {
		for (int i = 0; i < digits.length(); i++) {
			for (int j = 0; j < dict.length; j++) {
				
			}
		}
	}
	
	private int[] init(String digits) {
		int[] map = new int[CHAR_NUM];
		for (int i = 0; i < digits.length(); i++) {
			map[getInt(digits.charAt(i))]++;
		}
		return map;
	}
	
	private char getChar(int n) {
		return (char) ('a' + n);
	}
	
	private int getInt(char c) {
		return c - 'a';
	}
}
