package com.codinghero.interview.linkedin;

public class H2O {
	
	private LinkedBlockingQueue<Object> hQueue = new LinkedBlockingQueue<Object>(2);
	private LinkedBlockingQueue<Object> oQueue = new LinkedBlockingQueue<Object>(1);
	
	private Object removeLock = new Object();
	
	public void h() throws InterruptedException {
		hQueue.put(new Object());
		tryRemove();
	}

	public void o() throws InterruptedException {
		oQueue.put(new Object());
		tryRemove();
	}
	
	private void tryRemove() throws InterruptedException {
		synchronized (removeLock) {
			if (hQueue.size() == 2 && oQueue.size() == 1) {
				hQueue.remove();
				hQueue.remove();
				oQueue.remove();
				removeLock.notifyAll();
			} else {
				removeLock.wait();
			}
		}
	}
}
