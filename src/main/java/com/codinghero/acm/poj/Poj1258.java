package com.codinghero.acm.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

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

	// public static final int UNCONNECTED_VERTEX = -1;

	// private int[][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		long[][] graph = getInput();
		System.out.println(prim(graph));
	}
	
	public static long[][] getInput() throws NumberFormatException, IOException {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(cin.readLine());
		long[][] graph = new long[n][n];
		for (int i = 0; i < n; i++) {
			String[] nums = cin.readLine().split(" ");
			for (int j = 0; j < nums.length; j++) {
				graph[i][j] = Long.parseLong(nums[j]);
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

	// LinkedList<Integer> selected
	private static long prim(long[][] graph, HashSet<Integer> unSelectedSet, Long[] minCost, int prevSelect) {
		if (unSelectedSet.isEmpty())
			return 0;
		Integer curSelect = null;
		for (Integer unSelect : unSelectedSet) {
			if (minCost[unSelect] == null
					|| graph[prevSelect][unSelect] < minCost[unSelect]) {
				minCost[unSelect] = graph[prevSelect][unSelect];
			}

			if (curSelect == null || minCost[curSelect] > minCost[unSelect]) {
				curSelect = unSelect;
			}
		}
		unSelectedSet.remove(curSelect);
		return minCost[curSelect] + prim(graph, unSelectedSet, minCost, curSelect);
	}
}
