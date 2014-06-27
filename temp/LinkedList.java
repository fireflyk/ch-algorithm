package com.codinghero.datastructure;

import java.util.concurrent.atomic.AtomicReference;

public class LinkedList<T> {
	private AtomicReference<ListNode<T>> head = new AtomicReference<ListNode<T>>();
	
	public T getHead() {
		ListNode<T> result = head.get();
		if (result != null)
			return result.getValue();
		else
			return null;
	}
	
	public ListNode<T> searchPrevNode(T t) {
		return null;
	}
	
	public void remove(T t) {
		
	}
}
