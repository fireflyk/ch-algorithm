package com.codinghero.acm.leetcode;

public class BinaryTreeMaxiumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		Result result = calMaxPathSum(root);
		return result.maxSum;
	}
	
	private Result calMaxPathSum(TreeNode root) {
		if (root == null)
			return new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Result left = calMaxPathSum(root.left);
		Result right = calMaxPathSum(root.right);
		int sum = 0, maxSum = 0;
		if (left.sum >= 0 && right.sum >= 0) {
			sum = root.val + Math.max(left.sum, right.sum);
			if (root.val >= 0)
				maxSum = root.val + left.sum + right.sum;
			else
				maxSum = Math.max(root.val + left.sum + right.sum, Math.max(left.sum, right.sum));
		} else if (left.sum >= 0 && right.sum < 0) {
			sum = root.val + left.sum;
			if (root.val >= 0)
				maxSum = root.val + left.sum;
			else
				maxSum = left.sum;
		} else if (left.sum < 0 && right.sum >= 0) {
			sum = root.val + right.sum;
			if (root.val >= 0)
				maxSum = root.val + right.sum;
			else
				maxSum = right.sum;
		} else {
			sum = root.val;
			maxSum = root.val;
		}
		maxSum = Math.max(maxSum, Math.max(left.maxSum, right.maxSum));
		
		return new Result(sum, maxSum);
	}
	
	private class Result {
		private int sum;
		private int maxSum;
		
		public Result(int sum, int maxSum) {
			this.sum = sum;
			this.maxSum = maxSum;
		}
	}
}
