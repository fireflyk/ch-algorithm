package com.codinghero.datastructure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K, V> {

	private LinkedHashMap<K, V> datas;

	private int capacity;

	public LRUCache(int capacity) {
		datas = new LinkedHashMap<K, V>();
		this.capacity = capacity;
	}

	public V get(K key) {
		if (datas.containsKey(key)) {
			V value = datas.remove(key);
			datas.put(key, value);
			return value;
		} else {
			return null;
		}
	}

	public void set(K key, V value) {
		if (datas.containsKey(key)) {
			datas.remove(key);
			datas.put(key, value);
		} else {
			if (datas.size() == capacity) {
				Iterator<Entry<K, V>> iter = datas.entrySet().iterator();
				iter.next();
				iter.remove();
			}
			datas.put(key, value);
		}
	}
}
