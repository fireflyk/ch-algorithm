package com.codinghero.interview.linkedin;

import java.util.concurrent.Semaphore;

public class H2O {
	
	private Semaphore hs = new Semaphore(2);
	private Semaphore os = new Semaphore(1);
	
	private Object h = new Object();
	private Object o = new Object();
	
	public void h() {
		System.out.println("h");
		try {
			hs.acquire();
			synchronized (h) {
				if (hs.availablePermits() > 0) {
					h.wait();
				}
				h.notifyAll();
			}
			synchronized (o) {
				if (os.availablePermits() > 0) {
					o.wait();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("exit h");
		}
	}

	public void o() {
		System.out.println("o");
		try {
			os.acquire();
			synchronized (h) {
				if (hs.availablePermits() > 0) {
					h.wait();
				}
			}
			synchronized (o) {
				o.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("exit o");
		}
	}
}
