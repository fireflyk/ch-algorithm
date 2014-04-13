package com.codinghero.example.concurrent;

import org.junit.Test;

public class LinkedListTest {
	@Test
	public void testGetAdd() throws InterruptedException {
		final LinkedList list = new LinkedList();
		new Thread(new Runnable() {
			@Override
			public void run() {
				list.get();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				list.add();
			}
		}).start();
		
		Thread.currentThread().join();
	}
}
