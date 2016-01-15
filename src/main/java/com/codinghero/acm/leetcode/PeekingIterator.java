package com.codinghero.acm.leetcode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next == null) {
            next = iterator.next();
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (next == null) {
            return iterator.next();
        } else {
            Integer result = next;
            next = null;
            return result;
        }
    }

    @Override
    public boolean hasNext() {
        return next != null || iterator.hasNext();
    }

    @Override
    public void remove() {

    }
}
