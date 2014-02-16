package com.codinghero.interview.google;

import java.util.Iterator;
import java.util.LinkedList;

public class TwoLinkedListIterator<T> implements Iterator<T> {

	private static final class STATE {
		private static final int NEXT_LIST1 = 0;
		private static final int NEXT_LIST2 = 1;
		private static final int NEXT_NONE = 2;
	}
	
	// private LinkedList<T> list1 = new LinkedList<T>();
	
	// private LinkedList<T> list2 = new LinkedList<T>();
	
	private Iterator<T> iter1;
	
	private Iterator<T> iter2;
	
	private Iterator<T> curIter;
	
	// 1 list1, 2 list2, 3 end
	// private int state;

	public TwoLinkedListIterator(LinkedList<T> list1, LinkedList<T> list2) {
		if (list1 == null || list2 == null)
			throw new NullPointerException();
		// this.list1 = list1;
		// this.list2 = list2;
		this.iter1 = list1.iterator();
		this.iter2 = list2.iterator();
	}
	
	@Override
	public boolean hasNext() {
		return curIter.hasNext();
	}

	@Override
	public T next() {
		T t = curIter.next();
		switchIterator();
		return t;
	}

	@Override
	public void remove() {
		curIter.remove();
	}
	
	private void switchIterator() {
		if (curIter == iter1) {
			switchIterator(iter2, iter1);
		} else if (curIter == iter2) {
			switchIterator(iter1, iter2);
		} else {
			throw new IllegalStateException();
		}
	}
	
	private void switchIterator(Iterator<T> iter1, Iterator<T> iter2) {
		if (iter1.hasNext()) {
			curIter = iter1;
		} else if (iter2.hasNext()) {
			curIter = iter2;
		}
	}
	
	/*
	private void switchTo1() {
		if (iter1.hasNext()) {
			curIter = iter1;
		} else if (iter2.hasNext()) {
			curIter = iter2;
		}
	}
	
	private void switchTo2() {
		if (iter2.hasNext()) {
			curIter = iter2;
		} else if (iter1.hasNext()) {
			curIter = iter1;
		}
	}
	*/
}
