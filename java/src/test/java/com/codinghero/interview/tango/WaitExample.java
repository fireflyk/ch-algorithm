package com.codinghero.interview.tango;

public class WaitExample {
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void test() throws InterruptedException {
		synchronized (lock1) {
			System.out.println("get lock1");
			synchronized (lock2) {
				System.out.println("get lock2");
				lock1.wait();
			}
		}
	}
}
