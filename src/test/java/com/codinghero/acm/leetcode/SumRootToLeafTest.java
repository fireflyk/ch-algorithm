package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class SumRootToLeafTest {
	
	@Test
	public void testSumNumbers() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);

		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.right = n6;
		Assert.assertEquals(123 + 124 + 156, new SumRootToLeaf().sumNumbers(n1));
	}
}
