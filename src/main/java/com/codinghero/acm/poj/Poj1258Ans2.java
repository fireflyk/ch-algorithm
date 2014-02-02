package com.codinghero.acm.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * use StreamTokenizer for get input<br/>
 * Prim: O(n^2), Kruskal: O(eloge)
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
			long[][] graph = getPrimInput(cin);
			LinkedList<Edge> edges = getKuskalInput(graph);
			if (graph.length * graph.length < edges.size() * Math.log(edges.size())) {
				System.out.println(prim(graph));
			} else {
				System.out.println(kruskal(edges, graph.length));
			}
		}
	}
	
	/**
	 * use matrix to implement prim
	 * 
	 * @param cin
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static long[][] getPrimInput(StreamTokenizer cin) throws NumberFormatException, IOException {
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
	
	/**
	 * use edge list to implement kruskal
	 * 
	 * @param graph
	 * @return
	 */
	public static LinkedList<Edge> getKuskalInput(long[][] graph) {
		LinkedList<Edge> edges = new LinkedList<Edge>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = i + 1; j < graph.length; j++) {
				if (graph[i][j] > 0)
					edges.add(new Edge(i, j, graph[i][j]));
			}
		}
		return edges;
	}
	
	public static long kruskal(LinkedList<Edge> edges, final int n) {
		// connected component
		Integer[] group = new Integer[n];
		long sum = 0;
		int groupNum = 0;
		Collections.sort(edges);
		for (int i = 0; i < n - 1; i++) {
			Edge edge = edges.removeFirst();
			// two existed connected component
			if (group[edge.v1] != null && group[edge.v2] != null) {
				// ignore. in the same connected component 
				if (group[edge.v1] == group[edge.v2]) {
					i--;
					continue;
				}
			}
			// not in the same connected component
			else if (group[edge.v1] != null && group[edge.v2] == null) {
				group[edge.v2] = group[edge.v1];
				sum += edge.distance;
			}
			// not in the same connected component
			else if (group[edge.v1] == null && group[edge.v2] != null) {
				group[edge.v1] = group[edge.v2];
				sum += edge.distance;
			}
			// created a new connected component
			else {
				group[edge.v1] = groupNum;
				group[edge.v2] = groupNum;
				groupNum++;
				sum += edge.distance;
			}
		}
		return sum;
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
	
	private static class Edge implements Comparable<Edge> {
		private int v1;
		private int v2;
		private long distance;
		
		public Edge(int v1, int v2, long distance) {
			this.v1 = v1;
			this.v2 = v2;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge edge) {
			if (this.distance > edge.distance) {
				return 1;
			} else if (this.distance < edge.distance) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
