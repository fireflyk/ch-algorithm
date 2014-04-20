package com.codinghero.datastructure;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack<T> {

	private AtomicReference<ListNode<T>> peek;

	public void push(T t) {
		ListNode<T> listNode = new ListNode<T>(t);
		do {
			listNode.setNext(peek.get());
		} while (!peek.compareAndSet(listNode.getNext(), listNode));
	}

	public T pop() {
		ListNode<T> result;
		do {
			result = peek.get();
			if (result == null)
				return null;
		} while (!peek.compareAndSet(result, result.getNext()));
		result.setNext(null);
		return result.getValue();
	}
}
