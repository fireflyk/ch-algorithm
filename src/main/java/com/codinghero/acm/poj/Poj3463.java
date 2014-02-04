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

	public static void main(String[] args) throws NumberFormatException, IOException {
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		cin.nextToken();
		final int caseNumber = (int) cin.nval;
		for (int i = 0; i < caseNumber; i++) {
			ArrayList<LinkedList<Edge>> graph = getInput(cin);
			cin.nextToken();
			final int orig = (int) cin.nval;
			cin.nextToken();
			final int dest = (int) cin.nval;
			System.out.println(dijkstra(graph, orig, dest));
		}
	}
	
	public static ArrayList<LinkedList<Edge>> getInput(StreamTokenizer cin) throws NumberFormatException, IOException {
		cin.nextToken();
		final int vertexNumber = (int) cin.nval;
		cin.nextToken();
		final int edgeNumber = (int) cin.nval;
		// initial the graph 
		ArrayList<LinkedList<Edge>> graph = new ArrayList<LinkedList<Edge>>();
		for (int i = 0; i < vertexNumber; i++) {
			graph.add(new LinkedList<Edge>());
		}
		// add edge
		for (int i = 0; i < edgeNumber; i++) {
			cin.nextToken();
			final int from = (int) cin.nval;
			cin.nextToken();
			final int to = (int) cin.nval;
			cin.nextToken();
			final int distance = (int) cin.nval;
			Edge edge = new Edge(to, distance);
			LinkedList<Edge> edges = graph.get(from);
			// very small number, leave it only
			if (edges.size() == 0 || distance + 1 < edges.getFirst().distance) {
				edges.addFirst(edge);
			}
			// smaller than the smallest one, remove the tail
			else if (distance + 1 == edges.getFirst().distance) {
				edges.addFirst(edge);
				Iterator<Edge> iter = edges.iterator();
				while (iter.hasNext()) {
					if (iter.next().distance > distance + 1) {
						iter.remove();
					}
				}
			} 
			// equals the smallest one
			else if (distance == edges.getFirst().distance) {
				edges.addFirst(edge);
			}
			// equals the biggest one
			else if (distance == edges.getFirst().distance + 1) {
				edges.addLast(edge);
			}
		}
		return graph;
	}
	
	public static int dijkstra(ArrayList<LinkedList<Edge>> graph, final int orig, final int dest) {
		HashSet<Integer> unSelectedSet = new HashSet<Integer>();
		for (int i = 1; i < graph.size(); i++) {
			unSelectedSet.add(i);
		}
		return dijkstra(graph, unSelectedSet, new ArrayList<LinkedList<Long>>(graph.size()), orig, dest);
	}

	private static int dijkstra(ArrayList<LinkedList<Edge>> graph, HashSet<Integer> unSelectedSet, ArrayList<LinkedList<Long>> minCosts, int prevSelect, final int dest) {
		if (unSelectedSet.isEmpty())
			return 0;
		Integer curSelect = null;
		for (Edge edge : graph.get(prevSelect)) {
			if (unSelectedSet.contains(edge.to)) {
				calculate(edge, minCosts, prevSelect);
			}
		}
		Long min = null;
		for (Integer unSelect : unSelectedSet) {
			for (Long distance : minCosts.get(unSelect)) {
				if (min == null || min > distance) {
					min = distance;
					curSelect = unSelect;
				}
			}
		}
		
		if (curSelect == dest) {
			return minCosts.get(curSelect).size();
		}
		
		unSelectedSet.remove(curSelect);
		return dijkstra(graph, unSelectedSet, minCosts, curSelect, dest);
	}
	
	private static void calculate(Edge edge, ArrayList<LinkedList<Long>> minCosts, int prevSelect) {
		// calculate all possible distance
		for (Long minCost : minCosts.get(prevSelect)) {
			long temp = edge.distance + minCost;
			minCosts.get(edge.to).add(temp);
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
	
	private static class Edge {
		private int to;
		private long distance;
		public Edge(int to, long distance) {
			this.to = to;
			this.distance = distance;
		}
	}
}
