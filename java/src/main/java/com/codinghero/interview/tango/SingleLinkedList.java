package com.codinghero.interview.tango;


public class SingleLinkedList<T> {

	private ListNode<T> head;

	private int size;

	public SingleLinkedList() {
		head = new ListNode<T>(null);
		size = 0;
	}

	public ListNode<T> head() {
		return head;
	}
	
	public void addHead(ListNode<T> node) {
		head.add(node);
	}

	public ListNode<T> removeHead() {
		return head.remove();
	}

	public ListNode<T> createNode(T value) {
		return new ListNode<T>(value);
	}

	public int size() {
		return size;
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
			ListNode<T> next2 = this.next;
			this.next = node;
			node.next = next2;
			size++;
		}

		public ListNode<T> remove() {
			ListNode<T> next = null;
			next = this.next;
			if (next != null) {
				this.next = next.next;
				size--;
			}
			return next;
		}
	}
}
