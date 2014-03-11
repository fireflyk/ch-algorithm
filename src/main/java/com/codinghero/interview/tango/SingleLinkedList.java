package com.codinghero.interview.tango;

import java.util.concurrent.atomic.AtomicInteger;

public class SingleLinkedList<T> {
	
	private ListNode<T> head;
	
	private ListNode<T> tail;
	
	private AtomicInteger size;

	public SingleLinkedList() {
		tail = head = new ListNode<T>(null);
		size = new AtomicInteger();
	}
	
	public ListNode<T> head() {
		return head;
	}
	
	public ListNode<T> tail() {
		return tail;
	}

	public ListNode<T> removeHead() {
		return head.remove();
	}

	public void addTail(ListNode<T> node) {
		tail.add(node);
	}
	
	public ListNode<T> createNode(T value) {
		return new ListNode<T>(value);
	}
	
	public int size() {
		return size.get();
	}
	
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
			synchronized (this) {
				ListNode<T> next2 = this.next;
				this.next = node;
				node.next = next2;
				size.incrementAndGet();
			}
		}
		
		public ListNode<T> remove() {
			ListNode<T> next = null;
			synchronized (this) {
				next = this.next;
				if (next != null) {
					this.next = next.next;
					size.decrementAndGet();
				}
			}
			return next;
		}
	}
}
