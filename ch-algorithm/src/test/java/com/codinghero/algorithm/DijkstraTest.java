package com.codinghero.algorithm;

import org.junit.Test;

import com.codinghero.util.ArrayUtils;
import com.codinghero.util.StringUtils;

public class DijkstraTest {

	@Test
	public void test() {
		int[][] graph = { { 0, 7, 9, Dijkstra.MAX, Dijkstra.MAX, 14 },
				{ Dijkstra.MAX, 0, 10, 15, Dijkstra.MAX, 14 }, { Dijkstra.MAX, Dijkstra.MAX, 0, 11, Dijkstra.MAX, 2 },
				{ Dijkstra.MAX, Dijkstra.MAX, Dijkstra.MAX, 0, 6, Dijkstra.MAX }, { Dijkstra.MAX, Dijkstra.MAX, Dijkstra.MAX, Dijkstra.MAX, 0, 9 },
				{ Dijkstra.MAX, Dijkstra.MAX, Dijkstra.MAX, Dijkstra.MAX, Dijkstra.MAX, 0 } };

		int[] distance = new Dijkstra().cal(graph, 0);
		System.out.println(StringUtils.join(ArrayUtils.toList(distance), ","));
	}
}
