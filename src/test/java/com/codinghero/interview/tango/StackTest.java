package com.codinghero.interview.tango;

import org.junit.Test;

public class StackTest {
	
	@Test
	public void test1() {
		Stack<Integer> stack = new Stack<Integer>();
		Thread t1 = new Thread(new PushStackRunnable(stack, 1));
		Thread t2 = new Thread(new PushStackRunnable(stack, 2));
		Thread t3 = new Thread(new PushStackRunnable(stack, 3));
		Thread t4 = new Thread(new PushStackRunnable(stack, 4));
		Thread t5 = new Thread(new PushStackRunnable(stack, 5));

		Thread t6 = new Thread(new PopStackRunnable(stack));
		Thread t7 = new Thread(new PopStackRunnable(stack));
		Thread t8 = new Thread(new PopStackRunnable(stack));
		Thread t9 = new Thread(new PopStackRunnable(stack));
		Thread t10 = new Thread(new PopStackRunnable(stack));
		
		t3.start();
		t4.start();
		t1.start();
		t5.start();
		t2.start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}
	
	class PushStackRunnable implements Runnable {

		private Stack<Integer> stack = new Stack<Integer>();
		
		private int num;
		
		PushStackRunnable(Stack<Integer> stack, int num) {
			this.stack = stack;
			this.num = num;
		}
		
		@Override
		public void run() {
			stack.push(num);
		}
		
	}
	
	class PopStackRunnable implements Runnable {

		private Stack<Integer> stack = new Stack<Integer>();
		
		PopStackRunnable(Stack<Integer> stack) {
			this.stack = stack;
		}
		
		@Override
		public void run() {
			System.out.println(stack.pop());
		}
		
	}
}
