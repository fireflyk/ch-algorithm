package com.codinghero.datastructure;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeLinkedList<T> {
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
		// find location and set remove flag
		while (true) {
			ListNode<T> prev = searchPrevNode(t);
			if (prev == null || prev.getNext() == null)
				return;
			ListNode<T> cur = prev.getNext();
			if (cur.equals(t)) {
				if (cur.getRemoveFlag().compareAndSet(false, true)) {
					ListNode<T> next = cur.getNext(); 
				} else {
					continue;
				}
			}
		}
	}
}
