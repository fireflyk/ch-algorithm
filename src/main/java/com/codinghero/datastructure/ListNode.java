package com.codinghero.datastructure;


public class ListNode<T> {
	private ListNode<T> next;
	private T value;

	public ListNode(T t) {
		this.value = t;
	}

	public T getValue() {
		return value;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}
}
