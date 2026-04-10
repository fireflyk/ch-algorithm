package com.codinghero.datastructure;

import java.util.Stack;

public class StackQueue<E> {
	
	private Stack<E> pushStack = new Stack<E>();
	private Stack<E> popStack = new Stack<E>();
	
	public boolean offer(E o) {
		while(!popStack.isEmpty()) {
			pushStack.push(popStack.pop());
		}
		pushStack.push(o);
		return true;
	}
	
	public E poll() {
		while(!pushStack.isEmpty()) {
			popStack.push(pushStack.pop());
		}
		return popStack.pop();
	}
}
