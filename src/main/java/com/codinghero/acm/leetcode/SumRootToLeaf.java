package com.codinghero.acm.leetcode;

public class SumRootToLeaf {
	
	public int sumNumbers(TreeNode root) {
		return root == null ? 0 : sumNumbersInner(root, root.val);
	}
	
	private int sumNumbersInner(TreeNode root, int sum) {
		int leftSum = 0, rightSum = 0;
		if (root.left != null)
			leftSum = sumNumbersInner(root.left, sum * 10 + root.left.val);
		if (root.right != null)
			rightSum = sumNumbersInner(root.right, sum * 10 + root.right.val);
		return (leftSum + rightSum) == 0 ? sum : (leftSum + rightSum);
	}
	
	// private int merge(final int a, final int b) {
	// int pow = 1;
	// int tempB = b;
	// while (tempB < 10) {
	// tempB /= 10;
	// pow *= 10;
	// }
	// return a * pow + b;
	// }
}