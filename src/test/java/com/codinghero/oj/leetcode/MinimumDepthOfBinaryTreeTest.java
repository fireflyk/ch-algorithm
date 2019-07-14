package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class MinimumDepthOfBinaryTreeTest {

	@Test
	public void test1() {
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(0);
		node0.left = node1;
		Assert.assertEquals(2, new MinimumDepthOfBinaryTree().minDepth(node0));
	}
	
	@Test
	public void test2() {
		TreeNode node0 = new TreeNode(0);
		
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(0);
		
		TreeNode node3 = null;
		TreeNode node4 = null;
		TreeNode node5 = new TreeNode(0);
		TreeNode node6 = null;
		
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		Assert.assertEquals(2, new MinimumDepthOfBinaryTree().minDepth(node0));
		
		Assert.assertEquals(0, new MinimumDepthOfBinaryTree().minDepth(null));
		Assert.assertEquals(1, new MinimumDepthOfBinaryTree().minDepth(new TreeNode(0)));
	}
}
