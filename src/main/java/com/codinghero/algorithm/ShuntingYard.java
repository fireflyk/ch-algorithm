package com.codinghero.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ShuntingYard {

	private static List<String> OPERS = new ArrayList<String>();
	private static Map<String, Integer> PRIORITY = new HashMap<String, Integer>();
	
	static {
		OPERS.add("+");
		OPERS.add("-");
		OPERS.add("*");
		OPERS.add("/");
		OPERS.add("^");
		OPERS.add("(");
		OPERS.add(")");
		
		PRIORITY.put("+", 1);
		PRIORITY.put("-", 1);
		PRIORITY.put("*", 2);
		PRIORITY.put("/", 2);
		PRIORITY.put("^", 3);
		PRIORITY.put("(", 0);
		PRIORITY.put(")", 0);
	}
	
	public static boolean isOper(String str) {
		return OPERS.contains(str);
	}
	
	public String[] transform(String[] nifix) {
		
		String[] suffix = new String[nifix.length];
		
		Stack<String> s = new Stack<String>();
		int si = 0;
		for (int i = 0; i < nifix.length; i++) {
			String curr = nifix[i];
			// number, then output
			if (!isOper(curr)) {
				suffix[si++] = curr;
			} 
			// oper
			else {
				// push into stack, wait for the higher priority oper
				if (s.isEmpty() 
						|| curr.equals("(")
						|| getPriority(curr) > getPriority(s.peek())) {
					s.push(curr);
				}
				// pop until the left parentheses
				else if (curr.equals(")")) {
					while (!s.peek().equals("(")) {
						suffix[si++] = s.pop();
					}
					s.pop();
				}
				// lower priority oper, so pop from stack
				else {
					suffix[si++] = s.pop();
					s.push(curr);
				}
			}
		}
		
		// pop some left oper which is the lowest priority
		while (!s.isEmpty()) {
			suffix[si++] = s.pop();
		}
		
		// trim the empty tail
		String[] result = new String[si];
		for (int i = 0; i < si; i++)
			result[i] = suffix[i];
		return result;
	}
	
	private int getPriority(String str) {
		Integer i = PRIORITY.get(str);
		return i;
	}
}
