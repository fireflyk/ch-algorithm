package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		// save the node by level with queue
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);
		boolean leftToward = true;
		
		// scan level by level
		while (!stack.isEmpty()) {
			Stack<TreeNode> nextStack = new Stack<TreeNode>();
			ArrayList<Integer> line = new ArrayList<Integer>();
			// scan a level
			while(!stack.isEmpty()) {
				TreeNode node = stack.pop();
				line.add(node.val);
				if (leftToward) {
					if (node.left != null)
						nextStack.push(node.left);
					if (node.right != null)
						nextStack.push(node.right);
				} else {
					if (node.right != null)
						nextStack.push(node.right);
					if (node.left != null)
						nextStack.push(node.left);
				}
			}
			result.add(line);
			stack = nextStack;
			leftToward = !leftToward;
		}
		
		return result;
	}
}
