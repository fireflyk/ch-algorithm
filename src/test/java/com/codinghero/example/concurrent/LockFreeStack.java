package com.codinghero.example.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack<T> {

	private AtomicReference<Node<T>> peek;

	public void push(T t) {
		Node<T> node = new Node<T>(t);
		do {
			node.setNext(peek.get());
		} while (!peek.compareAndSet(node.getNext(), node));
	}

	public T pop() {
		Node<T> result;
		do {
			result = peek.get();
			if (result == null)
				return null;
		} while (!peek.compareAndSet(result, result.getNext()));
		result.setNext(null);
		return result.getValue();
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private Node<T> next;
		private T value;

		public Node(T t) {
			this.value = t;
		}

		public T getValue() {
			return value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}
