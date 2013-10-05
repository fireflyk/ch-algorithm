package com.codinghero.acm.poj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import com.codinghero.datastructure.Graph;

public class Poj2513 {

	private static int snNumber = 0;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		Map<String, Integer> stickSn = new HashMap<String, Integer>();
		int segNum = 0;
		LinkedList<Integer[]> seg = new LinkedList<Integer[]>();
		while (cin.hasNext()) {
			int leftSn = putSn(cin.next(), stickSn);
			int rightSn = putSn(cin.next(), stickSn);
			Integer[] aSeg = new Integer[2];
			aSeg[0] = leftSn;
			aSeg[1] = rightSn;
			seg.add(aSeg);
			segNum++;
		}

		AdjacencyList graph = new AdjacencyList(seg, segNum, snNumber);
		if (graph.isEulerian())
			System.out.println("Possible");
		else
			System.out.println("Impossible");
	}

	private static int putSn(String color, Map<String, Integer> stickSn) {
		if (stickSn.containsKey(color)) {
			return stickSn.get(color);
		} else {
			stickSn.put(color, snNumber);
			return snNumber++;
		}
	}
	
	public static class AdjacencyList implements Graph {
		
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
		public AdjacencyList(LinkedList<Integer[]> seg, int segNum, int vertexNum) {
			
			this.vertexNum = vertexNum;
			this.graph = new ArrayList<LinkedList<Integer>>(vertexNum);
			
			// init graph & set to be not null
			for (int i = 0; i < vertexNum; i++) {
				graph.add(new LinkedList<Integer>());
			}
			
			// create the graph
			Iterator<Integer[]> iter = seg.iterator();
			while (iter.hasNext()) {
				Integer[] aSeg = iter.next();
				LinkedList<Integer> list0 = graph.get(aSeg[0]);
				LinkedList<Integer> list1 = graph.get(aSeg[1]);
				list0.add(aSeg[1]);
				list1.add(aSeg[0]);
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

}
