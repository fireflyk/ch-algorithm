package com.codinghero.interview.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PopularWord {
	
	Map<String, Integer> indexMap;
	
	List<Node<Long>> heap = new ArrayList<Node<Long>>();
	
	private class Node<T> {
		String word;
		T count;

		private Node(String word, T count) {
			this.word = word;
			this.count = count;
		}
	}
	
	public String get() {
		if (heap.size() == 0)
			return null;
		else
			return heap.get(0).word;
	}
	
	public void put(String word) {
		plus1(word);
		adjustNode(indexMap.get(word));
	}
	
	private long getCount(String word) {
		if (!indexMap.containsKey(word)) {
			return 0;
		}
		return heap.get(indexMap.get(word)).count;
	}
	
	private void plus1(String word) {
		if (!indexMap.containsKey(word)) {
			heap.add(new Node<Long>(word, 1l));
			indexMap.put(word, heap.size() - 1);
		}
		setCount(word, getCount(word) + 1);
	}
	
	private void setCount(String word, long count) {
		heap.get(indexMap.get(word)).count = count;
	}
	
	private void adjustNode(int index) {
		
	}
}
