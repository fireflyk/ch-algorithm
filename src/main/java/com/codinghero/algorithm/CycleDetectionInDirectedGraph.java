package com.codinghero.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class CycleDetectionInDirectedGraph {

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        int vertexNum = c.nextInt();
        int edgeNum = c.nextInt();
        int[][] edges = new int[edgeNum][2];
        for (int i = 0; i < edgeNum; i++) {
            edges[i][0] = c.nextInt();
            edges[i][1] = c.nextInt();
        }
        c.close();
        System.out.println(new CycleDetectionInDirectedGraph().isCycleExisted(edges, vertexNum) ? 1 : 0);
    }

    public boolean isCycleExisted(int[][] edges, int vertexNum) {
        ArrayList<LinkedList<Integer>> graph = this.getGraph(edges, vertexNum);
        Set<Integer> visited = new HashSet<Integer>();
        for (int entrance = 0; entrance < vertexNum; entrance++) {
            if (isCycleExisted(entrance, graph, new HashSet<Integer>(), visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycleExisted(int vertexIndex, ArrayList<LinkedList<Integer>> graph, Set<Integer> parents,
            Set<Integer> visited) {
        if (visited.contains(vertexIndex)) {
            return false;
        } else if (parents.contains(vertexIndex)) {
            return true;
        }
        parents.add(vertexIndex);
        LinkedList<Integer> dependencies = graph.get(vertexIndex);
        for (Integer dependency : dependencies) {
            if (isCycleExisted(dependency, graph, parents, visited)) {
                return true;
            }
        }
        parents.remove(vertexIndex);
        visited.add(vertexIndex);
        return false;
    }

    /**
     * 
     * @param edges
     * @param vertexNum
     */
    private ArrayList<LinkedList<Integer>> getGraph(int[][] edges, int vertexNum) {
        // initialize graph & set to be not null
        ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>(vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            graph.add(new LinkedList<Integer>());
        }
        // create the graph
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        return graph;
    }
}
