package com.codinghero.acm.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tong Liu
 *
 */
public class Poj3463 {

	//private Long[][] min
	
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
			instance.dijkstra(graph, orig, dest);
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
			Edge edge = new Edge(from, to, distance);
			LinkedList<Edge> edges = graph.get(from);
			
			Iterator<Edge> iter = edges.iterator();
			Long min = null;
			int state = 0;
			while (iter.hasNext()) {
				Edge curEdge = iter.next();
				if (curEdge.to == to) {
					if (distance <= curEdge.distance) {
						min = distance;
						state = 1;
						break;
					} else if (distance == curEdge.distance + 1) {
						min = curEdge.distance;
						state = 1;
						break;
					}
				}
			}
			
			if (state == 0) {
				edges.addFirst(edge);
			} else if (state == 1) {
				while (iter.hasNext()) {
					Edge curEdge = iter.next();
					if (curEdge.to == to && min + 1 < curEdge.distance) {
						iter.remove();
					}
				}
				if (min == distance) {
					edges.addFirst(edge);
				} else if (min + 1 == distance) {
					edges.addLast(edge);
				}
			}
		}
		return graph;
	}
	
	public void dijkstra(ArrayList<LinkedList<Edge>> graph, final int orig, final int dest) {
		HashSet<Integer> unSelectedSet = new HashSet<Integer>();
		for (int i = 1; i < graph.size(); i++) {
			unSelectedSet.add(i);
		}
		unSelectedSet.remove(orig);
		ArrayList<LinkedList<Long>> minCosts = new ArrayList<LinkedList<Long>>();
		for (int i = 1; i <= graph.size(); i++) {
			minCosts.add(new LinkedList<Long>());
		}
		minCosts.get(orig).add(0L);
		dijkstra(graph, unSelectedSet, minCosts, orig, dest, 0L);
	}

	private void dijkstra(ArrayList<LinkedList<Edge>> graph, HashSet<Integer> unSelectedSet, ArrayList<LinkedList<Long>> minCosts, final int from, final int to, Long prevMin) {
		if (unSelectedSet.isEmpty())
			return;
		Integer curSelect = null;
		Long min = null;
		// iterate edge of the vertex
		for (Edge edge : graph.get(from)) {
			if (unSelectedSet.contains(edge.to)) {
				// iterate cost of all the vertex cost
				for (Long minCost : minCosts.get(edge.from)) {
					long temp = edge.distance + minCost;
					//minCosts.get(edge.to).add(temp);
					
					// start 
					Iterator<Long> iter = minCosts.get(edge.to).iterator();
					Long innerMin = null;
					int state = 0;
					while (iter.hasNext()) {
						long distance = iter.next();
						if (temp <= distance) {
							innerMin = temp;
							state = 1;
							break;
						} else if (temp == distance + 1) {
							innerMin = distance;
							state = 1;
							break;
						}
					}
					if (state == 0) {
						minCosts.get(edge.to).add(temp);
					} else if (state == 1) {
						while (iter.hasNext()) {
							Long distance = iter.next();
							if (innerMin + 1 < distance) {
								iter.remove();
							}
						}
						if (min == temp) {
							minCosts.get(edge.to).addFirst(temp);
						} else if (min + 1 == temp) {
							minCosts.get(edge.to).addLast(temp);
						}
					}
					// end
				}
				// calculate minimum
				Long min = null;
				for (Long distance : minCosts.get(edge.to)) {
					if (min == null || min > distance) {
						min = distance;
					}
				}
				// remove the bigger ones
				Iterator<Long> iter = minCosts.get(edge.to).iterator();
				while (iter.hasNext()) {
					if (min + 1 < iter.next()) {
						iter.remove();
					}
				}
			}
		}
//		Long min = null;
//		for (Integer unSelect : unSelectedSet) {
//			for (Long distance : minCosts.get(unSelect)) {
//				if ((min == null || min > distance) && distance >= prevMin) {
//					min = distance;
//					curSelect = unSelect;
//				}
//			}
//		}
		
//		if (curSelect == dest) {
//			return minCosts.get(curSelect).size();
//		}
		
//		unSelectedSet.remove(curSelect);
		dijkstra(graph, unSelectedSet, minCosts, curSelect, dest, min);
	}
	
//	private void calculate(Edge edge, ArrayList<LinkedList<Long>> minCosts) {
//		// calculate all possible distance
//		for (Long minCost : minCosts.get(edge.from)) {
//			long temp = edge.distance + minCost;
//			minCosts.get(edge.to).add(temp);
//		}
//		// calculate minimum
//		Long min = null;
//		for (Long distance : minCosts.get(edge.to)) {
//			if (min == null || min > distance) {
//				min = distance;
//			}
//		}
//		// remove the bigger ones
//		Iterator<Long> iter = minCosts.get(edge.to).iterator();
//		while (iter.hasNext()) {
//			if (min + 1 < iter.next()) {
//				iter.remove();
//			}
//		}
//	}
	
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
