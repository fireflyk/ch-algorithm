package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class RecoverBinarySearchTreeTest {
	
	@Test
	public void test1() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node4.left = node6;
		node4.right = node2;
		node6.left = node1;
		node6.right = node3;
		node2.left = node5;
		node2.right = node7;
		
		RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
		recoverBinarySearchTree.recoverTree(node4);
		Assert.assertEquals(2, node6.val);
		Assert.assertEquals(6, node2.val);
	}
	
	@Test
	public void test2() {
		RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
		recoverBinarySearchTree.recoverTree(null);
		
		TreeNode node1 = new TreeNode(1);
		recoverBinarySearchTree.recoverTree(node1);
		Assert.assertEquals(1, node1.val);
	}

	@Test
	public void test3() {
		RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
		recoverBinarySearchTree.recoverTree(null);
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node2.right = node1;
		recoverBinarySearchTree.recoverTree(node2);
		Assert.assertEquals(1, node2.val);
		Assert.assertEquals(2, node1.val);
	}
}
