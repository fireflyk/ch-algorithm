package com.codinghero.interview.amazon;

import java.util.Stack;

public class ValidateStatement {

	static boolean isBalanced(String input) {
		if (input == null)
			return true;
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(' || c == '[') {
				s.push(c);
			} else if (c == ')') {
				if (s.isEmpty() || s.pop() != '(') {
					return false;
				}
			} else if (c == ']') {
				if (s.isEmpty() || s.pop() != '[') {
					return false;
				}
			}
		}
		if (s.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
