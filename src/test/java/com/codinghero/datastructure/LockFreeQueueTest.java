package com.codinghero.datastructure;

import org.junit.Test;

public class LockFreeQueueTest {
	
	@Test
	public void test() {
		LockFreeQueue<Integer> queue = new LockFreeQueue<Integer>();
		queue.pop();
		
		queue.push(1);
		queue.pop();
		queue.pop();
		
		queue.push(2);
		queue.push(3);
		queue.pop();
		queue.pop();
		queue.pop();
	}
}
