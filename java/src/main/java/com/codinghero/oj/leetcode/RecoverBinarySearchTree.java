package com.codinghero.oj.leetcode;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		recoverTree(root, null, result);
		if (result.size() == 4) {
			swap(result.get(0), result.get(3));
		} else if (result.size() == 2) {
			swap(result.get(0), result.get(1));
		}
	}
	
	private TreeNode recoverTree(TreeNode curNode, TreeNode prevNode, ArrayList<TreeNode> result) {
		if (curNode == null)
			return prevNode;
		prevNode = recoverTree(curNode.left, prevNode, result);
		if (prevNode != null && prevNode.val > curNode.val) {
			result.add(prevNode);
			result.add(curNode);
		}
		prevNode = recoverTree(curNode.right, curNode, result);
		return prevNode;
	}
	
	private void swap(TreeNode node1, TreeNode node2) {
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
	}
}
