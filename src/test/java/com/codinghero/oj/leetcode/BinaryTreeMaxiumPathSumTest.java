package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class BinaryTreeMaxiumPathSumTest {
	
	@Test
	public void testMaxPathSum1() {
		Assert.assertEquals(0, new BinaryTreeMaxiumPathSum().maxPathSum(null));
		Assert.assertEquals(-1, new BinaryTreeMaxiumPathSum().maxPathSum(new TreeNode(-1)));
	}
	
	@Test
	public void testMaxPathSum2() {
		TreeNode node0 = new TreeNode(-1);
		
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(2);
		
		TreeNode node3 = null;
		TreeNode node4 = new TreeNode(-9);
		TreeNode node5 = new TreeNode(0);
		TreeNode node6 = new TreeNode(-3);
		
		TreeNode node7 = null;
		TreeNode node8 = null;
		TreeNode node9 = new TreeNode(-3);
		TreeNode node10 = null;
		TreeNode node11 = null;
		TreeNode node12 = new TreeNode(-9);
		TreeNode node13 = null;
		TreeNode node14 = new TreeNode(2);
		
		node0.left = node1;
		node0.right = node2;
		
		node1.left = node3;
		node1.left = node4;
		node2.left = node5;
		node2.right = node6;
		
//		node3.left = node7;
//		node3.right = node8;
		node4.left = node9;
		node4.right = node10;
		node5.left = node11;
		node5.right = node12;
		node6.left = node13;
		node6.right = node14;
		
		Assert.assertEquals(9, new BinaryTreeMaxiumPathSum().maxPathSum(node0));
	}
	
	@Test
	public void testMaxPathSum3() {
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		
		node0.left = node1;
		node0.right = node2;
		
		Assert.assertEquals(2, new BinaryTreeMaxiumPathSum().maxPathSum(node0));
	}
	
	@Test
	public void testMaxPathSum() {
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-2);
		TreeNode node3 = new TreeNode(-3);
		TreeNode node4 = new TreeNode(-4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(-6);
		
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		Assert.assertEquals(5, new BinaryTreeMaxiumPathSum().maxPathSum(node0));
	}
}
