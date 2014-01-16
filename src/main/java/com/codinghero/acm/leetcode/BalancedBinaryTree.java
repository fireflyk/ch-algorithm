package com.codinghero.acm.leetcode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		try {
			getHeight(root);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private int getHeight(TreeNode root) throws Exception {
		if (root == null)
			return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (Math.abs(leftHeight - rightHeight) <= 1)
			return Math.max(leftHeight, rightHeight) + 1;
		else
			throw new Exception();
	}
}
