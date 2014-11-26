package com.codinghero.acm.leetcode;

import java.util.Stack;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
		if (s == null)
			return null;
		else if (s.equals(""))
			return "";
		
		Stack<Character> stack = new Stack<Character>();
		boolean spaceFlag = false;
		StringBuilder sb = new StringBuilder();
		for (int j = s.length() - 1; j >= 0; j--) {
			if (s.charAt(j) != ' ') {
				if (spaceFlag) {
					sb.append(" ");
					spaceFlag = false;
				}
				stack.add(s.charAt(j));
			} else {
				if (!stack.isEmpty()) {
					sb.append(toString(stack));
					spaceFlag = true;
				}
			}
		}
		sb.append(toString(stack));
		return sb.toString();
	}
	
	private String toString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
