package com.codinghero.acm.leetcode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return innerIsValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean innerIsValidBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val <= min || root.val >= max)
			return false;
		return innerIsValidBST(root.left, min, root.val) && innerIsValidBST(root.right, root.val, max);
	}
}
