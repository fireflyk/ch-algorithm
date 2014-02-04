package com.codinghero.acm.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Tong Liu
 *
 */
public class Poj3463 {

	//private Long[][] min
	
	private final static int START = 0;
	private final static int LESS_EQUAL = 1;
	private final static int GREATER_ONE = 2;
	private final static int GREATER_MORE_THAN_ONE = 2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Poj3463 instance = new Poj3463();
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		cin.nextToken();
		final int caseNumber = (int) cin.nval;
		for (int i = 0; i < caseNumber; i++) {
			ArrayList<LinkedList<Edge>> graph = instance.getInput(cin);
			cin.nextToken();
			final int orig = (int) cin.nval;
			cin.nextToken();
			final int dest = (int) cin.nval;
			System.out.println(instance.dijkstra(graph, orig, dest));
		}
	}
	
	public ArrayList<LinkedList<Edge>> getInput(StreamTokenizer cin) throws NumberFormatException, IOException {
		cin.nextToken();
		final int vertexNumber = (int) cin.nval;
		cin.nextToken();
		final int edgeNumber = (int) cin.nval;
		// initial the graph 
		ArrayList<LinkedList<Edge>> graph = new ArrayList<LinkedList<Edge>>();
		for (int i = 0; i < vertexNumber + 1; i++) {
			graph.add(new LinkedList<Edge>());
		}
		// add edge
		for (int i = 0; i < edgeNumber; i++) {
			cin.nextToken();
			final int from = (int) cin.nval;
			cin.nextToken();
			final int to = (int) cin.nval;
			cin.nextToken();
			final long distance = (int) cin.nval;
			Edge inputEdge = new Edge(from, to, distance);
			LinkedList<Edge> edges = graph.get(from);
			addEdge(edges, inputEdge);
		}
		return graph;
	}
	
	private void addEdge(LinkedList<Edge> edges, Edge inputEdge) {
		Long min = null;
		int state = START;
		ListIterator<Edge> iter = edges.listIterator();
		while (iter.hasNext()) {
			Edge curEdge = iter.next();
			if (inputEdge.to == curEdge.to) {
				// less and equal
				if (inputEdge.distance <= curEdge.distance) {
					min = inputEdge.distance;
					state = LESS_EQUAL;
					break;
				}
				// 
				else if (inputEdge.distance == curEdge.distance + 1) {
					min = curEdge.distance;
					state = GREATER_ONE;
					break;
				} else {
					state = GREATER_MORE_THAN_ONE;
					break;
				}
			}
		}
		
		if (state == START) {
			iter.add(inputEdge);
		} else if (state == LESS_EQUAL || state == GREATER_ONE) {
			if (state == LESS_EQUAL)
				iter.add(inputEdge);
			else if (state == GREATER_ONE)
				edges.addLast(inputEdge);
			while (iter.hasNext()) {
				Edge curEdge = iter.next();
				if (inputEdge.to == curEdge.to && curEdge.distance > min + 1) {
					iter.remove();
				}
			}
		}
	}
	
	private void calculate(ArrayList<LinkedList<Long>> minCosts, Edge edge) {
		for (Long minCost : minCosts.get(edge.from)) {
			long temp = edge.distance + minCost;
			// start
			Iterator<Long> iter = minCosts.get(edge.to).iterator();
			Long min = null;
			int state = START;
			while (iter.hasNext()) {
				long distance = iter.next();
				if (temp <= distance) {
					min = temp;
					state = LESS_EQUAL;
					break;
				} else if (temp == distance + 1) {
					min = distance;
					state = GREATER_ONE;
					break;
				} else {
					state = GREATER_MORE_THAN_ONE;
					break;
				}
			}
			if (state == 0) {
				minCosts.get(edge.to).add(temp);
			} else if (state == 1) {
				while (iter.hasNext()) {
					Long distance = iter.next();
					if (min + 1 < distance) {
						iter.remove();
					}
				}
				if (min == temp) {
					minCosts.get(edge.to).addFirst(temp);
				} else if (min + 1 == temp) {
					minCosts.get(edge.to).addLast(temp);
				}
			}
		}
	}
	
	public int dijkstra(ArrayList<LinkedList<Edge>> graph, final int orig, final int to) {
		HashSet<Integer> unSelectedSet = new HashSet<Integer>();
		for (int i = 1; i < graph.size(); i++) {
			unSelectedSet.add(i);
		}
		unSelectedSet.remove(orig);
		
		ArrayList<LinkedList<Long>> minCosts = new ArrayList<LinkedList<Long>>();
		for (int i = 0; i < graph.size(); i++) {
			minCosts.add(new LinkedList<Long>());
		}
		minCosts.get(orig).add(0L);
		
		dijkstra(graph, unSelectedSet, minCosts, orig, to);
		return minCosts.get(to).size();
	}

	private void dijkstra(ArrayList<LinkedList<Edge>> graph, HashSet<Integer> unSelectedSet, ArrayList<LinkedList<Long>> minCosts, final int from, final int to) {
		if (unSelectedSet.isEmpty())
			return;
		Integer curSelect = null;
		// iterate edge of the vertex
		for (Edge edge : graph.get(from)) {
			if (unSelectedSet.contains(edge.to)) {
				// iterate cost of all the vertex cost
					//minCosts.get(edge.to).add(temp);
					
					
			}
		}
		
		Long min = null;
		for (Integer unSelect : unSelectedSet) {
			for (Long distance : minCosts.get(unSelect)) {
				if (min == null || min > distance){
					min = distance;
					curSelect = unSelect;
				}
			}
		}
		
//		if (curSelect == dest) {
//			return minCosts.get(curSelect).size();
//		}
		
		unSelectedSet.remove(curSelect);
		dijkstra(graph, unSelectedSet, minCosts, curSelect, to);
	}
	
	private static class Edge {
		private int from;
		private int to;
		private long distance;
		public Edge(int from, int to, long distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
	}
	
}
