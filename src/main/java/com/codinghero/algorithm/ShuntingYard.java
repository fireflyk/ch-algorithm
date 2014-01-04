package com.codinghero.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * nifix to suffix expression
 * 
 * @author Tong Liu
 * 
 */
public class ShuntingYard {

	private static Map<String, Integer> PRIORITY = new HashMap<String, Integer>();
	
	static {		
		PRIORITY.put("+", 1);
		PRIORITY.put("-", 1);
		PRIORITY.put("*", 2);
		PRIORITY.put("/", 2);
		PRIORITY.put("^", 3);
		PRIORITY.put("(", 0);
		PRIORITY.put(")", 0);
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
				// higher priority operation, push into stack
				if (stack.isEmpty() 
						|| curr.equals("(")
						|| getPriority(curr) > getPriority(stack.peek())) {
					stack.push(curr);
				}
				// pop until the left parentheses
				else if (curr.equals(")")) {
					while (!stack.peek().equals("(")) {
						suffix[suffixIndex++] = stack.pop();
					}
					stack.pop();
				}
				// same or lower priority operation, so pop from stack
				else {
					suffix[suffixIndex++] = stack.pop();
					stack.push(curr);
				}
			}
		}
		
		// pop some left oper which is the lowest priority
		while (!stack.isEmpty()) {
			suffix[suffixIndex++] = stack.pop();
		}
		
		// trim the empty tail
		String[] result = new String[suffixIndex];
		for (int i = 0; i < suffixIndex; i++)
			result[i] = suffix[i];
		return result;
	}
	
	private int getPriority(String str) {
		Integer i = PRIORITY.get(str);
		return i;
	}
}
