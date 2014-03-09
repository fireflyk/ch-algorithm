package com.codinghero.interview.tango;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class Output1And2Test {

	@Test
	public void test1() throws InterruptedException {
		for (int i = 1; i < 1001; i++) {
			int num = i % 2 + 1;
			Thread thread = new Thread(new Output1And2Thread(num));
			thread.start();
		}
		Thread.sleep(1000);
		List<Integer> list = Output1And2Thread.instance.getList();
		Assert.assertEquals(1000, list.size());
		for (int i = 0; i < list.size(); i++) {
			Assert.assertEquals(i % 2 + 1, list.get(i).intValue());
		}
	}

	private static class Output1And2Thread implements Runnable {

		private static Output1And2 instance = new Output1And2();

		private int num;
		
		public Output1And2Thread(int num) {
			this.num = num;
		}
		
		@Override
		public void run() {
			try {
				if (num == 1)
					instance.output1();
				else
					instance.output2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
