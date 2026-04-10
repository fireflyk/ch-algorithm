package com.codinghero.interview.google;

public class CircularArray<T> {
	
	private Object[] elements;
	
	private int size;
	
	private int capacity;
	
	//private Integer headIndex = null;
	
	private Integer tailIndex = null;
	
	public CircularArray(int capacity) {
		this.capacity = capacity;
		elements = new Object[this.capacity];
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		rangeCheck(index);
		return (T) elements[index];
	}
	
	public int addLast(T t) {
		tailIndexIncre();
		elements[tailIndex] = t;
		return tailIndex;
	}
	
	public int getTailIndex() {
		return tailIndex;
	}
	
	public int subtractIndex(int index1, int index2) {
		return (index1 + capacity - index2) % capacity;
	}
	
	private void tailIndexIncre() {
		if (tailIndex == null || tailIndex == capacity - 1) {
			tailIndex = 0;
		} else {
			tailIndex++;
		}
	}
	
	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
}
