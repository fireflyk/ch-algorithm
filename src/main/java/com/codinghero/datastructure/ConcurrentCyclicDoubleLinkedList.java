package com.codinghero.datastructure;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class ConcurrentCyclicDoubleLinkedList<T> extends
		AbstractSequentialList<T> implements List<T>, Cloneable,
		java.io.Serializable {

	private static final long serialVersionUID = -571986891998487849L;

	private transient DoubleLinkedListNode<T> header = new DoubleLinkedListNode<T>(null, null, null);

	@Override
	public CyclicDoubleLinkedListIterator<T> listIterator(int index) {
		return new CyclicDoubleLinkedListIterator();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@SuppressWarnings("hiding")
	private class CyclicDoubleLinkedListIterator<T> implements ListIterator<T> {
		
		DoubleLinkedListNode<T> node;
		
		CyclicDoubleLinkedListIterator() {

		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(T e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	@SuppressWarnings("hiding")
	private class DoubleLinkedListNode<T> {
		T value;
		DoubleLinkedListNode<T> previous;
		DoubleLinkedListNode<T> next;

		DoubleLinkedListNode(T value, DoubleLinkedListNode<T> previous,
				DoubleLinkedListNode<T> next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
		
		private void addNext(DoubleLinkedListNode<T> node) {
			synchronized (this) {
				
			}
		}
		
		private void addPrevious(DoubleLinkedListNode<T> node) {
			
		}
	}
}
