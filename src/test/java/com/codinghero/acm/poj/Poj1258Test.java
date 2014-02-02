package com.codinghero.acm.poj;

import org.junit.Assert;
import org.junit.Test;

public class Poj1258Test {
	@Test
	public void test1() {
		long[][] graph = { { 0, 4, 9, 21 }, { 4, 0, 8, 17 }, { 9, 8, 0, 16 },
				{ 21, 17, 16, 0 } };
		Assert.assertEquals(28, Poj1258.prim(graph));
	}
	
	@Test
	public void test2() {
		long[][] graph = { { 0 } };
		Assert.assertEquals(0, Poj1258.prim(graph));
	}
	
	@Test
	public void test3() {
		long[][] graph = { { 0, 1 }, { 1, 0 } };
		Assert.assertEquals(1, Poj1258.prim(graph));
	}
}
