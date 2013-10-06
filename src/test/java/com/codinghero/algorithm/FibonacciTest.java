package com.codinghero.algorithm;

import static junit.framework.Assert.*;

import org.junit.Test;

import com.codinghero.algorithm.Fibonacci;

public class FibonacciTest {
	
	@Test
	public void testCal() {
		Fibonacci f = new Fibonacci();
		assertEquals(0, f.cal(0));
		assertEquals(1, f.cal(1));
		assertEquals(1, f.cal(2));
		assertEquals(2, f.cal(3));
		assertEquals(3, f.cal(4));
		assertEquals(5, f.cal(5));
	}
}
