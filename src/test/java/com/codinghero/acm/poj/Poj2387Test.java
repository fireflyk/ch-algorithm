package com.codinghero.acm.poj;

import junit.framework.Assert;

import org.junit.Test;

public class Poj2387Test {
	@Test
	public void test1() {
		Long[] distances = Poj2387.dijkstra(new Long[][] {
				{ null, null, null }, { null, 0L, 1L }, { null, 1L, 0L } });
		Assert.assertEquals(new Long(1), distances[1]);
	}

	@Test
	public void test2() {
		Long[] distances = Poj2387.dijkstra(new Long[][] { { null, null },
				{ null, 0L } });
		Assert.assertEquals(new Long(0), distances[1]);
	}
}
