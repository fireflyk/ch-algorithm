package com.codinghero.acm.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

/**
 * Dijkstra
 * 
 * @author liutong01
 *
 */
public class Poj2387 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		Long[][] graph = getInput(cin);
		Long[] distances = dijkstra(graph);
		System.out.println(distances[1]);
	}
	
	public static Long[] dijkstra(Long[][] graph) {
		Long distances[] = new Long[graph.length];
		distances[graph.length - 1] = 0L;
		Set<Integer> unSelects = new HashSet<Integer>();
		for (int i = 1; i < graph.length - 1; i++)
			unSelects.add(i);
		
		dijkstra(graph, distances, unSelects, graph.length - 1, 1);
		return distances;
	}
	
	private static void dijkstra(Long[][] graph, Long[] distances, Set<Integer> unSelects, final int prevSelect, final int target) {
		if (unSelects.isEmpty() || prevSelect == target)
			return;
		// visit all edge of the new selected vertex
		for (int j = 1; j < graph.length - 1; j++) {
			if (graph[prevSelect][j] != null
					&& unSelects.contains(j)
					&& (distances[j] == null || distances[j] > distances[prevSelect] + graph[prevSelect][j]))
				distances[j] = distances[prevSelect] + graph[prevSelect][j];
		}

		// find the current nearest vertex
		Integer minIndex = null;
		for (Integer unSelect : unSelects) {
			if (distances[unSelect] != null
					&& (minIndex == null || distances[minIndex] > distances[unSelect])) {
				minIndex = unSelect;
			}
		}
		unSelects.remove(minIndex);
		dijkstra(graph, distances, unSelects, minIndex, target);
	}
	
	private static Long[][] getInput(StreamTokenizer cin) throws IOException {
		cin.nextToken();
		final int T = (int) cin.nval;
		cin.nextToken();
		final int N = (int) cin.nval;
		Long[][] graph = new Long[N + 1][N + 1];
		
		for (int k = 0; k < T; k++) {
			cin.nextToken();
			final int i = (int) cin.nval;
			cin.nextToken();
			final int j = (int) cin.nval;
			cin.nextToken();
			if (graph[i][j] == null||graph[i][j] > cin.nval) {
				graph[i][j] = (long) cin.nval;
				graph[j][i] = graph[i][j];
			}
		}
		
		return graph;
	}
}
