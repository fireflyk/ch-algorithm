package com.codinghero.oj.poj;

import org.junit.Assert;
import org.junit.Test;

public class Poj1258Test {
	@Test
	public void test1() {
		@SuppressWarnings("unused")
		long[][] graph = { { 0, 4, 9, 21 }, { 4, 0, 8, 17 }, { 9, 8, 0, 16 },
				{ 21, 17, 16, 0 } };
		long[][] graph2 = { { 0, 4, 9, 21 }, { 0, 0, 8, 17 }, { 0, 0, 0, 16 },
				{ 0, 0, 0, 0 } };
		Assert.assertEquals(28, Poj1258Ans2.prim(graph2));
		Assert.assertEquals(28, Poj1258Ans2.kruskal(Poj1258Ans2.getKuskalInput(graph2), graph2.length));
	}
	
	@Test
	public void test2() {
		long[][] graph = { { 0 } };
		Assert.assertEquals(0, Poj1258Ans2.prim(graph));
		Assert.assertEquals(0, Poj1258Ans2.kruskal(Poj1258Ans2.getKuskalInput(graph), graph.length));
	}
	
	@Test
	public void test3() {
		@SuppressWarnings("unused")
		long[][] graph = { { 0, 1 }, { 1, 0 } };
		long[][] graph2 = { { 0, 1 }, { 0, 0 } };
		Assert.assertEquals(1, Poj1258Ans2.prim(graph2));
		Assert.assertEquals(1, Poj1258Ans2.kruskal(Poj1258Ans2.getKuskalInput(graph2), graph2.length));
	}
}
