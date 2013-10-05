package com.codinghero.algorithm;

import java.util.Stack;

public class ReversePolish {

	public int cal(String[] suffix) {
		Stack<Integer> s = new Stack<Integer>();
		for (String str : suffix) {
			// push number to stack, wait for being calculated
			if (!ShuntingYard.isOper(str)) {
				s.push(Integer.parseInt(str));
			}
			// meet the oper to calculate, push result to stack
			else {
				int num2 = s.pop();
				int num1 = s.pop();
				s.push(cal(str, num1, num2));
			}
		}
		return s.pop();
	}
	
	private int cal(String oper, int num1, int num2) {
		if (oper.equals("+"))
			return num1 + num2;
		else if (oper.equals("-"))
			return num1 - num2;
		else if (oper.equals("*"))
			return num1 * num2;
		else if (oper.equals("/"))
			return num1 / num2;
		else if (oper.equals("^"))
			return (int) Math.pow(num1, num2);
		else
			throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		String[] nifix = new String[] {
			"3", "+", "(", "4", "*", "2", "/", 
			"(", "1", "-", "5", ")", ")", 
			"^", "2", "^", "3"	
		};
		String[] suffix = new ShuntingYard().transform(nifix);
		System.out.println(new ReversePolish().cal(suffix));
	}

}
