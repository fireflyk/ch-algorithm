package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneGraphBFS {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode orig) {
		if (orig == null)
			return null;
		UndirectedGraphNode dest = new UndirectedGraphNode(orig.label);
		Map<Integer, UndirectedGraphNode> mapping = new HashMap<Integer, UndirectedGraphNode>();
		Set<Integer> visited = new HashSet<Integer>();
		cloneGraph(orig, dest, mapping, visited);
		return dest;
	}
	
	private void cloneGraph(
			UndirectedGraphNode orig, UndirectedGraphNode dest, 
			Map<Integer, UndirectedGraphNode> mapping,
			Set<Integer> visited) {
		
		if (visited.contains(orig.label))
			return;
		ArrayList<UndirectedGraphNode> neighbors = orig.neighbors;
		for (UndirectedGraphNode origNeighbor : neighbors) {
			if (origNeighbor != orig) {
				UndirectedGraphNode destNeighbor = mapping.get(origNeighbor.label);
				if (destNeighbor == null) {
					destNeighbor = new UndirectedGraphNode(origNeighbor.label);
					mapping.put(origNeighbor.label, destNeighbor);
				}
				dest.neighbors.add(destNeighbor);
			} else {
				mapping.put(orig.label, dest);
				dest.neighbors.add(dest);
			}
		}
		visited.add(orig.label);
		for (int i = 0; i < orig.neighbors.size(); i++) {
			UndirectedGraphNode origNeighbor = orig.neighbors.get(i);
			UndirectedGraphNode destNeighbor = dest.neighbors.get(i);
			cloneGraph(origNeighbor, destNeighbor, mapping, visited);
		}
	}
}
