package com.codinghero.interview.tango;

import org.junit.Test;

public class WaitExampleTest {

	@Test
	public void test() throws InterruptedException {
		Thread thread1 = new Thread(new WaitExampleThread());
		Thread thread2 = new Thread(new WaitExampleThread());
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
	
	private static class WaitExampleThread implements Runnable {

		private static WaitExample waitExample = new WaitExample();
		
		@Override
		public void run() {
			try {
				waitExample.test();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
