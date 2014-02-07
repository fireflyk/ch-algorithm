package com.codinghero.interview.google;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class IncrementalIDGeneratorTest {
	
	@Test
	public void test1() throws InterruptedException {
		for (int i = 0; i < 20000; i++) {
			new Thread(new IDGeneratorThread()).start();
		}
		Thread.sleep(1000);
		Assert.assertEquals(20000, IDGeneratorThread.idSet.size());
	}
	
	private static class IDGeneratorThread implements Runnable {

		private static Set<Long> idSet = Collections.synchronizedSet(new HashSet<Long>());
		
		private static IncrementalIDGenerator instance = IncrementalIDGenerator.getInstance();
		
		@Override
		public void run() {
			idSet.add(instance.get());
		}
		
	}
}
