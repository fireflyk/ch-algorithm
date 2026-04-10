package com.codinghero.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Graph Valid Tree<br/>
 * 
 * @see <a href="https://leetcode.com/problems/graph-valid-tree/#/description">leetcode</a>
 */
public class CycleDetectionInUndirectedGraph {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<LinkedList<Integer>> graph = this.getGraph(edges, n);
        Set<Integer> visited = new HashSet<Integer>();
        if (isCycleExisted(graph, visited, 0, null)) {
            return false;
        }
        if (visited.size() < n) {
            return false;
        }
        return true;
    }

    private boolean isCycleExisted(ArrayList<LinkedList<Integer>> graph, Set<Integer> visited, Integer currentVertex,
            Integer parentVertex) {
        if (visited.contains(currentVertex)) {
            return true;
        }
        visited.add(currentVertex);
        for (Integer nextVertex : graph.get(currentVertex)) {
            if (parentVertex != null && nextVertex.equals(parentVertex)) {
                continue;
            } else if (isCycleExisted(graph, visited, nextVertex, currentVertex)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<LinkedList<Integer>> getGraph(int[][] edges, int vertexNum) {
        // initialize graph & set to be not null
        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>(vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            graph.add(new LinkedList<Integer>());
        }
        // create the graph
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }
}
