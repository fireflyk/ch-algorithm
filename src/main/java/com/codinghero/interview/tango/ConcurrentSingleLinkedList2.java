package com.codinghero.interview.tango;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentSingleLinkedList2<T> {
	
	private ListNode<T> head;
	
	private AtomicInteger size;
	
	public ConcurrentSingleLinkedList2() {
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
			synchronized (this) {
				ListNode<T> next2 = this.next;
				this.next = node;
				node.next = next2;
				size.incrementAndGet();
			}
		}
		
		public ListNode<T> remove() throws ConcurrentModificationException {
			synchronized (this) {
				ListNode<T> next = this.next;
				while (next != null) {
					synchronized (next) {
						// the current node was removed by another thread
						if (this.next == null) {
							new ConcurrentModificationException("The current node was removed by another thread.");
						}
						// the next node was removed by another thread
						else if (next != this.next) {
							next = this.next;
							continue;
						}
						// no concurrent problem occurs
						else {
							this.next = next.next;
							next.next = null;
							size.decrementAndGet();
							return next;
						}
					}
				}
				return null;
			}
		}
	}
}
