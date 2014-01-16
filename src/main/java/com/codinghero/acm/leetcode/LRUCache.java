package com.codinghero.acm.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache {

	private LinkedHashMap<Integer, Integer> datas;
	
	private int capacity;
	
	public LRUCache(int capacity) {
		datas = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer value = datas.get(key);
		if (value != null) {
			datas.remove(key);
			datas.put(key, value);
			return value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (datas.get(key) != null) {
			datas.remove(key);
			datas.put(key, value);
		} else {
			if (datas.size() == capacity) {
				Iterator<Entry<Integer, Integer>> iter = datas.entrySet().iterator();
				iter.next();
				iter.remove();
			}
			datas.put(key, value);
		}
	}
}
