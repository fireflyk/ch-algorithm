package com.codinghero.oj.leetcode;

public class CheckTreeBalanced {
	
	private static int NOT_BALANCED = -1;
	
	public boolean isBalanced(TreeNode root) {
		return height(root) != NOT_BALANCED;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;
		int leftHeight = height(node.left);
		if (leftHeight == NOT_BALANCED)
			return NOT_BALANCED;
		int rightHeight = height(node.right);
		if (rightHeight == NOT_BALANCED)
			return NOT_BALANCED;
		else if (abs(leftHeight, rightHeight) > 1)
			return NOT_BALANCED;
		else
			return max(leftHeight, rightHeight) + 1;
	}

	private int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	private int abs(int a, int b) {
		if (a > b)
			return a - b;
		else
			return b - a;
	}
}
