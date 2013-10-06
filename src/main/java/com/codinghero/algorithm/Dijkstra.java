package com.codinghero.algorithm;


public class Dijkstra {

	static final int MAX = Integer.MAX_VALUE;
	private static final int FINISHED = -1;
	
	class Node {
		int index;
		int distance;
	}
	
	public int[] cal(int[][] graph, int origIndex) {
		int[] distance = new int[graph.length];
		int[] calculating = new int[graph.length];
		for (int i = 0; i < calculating.length; i++) {
			calculating[i] = graph[origIndex][i];
		}
		extractMin(calculating, distance);
		
		for (int i = 0; i < calculating.length - 1; i++) {
			int minIndex = extractMin(calculating, distance);
			for (int j = 0; j < calculating.length; j++) {
				if (calculating[j] != FINISHED
						&& graph[minIndex][j] != MAX
						&& calculating[j] > distance[minIndex] + graph[minIndex][j]) {
					calculating[j] = distance[minIndex] + graph[minIndex][j];
				}
			}
		}
		
		return distance;
	}
	
	private int extractMin(int[] caculating, int[] distance) {
		int min = MAX;
		int minIndex = -1;
		for (int i = 0; i < caculating.length; i++) {
			int cur = caculating[i];
			if (cur != FINISHED && cur < min) {
				min = cur;
				minIndex = i;
			}
		}
		distance[minIndex] = caculating[minIndex];
		caculating[minIndex] = FINISHED;
		return minIndex;
	}

}
