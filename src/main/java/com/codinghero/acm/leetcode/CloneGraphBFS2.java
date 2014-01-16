package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneGraphBFS2 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode orig) {
		if (orig == null)
			return null;
		UndirectedGraphNode dest = new UndirectedGraphNode(orig.label);
		Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		cloneGraph(orig, dest, mapping, visited);
		return dest;
	}
	
	private void cloneGraph(
			UndirectedGraphNode orig, UndirectedGraphNode dest, 
			Map<UndirectedGraphNode, UndirectedGraphNode> mapping,
			Set<UndirectedGraphNode> visited) {
		
		if (visited.contains(orig))
			return;
		ArrayList<UndirectedGraphNode> neighbors = orig.neighbors;
		for (UndirectedGraphNode origNeighbor : neighbors) {
			if (origNeighbor != orig) {
				UndirectedGraphNode destNeighbor = mapping.get(origNeighbor);
				if (destNeighbor == null) {
					destNeighbor = new UndirectedGraphNode(origNeighbor.label);
					mapping.put(origNeighbor, destNeighbor);
				}
				dest.neighbors.add(destNeighbor);
			} else {
				mapping.put(orig, dest);
				dest.neighbors.add(dest);
			}
		}
		visited.add(orig);
		for (int i = 0; i < orig.neighbors.size(); i++) {
			UndirectedGraphNode origNeighbor = orig.neighbors.get(i);
			UndirectedGraphNode destNeighbor = dest.neighbors.get(i);
			cloneGraph(origNeighbor, destNeighbor, mapping, visited);
		}
	}
}
