package com.codinghero.datastructure;

import java.util.concurrent.atomic.AtomicBoolean;


public class ListNode<T> {
	private ListNode<T> next;
	private T value;
	private AtomicBoolean removeFlag;

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

	public AtomicBoolean getRemoveFlag() {
		return removeFlag;
	}

	public void setRemoveFlag(AtomicBoolean removeFlag) {
		this.removeFlag = removeFlag;
	}
}
