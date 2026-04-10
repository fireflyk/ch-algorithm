package com.codinghero.oj.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		int result = 0;
		// record the ascending height with stack
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < heights.length; i++) {
			// ascend
			if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
				stack.push(i);
			}
			// descend
			// calculate the area: height * width(current high bar index - previous high bar index)
			else {
				int recHeight = heights[stack.pop()];
				int recWidth = stack.isEmpty() ? i : i - 1 - stack.peek();
				result = Math.max(result, recHeight * recWidth);
				i--;
			}
		}

		// ascending to the end, so pop to calculate
		int i = heights.length;
		while (!stack.isEmpty()) {
			int recHeight = heights[stack.pop()];
			int recWidth = stack.isEmpty() ? i : i - 1 - stack.peek();
			result = Math.max(result, recHeight * recWidth);
		}

		return result;
	}
}
