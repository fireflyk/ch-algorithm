package com.codinghero.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AdjacencyList implements Graph {
	
	private ArrayList<LinkedList<Integer>> graph;
	
	/**
	 * vertex number
	 */
	private int vertexNum;
	
	/**
	 * It is used in visit(i).<br/>
	 * visited[i] show if the vertex i is visited.
	 */
	private boolean[] visited;
	
	/**
	 * 
	 * @param seg
	 * @param segNum
	 * @param vertexNum
	 */
	public AdjacencyList(int[][] seg, int segNum, int vertexNum) {
		
		this.vertexNum = vertexNum;
		this.graph = new ArrayList<LinkedList<Integer>>(vertexNum);
		
		// init graph & set to be not null
		for (int i = 0; i < vertexNum; i++) {
			graph.add(new LinkedList<Integer>());
		}
		
		// create the graph
		for (int i = 0; i < segNum; i++) {
			LinkedList<Integer> list0 = graph.get(seg[i][0]);
			LinkedList<Integer> list1 = graph.get(seg[i][1]);
			list0.add(seg[i][1]);
			list1.add(seg[i][0]);
		}
	}
	
	/**
	 * Check if it is an eulerian graph.<br/>
	 * (1) 0 or 2 odd vertex<br/>
	 * (2) connected graph
	 * 
	 * @return
	 */
	public boolean isEulerian() {
		LinkedList<Integer> oddVertex = this.findOddVertex();
		if (vertexNum == 0)
			return true;
		else if (oddVertex.size() == 0)
			return isConnected(0);
		else if (oddVertex.size() == 2)
			return isConnected(oddVertex.get(0));
		else
			return false;
	}
	
	/**
	 * Check if it is connected.<br/>
	 * DFS traverse
	 * 
	 * @return
	 */
	public boolean isConnected(int vertexIndex) {
		// init & set to false
		visited = new boolean[vertexNum];
		// traverse
		visit(vertexIndex);
		// check is connected
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}
	
	/**
	 * find the odd vertex
	 * 
	 * @return
	 */
	public LinkedList<Integer> findOddVertex() {
		LinkedList<Integer> oddVertex = new LinkedList<Integer>();
		for (int i = 0; i < vertexNum; i++) {
			LinkedList<Integer> vertexList = graph.get(i);
			if (vertexList.size() % 2 != 0)
				oddVertex.add(i);
		}
		return oddVertex;
	}
	
	/**
	 * visit the graph starting from one vertex
	 * 
	 * @param vertexIndex
	 */
	private void visit(int vertexIndex) {
		LinkedList<Integer> vertexList = graph.get(vertexIndex);
		Iterator<Integer> iter = vertexList.iterator();
		while(iter.hasNext()) {
			Integer cur = iter.next();
			if (!visited[cur]) {
				visited[cur] = true;
				visit(cur);
			}
		}
	}
}
