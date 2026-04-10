package com.codinghero.datastructure;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeQueue<T> {
	
	private AtomicReference<ListNode<T>> head = new AtomicReference<ListNode<T>>();
	
	private AtomicReference<ListNode<T>> tail = new AtomicReference<ListNode<T>>();
	
	public void push(T t) {
		ListNode<T> listNode = new ListNode<T>(t);
		do {
			listNode.setNext(tail.get());
		} while (!tail.compareAndSet(listNode.getNext(), listNode));
	}

	public T pop() {
		ListNode<T> result;
		do {
			result = head.get();
			if (result == null)
				return null;
		} while (!head.compareAndSet(result, result.getNext()));
		result.setNext(null);
		return result.getValue();
	}
}
