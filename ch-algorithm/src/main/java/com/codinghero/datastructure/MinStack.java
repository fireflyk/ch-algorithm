package com.codinghero.datastructure;

import java.util.Stack;

public class MinStack<T extends Comparable<T>> {
	
	private Stack<T> data = new Stack<T>();
	private Stack<T> min = new Stack<T>();
	
	public T push(T t) {
		if (t.compareTo(min.peek()) < 0)
			min.push(t);
		return data.push(t);
	}

	public T pop() {
		if (data.peek() == min.peek())
			min.pop();
		return data.pop();
	}
	
	public T min() {
		return min.peek();
	}
}
