package com.codinghero.interview.google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DeepLinkedListIterator<T> implements Iterator<T> {
	
	private Stack<Iterator<Object>> iteratorStack;
	
	public DeepLinkedListIterator(LinkedList<Object> list) {
		if (list == null)
			throw new NullPointerException();
		iteratorStack.push(list.iterator());
	}

	@Override
	public boolean hasNext() {
		// assemble the popped iterator
		Stack<Iterator<Object>> endIteratorStack = nextEnableIterator();
		// calculate the result
		if(iteratorStack.empty())
			return false;
		boolean result = iteratorStack.peek().hasNext();
		// recover the popped iterator
		while (!endIteratorStack.empty()) {
			iteratorStack.push(endIteratorStack.pop());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T next() {
		nextEnableIterator();
		if (iteratorStack.empty())
			throw new NoSuchElementException();
		else
			return (T) iteratorStack.peek().next();
	}

	@Override
	public void remove() {
		if (iteratorStack.empty())
			throw new IllegalStateException();
		else
			iteratorStack.peek().remove();
	}
	
	private Stack<Iterator<Object>> nextEnableIterator() {
		Stack<Iterator<Object>> endIteratorStack = new Stack<Iterator<Object>>();
		while (!iteratorStack.empty()) {
			Iterator<Object> iter = iteratorStack.peek();
			if (iter.hasNext())
				return endIteratorStack;
			else
				iteratorStack.pop();
		}
		return endIteratorStack;
	}
}
