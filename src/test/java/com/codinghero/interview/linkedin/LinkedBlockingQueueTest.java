package com.codinghero.interview.linkedin;

import java.util.concurrent.BlockingQueue;

import junit.framework.Assert;

import org.junit.Test;

public class LinkedBlockingQueueTest {

	private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);
	
	@Test
	public void test1() throws InterruptedException {
		Thread takeThread1 = new Thread(new BlockingTakeThread());
		takeThread1.start();
		Thread takeThread2 = new Thread(new BlockingTakeThread());
		takeThread2.start();
		Thread.sleep(1000);
		Thread putThread1 = new Thread(new BlockingPutThread());
		putThread1.start();
		Thread.sleep(1000);
		Thread putThread2 = new Thread(new BlockingPutThread());
		putThread2.start();
		
		putThread1.join();
		putThread2.join();
		takeThread1.join();
		takeThread2.join();
	}
	
	class BlockingTakeThread implements Runnable {

		@Override
		public void run() {
			try {
				Integer num = queue.take();
				System.out.println("take");
				Assert.assertEquals(new Integer(1), num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	class BlockingPutThread implements Runnable {

		@Override
		public void run() {
			try {
				queue.put(1);
				System.out.println("put");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
