package com.codinghero.oj.poj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * not done
 * 
 * @author liutong01
 * 
 */
public class Poj2513Ans2 {
	
	private static int snNumber = 0;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		Trie stickSn = new Trie();
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

		AdjacencyList graph = new AdjacencyList();
		graph.init(seg, segNum, snNumber);
		if (graph.isConnected())
			System.out.println("Possible");
		else
			System.out.println("Impossible");
	}

	private static int putSn(String color, Trie stickSn) {
		int value = stickSn.get(color);
		if (value != -1) {
			return value;
		} else {
			stickSn.insert(color, snNumber);
			return snNumber++;
		}
	}
	
	private static class AdjacencyList {
		private ArrayList<LinkedList<Integer>> graph;
		private boolean[] visited;
		private int vertexNum;
		
		public void init(LinkedList<Integer[]> seg, int segNum, int vertexNum) {
			this.vertexNum = vertexNum;
			this.graph = new ArrayList<LinkedList<Integer>>(vertexNum);
			// init & set to be not null
			for (int i = 0; i < vertexNum; i++) {
				graph.add(new LinkedList<Integer>());
			}
			
			// create the graph
			Iterator<Integer[]> iter = seg.iterator();
			while(iter.hasNext()) {
				Integer[] aSeg = iter.next();
				LinkedList<Integer> list0 = graph.get(aSeg[0]);
				LinkedList<Integer> list1 = graph.get(aSeg[1]);
				list0.add(aSeg[1]);
				list1.add(aSeg[0]);
			}
		}
		
		public boolean isConnected() {
			LinkedList<Integer> oddVertex = this.findOddVertex();
			int startVertex;
			if (vertexNum == 0)
				return true;
			else if (oddVertex.size() == 0)
				startVertex = 0;
			else if (oddVertex.size() == 2)
				startVertex = oddVertex.get(0);
			else
				return false;
			
			// init & set to false
			visited = new boolean[vertexNum];
			// traverse
			visit(startVertex);
			// check is connected
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i])
					return false;
			}
			return true;
		}
		
		public LinkedList<Integer> findOddVertex() {
			LinkedList<Integer> oddVertex = new LinkedList<Integer>();
			for (int i = 0; i < vertexNum; i++) {
				LinkedList<Integer> vertexList = graph.get(i);
				if (vertexList.size() % 2 != 0)
					oddVertex.add(i);
			}
			return oddVertex;
		}
		
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
	
	private static class Trie {
		
		private Node root = new Node();
		
		private class Node {
			private Node[] child = new Node[26];
			private int value;
			
			public Node getChild(char c) {
				return child[c - 'a'];
			}

			public boolean visited(char c) {
				return getChild(c) != null;
			}
			
			public Node visit(char c) {
				child[c - 'a'] = new Node();
				return getChild(c);
			}
			
			public void put(int value) {
				this.value = value;
			}
			
			public int get() {
				return this.value;
			}
		}
		
		public void insert(String str, int value) {
			char[] cArr = str.toCharArray();
			Node cur = root;
			for (int i = 0; i < cArr.length; i++) {
				cur = cur.visit(cArr[i]);
			}
			cur.put(value);
		}

		public int get(String str) {
			char[] cArr = str.toCharArray();
			Node cur = root;
			for (int i = 0; i < cArr.length; i++) {
				char c = cArr[i];
				if (cur.visited(c))
					cur = cur.getChild(c);
				else
					return -1;
			}
			return cur.get();
		}
	}
}
