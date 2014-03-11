package com.codinghero.interview.tango;

import java.util.concurrent.Semaphore;

import org.junit.Test;

public class WorkRunnableTest {
	
	/**
	 * start sequence: t1->t2->t3
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test1() throws InterruptedException {
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(0);
		Semaphore s3 = new Semaphore(0);
		Semaphore s4 = new Semaphore(0);
		Thread t1 = new Thread(new WorkRunnable("t1", s1, s2));
		Thread t2 = new Thread(new WorkRunnable("t2", s2, s3));
		Thread t3 = new Thread(new WorkRunnable("t3", s3, s4));
		t3.start();
		t2.start();
		t1.start();
		
		Thread.sleep(2000);
	}
}
