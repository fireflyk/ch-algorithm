package com.codinghero.acm.poj;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
4
0 4 9 21
4 0 8 17
9 8 0 16
21 17 16 0

 * @author Tong Liu
 *
 */
public class Poj1258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			long[][] graph = getInput(cin);
			System.out.println(prim(graph));
		}
	}
	
	public static long[][] getInput(Scanner cin) throws NumberFormatException, IOException {
		final int n = cin.nextInt();
		long[][] graph = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = cin.nextLong();
			}
		}
		return graph;
	}
	
	public static long prim(long[][] graph) {
		HashSet<Integer> unSelectedSet = new HashSet<Integer>();
		for (int i = 1; i < graph.length; i++) {
			unSelectedSet.add(i);
		}
		return prim(graph, unSelectedSet, new Long[graph.length], 0);
	}

	private static long prim(long[][] graph, HashSet<Integer> unSelectedSet, Long[] minCost, int prevSelect) {
		if (unSelectedSet.isEmpty())
			return 0;
		Integer curSelect = null;
		for (Integer unSelect : unSelectedSet) {
			// visit all edge of the new selected vertex
			if (minCost[unSelect] == null
					|| graph[prevSelect][unSelect] < minCost[unSelect]) {
				minCost[unSelect] = graph[prevSelect][unSelect];
			}
			// find minimum edge on this round
			if (curSelect == null || minCost[curSelect] > minCost[unSelect]) {
				curSelect = unSelect;
			}
		}
		unSelectedSet.remove(curSelect);
		return minCost[curSelect] + prim(graph, unSelectedSet, minCost, curSelect);
	}
}
