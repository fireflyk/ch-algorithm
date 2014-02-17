package com.codinghero.interview.linkedin;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingQueue<T> implements BlockingQueue<T> {
	
	private Node<T> head;
	
	private Node<T> tail;
	
	private final AtomicInteger size = new AtomicInteger(0);
	
	private ReentrantLock takeLock = new ReentrantLock();
	
//	private final Condition notEmpty = takeLock.newCondition();
	
	private final Object notEmpty = new Object();
	
	private ReentrantLock putLock = new ReentrantLock();
	
//	private final Condition notFull = putLock.newCondition();
	
	private final Object notFull = new Object();
	
	private int capacity;
	
	public LinkedBlockingQueue(int capacity) {
		head = tail = new Node<T>(null);
		this.capacity = capacity;
	}
	
	static class Node<T> {
		T value;
		Node<T> next;

		Node(T t) {
			value = t;
		}
	}
	
	/**
	 * Adds a node from head of queue.
	 * 
	 * @return the node
	 */	
	private void enqueue(T t) {
		tail.next = new Node<T>(t);
		tail = tail.next;
	}

	/**
	 * Removes a node from head of queue.
	 * 
	 * @return the node
	 */
    private T dequeue() {
    	Node<T> result = head.next;
    	head.next = result.next;
    	result.next = null;	// help GC
    	return result.value;
    }

	@Override
	public T remove() {
		// TODO Auto-generated method stub
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean add(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void put(T t) throws InterruptedException {
		try {
			putLock.lockInterruptibly();
			while (size.get() == capacity) {
//				notFull.await();
				notFull.wait();
			}
			enqueue(t);
			size.incrementAndGet();
		} finally {
			putLock.unlock();
			signalNotEmpty();
		}
	}
	
	private void signalNotEmpty() {
//		try {
//			takeLock.lockInterruptibly();
//		} catch (InterruptedException e) {
//			notEmpty.signal();
//			takeLock.unlock();
//		}
		notEmpty.notify();
	}
	
	private void signalNotFull() {
//		try {
//			putLock.lockInterruptibly();
//		} catch (InterruptedException e) {
//			notFull.signal();
//			putLock.unlock();
//		}
		notFull.notify();
	}

	@Override
	public boolean offer(T t, long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T take() throws InterruptedException {
		try {
			takeLock.lockInterruptibly();
			while (size.get() == 0) {
//				notEmpty.await();
				notEmpty.wait();
			}
			T t = dequeue();
			size.incrementAndGet();
			return t;
		} finally {
			takeLock.unlock();
			signalNotFull();
		}
	}

	@Override
	public T poll(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super T> c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super T> c, int maxElements) {
		// TODO Auto-generated method stub
		return 0;
	}

}
