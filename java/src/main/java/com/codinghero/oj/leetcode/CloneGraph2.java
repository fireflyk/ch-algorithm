package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CloneGraph2 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode orig) {
//		if (node == null)
//			return null;
		UndirectedGraphNode dest = new UndirectedGraphNode(orig.label);
		Set<Integer> visited = new HashSet<Integer>();
		cloneGraph(orig, dest, visited);
		return dest;
	}
	
	private void cloneGraph(
			UndirectedGraphNode orig, UndirectedGraphNode dest, 
			Set<Integer> visited) {
		ArrayList<UndirectedGraphNode> neighbors = orig.neighbors;
		for (UndirectedGraphNode origNeighbor : neighbors) {
			if (!visited.contains(origNeighbor.label)) {
				UndirectedGraphNode destNeighbor = new UndirectedGraphNode(origNeighbor.label);
				dest.neighbors.add(destNeighbor);
				visited.add(destNeighbor.label);
				cloneGraph(origNeighbor, destNeighbor, visited);
			}
		}
	}
}
