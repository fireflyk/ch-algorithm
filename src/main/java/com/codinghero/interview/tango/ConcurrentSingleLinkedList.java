package com.codinghero.interview.tango;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentSingleLinkedList<T> {
	
	private ListNode<T> head;
	
	private AtomicInteger size;
	
	private Object mutex;

	public ConcurrentSingleLinkedList() {
		head = new ListNode<T>(null);
		size = new AtomicInteger();
	}
	
	public ListNode<T> head() {
		return head;
	}

	public ListNode<T> removeHead() {
		return head.remove();
	}
	
	public int size() {
		return size.get();
	}
	
	public ListNode<T> createNode(T value) {
		return new ListNode<T>(value);
	}
	
	@SuppressWarnings("hiding")
	public class ListNode<T> {
		private T value;
		private ListNode<T> next;

		public ListNode(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public ListNode<T> getNext() {
			return next;
		}

		public void setNext(ListNode<T> next) {
			this.next = next;
		}
		
		public void add(ListNode<T> node) {
			synchronized (mutex) {
				ListNode<T> next2 = this.next;
				this.next = node;
				node.next = next2;
				size.incrementAndGet();
			}
		}
		
		public ListNode<T> remove() {
			synchronized (mutex) {
				ListNode<T> next = this.next;
				if (next != null) {
					this.next = next.next;
					size.decrementAndGet();
				}
				return next;
			}
		}
	}
}
