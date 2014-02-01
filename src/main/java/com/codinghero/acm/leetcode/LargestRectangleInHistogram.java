package com.codinghero.acm.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < heights.length; i++) {
			if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
				//stack.push(i);
			} else {
				int recHeight = heights[stack.pop()];
				int recWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
				result = Math.max(result, recHeight * recWidth);
				stack.push(i);
			}
		}

		int i = heights.length - 1;
		while (!stack.isEmpty()) {
			int recHeight = heights[stack.pop()];
			int recWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
			result = Math.max(result, recHeight * recWidth);
		}
		
		return result;
	}
}
