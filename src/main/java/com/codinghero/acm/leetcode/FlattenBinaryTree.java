package com.codinghero.acm.leetcode;

public class FlattenBinaryTree {
	public void flatten(TreeNode root) {
		if (root != null) {
			flattenInner(root);
		}
	}

	private TreeNode flattenInner(TreeNode root) {
		TreeNode temp = root.right;
		TreeNode leftSonNode = null;

		// left
		if (root.left != null) {
			root.right = root.left;
			leftSonNode = flattenInner(root.left);
			leftSonNode.right = temp;
			root.left = null;
		}

		// right
		if (temp != null) {
			return flattenInner(temp);
		} else if (leftSonNode != null) {
			return leftSonNode;
		} else {
			return root;
		}
	}
}
