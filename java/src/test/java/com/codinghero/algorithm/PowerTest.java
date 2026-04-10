package com.codinghero.algorithm;

import static junit.framework.Assert.*;

import org.junit.Test;

import com.codinghero.algorithm.Power;

public class PowerTest {
	
	@Test
	public void testCal() {
		Power p = new Power();
		assertEquals(1, p.cal(2, 0));
		assertEquals(2, p.cal(2, 1));
		assertEquals(81, p.cal(3, 4));
		assertEquals(2048, p.cal(2, 11));
	}
}
