package com.codinghero.oj.leetcode;

import java.util.Stack;

/**
 * Q739. Daily Temperatures. https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        // The stack stores index of the temperatures array which didn't find warmer temperature
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                int peekIndex = stack.peek();
                if (temperatures[i] > temperatures[peekIndex]) {
                    // The warmer temperature is found
                    stack.pop();
                    results[peekIndex] = i - peekIndex;
                } else {
                    // The warmer temperature is not found. Complete the loop.
                    break;
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            results[index] = 0;
        }
        return results;
    }
}
