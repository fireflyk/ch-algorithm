package com.codinghero.oj.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {

    public LRUCache2(int capacity) {
        map = new FixedLinkedHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        Integer value = map.get(key);
        return value != null ? value : -1;
    }

    public void set(int key, int value) {
        map.put(key, value);
    }

    private Map<Integer, Integer> map;

    private class FixedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        private static final long serialVersionUID = 1L;

        private int capacity;

        public FixedLinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return super.size() > capacity;
        }

    }
}
