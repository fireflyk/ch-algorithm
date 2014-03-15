package com.codinghero.interview.tango;

import java.util.LinkedList;

public class Stack<T> {
	
	private LinkedList<T> list = new LinkedList<T>(); 
	
	private Object lock = new Object();
	
	public void push(T t) {
		synchronized (lock) {
			list.addLast(t);
		}
	}

	public T pop() {
		T t = null;
		synchronized (lock) {
			t = list.removeLast();
		}
		return t;
	}
}
