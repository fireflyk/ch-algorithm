package com.codinghero.example.concurrent;

public class InterruptExample {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread start");
				for (long i = 0; i < 1000000000000l; i++) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println(Thread.currentThread().isInterrupted());
						System.out.println("i=" + i);
						break;
					}
				}
				System.out.println("thread end");
			}
		});
		t1.start();
		Thread.sleep(1000);
		t1.interrupt();
	}

}
