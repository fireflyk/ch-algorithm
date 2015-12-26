package com.codinghero.acm.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

	private Queue<Integer> minHeap = new PriorityQueue<Integer>();

	private Queue<Integer> maxHeap = new PriorityQueue<Integer>(1000, Collections.reverseOrder());

	public void addNum(int num) {
		double d = findMedian();
		if (num < d) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}

		if (maxHeap.size() > minHeap.size()) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() - maxHeap.size() >= 2) {
			maxHeap.offer(minHeap.poll());
		}
	}

	public double findMedian() {
		if (minHeap.size() + maxHeap.size() == 0) {
			return 0;
		}
		return (minHeap.size() + maxHeap.size()) % 2 == 0 ? ((double) (minHeap.peek() + maxHeap.peek())) / 2 : minHeap.peek();
	}
}
