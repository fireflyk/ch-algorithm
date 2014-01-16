package com.codinghero.acm.leetcode;

public class FlattenBinaryTreeOptimize {
	public void flatten(TreeNode root) {
		flattenInner(root);
	}

	private TreeNode flattenInner(TreeNode root) {
		if (root == null)
			return null;

		TreeNode temp = root.right;

		// left
		root.right = root.left;
		TreeNode leftSonNode = flattenInner(root.left);
		if (leftSonNode != null) {
			leftSonNode.right = temp;
			root.left = null;
		} else {
			root.right = temp;
		}

		// right
		TreeNode rightSonNode = flattenInner(temp);
		if (rightSonNode != null) {
			return rightSonNode;
		} else if (leftSonNode != null) {
			return leftSonNode;
		} else {
			return root;
		}
	}
}
