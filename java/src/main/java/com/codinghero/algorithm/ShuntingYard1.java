package com.codinghero.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * nifix to suffix expression<br/>
 * handle +,-,*,/
 * 
 * @author Tong Liu
 *
 */
public class ShuntingYard1 {

	private static Map<String, Integer> PRIORITY = new HashMap<String, Integer>();

	static {
		PRIORITY.put("+", 1);
		PRIORITY.put("-", 1);
		PRIORITY.put("*", 2);
		PRIORITY.put("/", 2);
	}

	public static boolean isOper(String str) {
		return PRIORITY.containsKey(str);
	}

	public String[] transform(char[] nifix) {
		String[] nifixStr = new String[nifix.length];
		for (int i = 0; i < nifix.length; i++)
			nifixStr[i] = String.valueOf(nifix[i]);
		return transform(nifixStr);
	}

	private String[] transform(String[] nifix) {

		String[] suffix = new String[nifix.length];

		Stack<String> stack = new Stack<String>();
		int suffixIndex = 0;
		for (int i = 0; i < nifix.length; i++) {
			String curr = nifix[i];
			// number, then output
			if (!isOper(curr)) {
				suffix[suffixIndex++] = curr;
			}
			// operation
			else {
				while (!stack.isEmpty()
						&& getPriority(curr) <= getPriority(stack.peek())) {
					suffix[suffixIndex++] = stack.pop();
				}
				stack.push(curr);
			}
		}

		// pop some left oper which is the lowest priority
		while (!stack.isEmpty()) {
			suffix[suffixIndex++] = stack.pop();
		}
		return suffix;
	}

	private int getPriority(String str) {
		return PRIORITY.get(str);
	}
}
