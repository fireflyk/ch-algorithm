package com.codinghero.interview.facebook;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FixedSizeMinHeap<E> {

    private int capacity;
    private Queue<E> queue;
    private Comparator<E> comparator;

    public FixedSizeMinHeap(int capactiy) {
        this(capactiy, null);
    }

    public FixedSizeMinHeap(int capacity, Comparator<E> comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
        this.queue = new PriorityQueue<E>();
    }

    @SuppressWarnings("unchecked")
    public void push(E e) {
        if (queue.size() == capacity) {
            if (comparator != null) {
                if (comparator.compare(e, queue.peek()) > 0) {
                    queue.poll();
                }
            } else if (e instanceof Comparable) {
                if (((Comparable<E>) e).compareTo(queue.peek()) > 0) {
                    queue.poll();
                }
            } else {
                throw new RuntimeException("Can't compare");
            }
        }
        queue.offer(e);
    }

    public E pop() {
        return queue.poll();
    }
}
