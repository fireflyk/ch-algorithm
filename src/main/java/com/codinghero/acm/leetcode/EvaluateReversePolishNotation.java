package com.codinghero.acm.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		if (tokens == null || tokens.length == 0) {
			throw new IllegalArgumentException();
		}
		for (String token : tokens) {
			if (isNumber(token)) {
				s.push(Integer.parseInt(token));
			} else {
				int num2 = s.pop();
				int num1 = s.pop();
				s.push(calculate(num1, num2, token));
			}
		}
		return s.pop();
	}

	private boolean isNumber(String numStr) {
		try {
			Integer.parseInt(numStr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private int calculate(int num1, int num2, String oper) {
		if (oper.equals("+")) {
			return num1 + num2;
		} else if (oper.equals("-")) {
			return num1 - num2;
		} else if (oper.equals("*")) {
			return num1 * num2;
		} else if (oper.equals("/")) {
			return num1 / num2;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
