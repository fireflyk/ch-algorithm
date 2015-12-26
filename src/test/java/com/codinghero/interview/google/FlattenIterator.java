package com.codinghero.interview.google;

import java.util.Iterator;

public class FlattenIterator<T> implements Iterator<T> {
	
	private Iterator<Iterator<T>> listIter;
	
	private Iterator<T> iter;

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
