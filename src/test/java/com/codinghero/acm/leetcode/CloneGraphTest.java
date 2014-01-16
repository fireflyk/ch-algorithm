package com.codinghero.acm.leetcode;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class CloneGraphTest {

	@Test
	public void test1() {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		UndirectedGraphNode node5 = new UndirectedGraphNode(5);
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		node0.neighbors.add(node5);
		
		node1.neighbors.add(node0);
		node1.neighbors.add(node3);
		node1.neighbors.add(node4);
		
		node2.neighbors.add(node0);
		node2.neighbors.add(node3);
		
		node3.neighbors.add(node1);
		node3.neighbors.add(node2);
		
		node4.neighbors.add(node1);
		node4.neighbors.add(node5);
		
		//node5.neighbors.add(node5);
		UndirectedGraphNode dest = new CloneGraphBFS().cloneGraph(node0);
		
		Assert.assertEquals(3, dest.neighbors.size());
		
		Assert.assertEquals(null, new CloneGraphBFS().cloneGraph(null));
		
		node0.neighbors = new ArrayList<UndirectedGraphNode>();
		Assert.assertEquals(0, new CloneGraphBFS().cloneGraph(node0).neighbors.size());
	}
	
	@Test
	public void test2() {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		node0.neighbors.add(node0);
		node0.neighbors.add(node0);
		
		UndirectedGraphNode result = new CloneGraphBFS().cloneGraph(node0);
		Assert.assertEquals(2, result.neighbors.size());
		Assert.assertTrue(result == result.neighbors.get(0));
	}
	
	@Test
	public void test3() {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		UndirectedGraphNode node5 = new UndirectedGraphNode(5);
		
		node0.neighbors.add(node1);
		node0.neighbors.add(node5);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node5);
		
		node2.neighbors.add(node3);
		
		node3.neighbors.add(node4);
		node3.neighbors.add(node4);
		
		node4.neighbors.add(node5);
		node4.neighbors.add(node5);
		
		UndirectedGraphNode result = new CloneGraphBFS().cloneGraph(node0);
		Assert.assertEquals(2, result.neighbors.size());
	}
}
