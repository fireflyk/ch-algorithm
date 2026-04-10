package com.codinghero.example.concurrent;

import org.junit.Test;

public class LinkedListTest {
	@Test
	public void testGetAdd() throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (long i = 0; i < 10000000000l; i++)
					;
				System.out.println("get");
			}
		}).start();
	}
}
