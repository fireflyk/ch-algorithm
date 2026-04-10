package com.codinghero.oj.leetcode;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		
		// when one son node is null, return the other (depth+1)
		if (leftDepth == 0 || rightDepth == 0)
			return leftDepth + rightDepth + 1;
		// min + 1
		else
			return Math.min(leftDepth, rightDepth) + 1;
	}
}
