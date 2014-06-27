package com.codinghero.interview.tango;

public class MCQ8 {
	public int xSum(TreeNode root) {
		if (root == null)
			return 0;
		return root.getValue() + xSum(root.getRight()) - xSum(root.getLeft());
	}

}
