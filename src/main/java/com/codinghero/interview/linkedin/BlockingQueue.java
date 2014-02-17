package com.codinghero.interview.linkedin;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockingQueue<T> implements Queue<T> {

	private Queue<T> data;
	
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	private int capacity;
	
	public BlockingQueue(int capacity) {
		data = new LinkedList<T>();
		this.capacity = capacity;
	}
	
	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return data.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}

	@Override
	public Object[] toArray() {
		return data.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return data.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(T e) {
		try {
			rwLock.writeLock().lock();
			while (size() == capacity) {
				rwLock.writeLock().unlock();
				rwLock.wait();
				rwLock.writeLock().lock();
			}
			data.add(e);
			return true;
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			return true;
		} finally {
			rwLock.writeLock().unlock();
		}
	}

	@Override
	public boolean offer(T e) {
		try {
			rwLock.writeLock().lock();
			if (size() == capacity) {
				throw new IllegalStateException();
			} else {
				data.offer(e);
				return true;
			}
		} finally {
			rwLock.writeLock().unlock();
		}
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
