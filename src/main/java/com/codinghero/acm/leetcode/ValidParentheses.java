package com.codinghero.acm.leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null)
			return true;
		char[] cArr = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (char c : cArr) {
			if(isLeft(c)) {
				stack.push((int) c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char cInStack = (char) stack.pop().intValue();
				if (!isMatch(cInStack, c))
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
	
	private boolean isLeft(char c) {
		if (c == '(' || c == '[' || c == '{')
			return true;
		else
			return false;
	}
	
	private boolean isMatch(char c1, char c2) {
		if ((c1 == '(' && c2 == ')') 
				|| (c1 == '[' && c2 == ']')
				|| (c1 == '{' && c2 == '}'))
			return true;
		else
			return false;
	}
}
