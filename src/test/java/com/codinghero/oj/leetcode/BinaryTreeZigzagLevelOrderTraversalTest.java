package com.codinghero.oj.leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversalTest {
	
	@Test
	public void test1() {
		TreeNode node0 = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		
		node0.left = node1;
		node0.right = node2;
		node2.left = node3;
		node2.right = node4;
		
		ArrayList<ArrayList<Integer>> result = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node0);
		ArrayList<Integer> result0 = new ArrayList<Integer>();
		result0.add(3);
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(20);
		result1.add(9);
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		result2.add(15);
		result2.add(7);
		Assert.assertEquals(result0, result.get(0));
		Assert.assertEquals(result1, result.get(1));
		Assert.assertEquals(result2, result.get(2));
	}

	
	@Test
	public void test2() {
		Assert.assertEquals(new ArrayList<ArrayList<Integer>>(), new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(null));
		ArrayList<ArrayList<Integer>> result = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(new TreeNode(1));
		ArrayList<Integer> result0 = new ArrayList<Integer>();
		result0.add(1);
		Assert.assertEquals(result0, result.get(0));
	}
}
