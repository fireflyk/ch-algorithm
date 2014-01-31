package com.codinghero.acm.leetcode;

import java.util.LinkedList;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		char[] cArr = s.toCharArray();
		int maxLength = 0, leftBracket = 0, rightBracket = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (char c : cArr) {
			if (c == '(') {
				leftBracket++;
			} else if (c == ')') {
				if (leftBracket > rightBracket) {
					rightBracket++;
					if (!list.isEmpty()) {
						Integer last = list.removeLast();
						int curLength = last + 2;
						if (curLength > maxLength)
							maxLength = curLength;
						list.addLast(curLength);
					} else {
						if (2 > maxLength)
							maxLength = 2;
						list.addLast(2);
					}
				}
//				else if (curLength == 1) {
//				}
//				else if (leftBracket == rightBracket) {
//					leftBracket = 0;
//					rightBracket = 0;
//				} else {
//					throw new RuntimeException();
//				}
			} else {
				throw new RuntimeException();
			}
		}
		return maxLength;
	}
}
