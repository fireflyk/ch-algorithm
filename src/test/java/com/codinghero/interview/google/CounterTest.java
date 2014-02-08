package com.codinghero.interview.google;

import junit.framework.Assert;

import org.junit.Test;

public class CounterTest {
	@Test
	public void test1() throws InterruptedException {
		Counter counter = new Counter();
		incre(counter, 10);
		Thread.sleep(1000);
		incre(counter, 10);
		Assert.assertEquals(10, counter.getCountInLastSecond());
		
		Thread.sleep(1000);
		Assert.assertEquals(10, counter.getCountInLastSecond());
	}
	
	private void incre(Counter counter, int num) {
		for (int i = 0; i < num; i++) {
			new Thread(new CounterThread(counter)).start();
		}
	}
	
	private class CounterThread implements Runnable {

		private Counter counter;
		
		public CounterThread(Counter counter) {
			this.counter = counter;
		}
		
		@Override
		public void run() {
			counter.increment();
		}
		
	}
}
