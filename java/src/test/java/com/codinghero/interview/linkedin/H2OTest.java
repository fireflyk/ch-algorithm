package com.codinghero.interview.linkedin;

import org.junit.Test;

public class H2OTest {

	@Test
	public void test1() throws InterruptedException {
		H2O instance = new H2O();
		Thread h1 = new Thread(new HThread(instance));
		Thread h2 = new Thread(new HThread(instance));
		Thread o1 = new Thread(new OThread(instance));
		h1.start();
		Thread.sleep(1000);
		o1.start();
		Thread.sleep(1000);
		h2.start();
		Thread.sleep(1000);
	}

	class HThread implements Runnable {

		private H2O instance;

		HThread(H2O instance) {
			this.instance = instance;
		}

		@Override
		public void run() {
			instance.h();
		}

	}

	class OThread implements Runnable {

		private H2O instance;

		OThread(H2O instance) {
			this.instance = instance;
		}

		@Override
		public void run() {
			instance.o();
		}

	}
}
