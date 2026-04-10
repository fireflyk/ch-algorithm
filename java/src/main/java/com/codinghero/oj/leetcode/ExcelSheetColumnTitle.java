package com.codinghero.oj.leetcode;

import java.util.Stack;

/**
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author Tong Liu
 *
 */
public class ExcelSheetColumnTitle {

	private static int D = 26;

	public String convertToTitle(int n) {
		Stack<Character> stack = new Stack<Character>();
		convertToTile(n, stack);
		return getString(stack);
	}

	private void convertToTile(int n, Stack<Character> result) {
		if (n == 0)
			return;
		int r = n % D;
		if (r == 0)
			r = 26;
		result.push((char) ('A' + (r - 1)));
		convertToTile((n - r) / D, result);
	}

	private String getString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
