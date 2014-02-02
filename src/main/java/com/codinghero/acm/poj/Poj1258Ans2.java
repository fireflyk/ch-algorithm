package com.codinghero.acm.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

/**
 * use StreamTokenizer for get input
 * 
4
0 4 9 21
4 0 8 17
9 8 0 16
21 17 16 0

 * @author Tong Liu
 *
 */
public class Poj1258Ans2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while (cin.nextToken() != StreamTokenizer.TT_EOF) {
			long[][] graph = getInput(cin);
			System.out.println(prim(graph));
		}
	}
	
	public static long[][] getInput(StreamTokenizer cin) throws NumberFormatException, IOException {
		final int n = (int) cin.nval;
		long[][] graph = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin.nextToken();
				graph[i][j] = (long) cin.nval;
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
