package com.codinghero.interview.tango;

import java.util.concurrent.Semaphore;

public class WorkRunnable implements Runnable {

	private String name;

	private Semaphore s1;
	private Semaphore s2;

	public WorkRunnable(String name, Semaphore s1, Semaphore s2) {
		this.name = name;
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		synchronized (s1) {
			try {
				if (s1.availablePermits() == 0) {
					s1.wait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				work();
				System.out.println(name + ",work1");
				synchronized (s2) {
					s2.release();
					s2.notify();
				}
			}
		}
		work();
		System.out.println(name + ",work2");
	}

	private void work() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
