package com.codinghero.acm.leetcode;

public class BuildBST {

	private int iter = 1;
	
	public void build(TreeNode node, int[] tree, int min, int max) {
		if (node == null || tree[iter] < min || tree[iter] > max)
			return;
		if (tree[iter] < node.val) {
			node.left = new TreeNode(tree[iter++]);
			build(node.left, tree, min, node.left.val);
		} else if (tree[iter] > node.val) {
			node.left = new TreeNode(tree[iter++]);
			build(node.right, tree, node.right.val, max);
		} else
			throw new RuntimeException("Not Support equal value node");
	}

	public static void main(String[] args) {
		int[] tree = { 30, 20, 10, 40, 35, 50 };
		TreeNode root = new TreeNode(tree[0]);
		new BuildBST().build(root, tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println();
	}
}
