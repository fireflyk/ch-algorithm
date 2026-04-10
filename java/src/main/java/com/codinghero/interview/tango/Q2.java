package com.codinghero.interview.tango;

import java.util.List;

public class Q2 {
	public List<Integer> findTopK(List<Integer> list, int k) {
		if (list == null)
			throw new NullPointerException();

		MinHeap heap = new MinHeap(k);
		for (Integer num : list) {
			if (!heap.isFull()) {
				heap.add(num);
			} else if (num > heap.peek()) {
				heap.replacePeek(num);
			}
		}
		return heap.list();
	}
}
