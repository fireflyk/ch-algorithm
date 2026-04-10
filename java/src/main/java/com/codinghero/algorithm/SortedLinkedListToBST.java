package com.codinghero.algorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class SortedLinkedListToBST<T> {
	public void convert(LinkedList<T> list) {
		convert(list.iterator(), 0, list.size() - 1);
	}
	
	private Node<T> convert(Iterator<T> iter, int start, int end) {
		if (start > end)
			return null;
		
		int mid = (start + end) / 2;
		Node<T> curRoot = new Node<T>();
		curRoot.left = convert(iter, start, mid - 1);
		curRoot.value = iter.next();
		curRoot.right = convert(iter, mid + 1, end);
		
		return curRoot;
	}
	
	public class Node<T> {
		public T value;
		public Node<T> left;
		public Node<T> right;
	}
}
