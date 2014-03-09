package com.codinghero.interview.tango;

public class NotifyExample {

	private Object semaphore = new Object();

	public void put() {
		synchronized (semaphore) {
			semaphore.notify();
		}
	}
}
