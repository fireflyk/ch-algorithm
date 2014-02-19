package com.codinghero.interview.linkedin;

import java.util.concurrent.BlockingQueue;

import junit.framework.Assert;

import org.junit.Test;

public class LinkedBlockingQueueTest {

	private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);
	
	@Test
	public void test1() throws InterruptedException {
		Thread takeThread = new Thread(new BlockingTakeThread());
		takeThread.start();
		Thread.sleep(1000);
		Thread putThread = new Thread(new BlockingPutThread());
		putThread.start();
		
		putThread.join();
		takeThread.join();
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
