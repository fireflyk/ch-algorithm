package com.codinghero.interview.tango;

import junit.framework.Assert;

import org.junit.Test;

public class MCQ8Test {
	@Test
	public void testXSum() {
		TreeNode n0 = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(12);
		n0.setLeft(n1);
		n0.setRight(n2);
		n1.setLeft(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n5.setRight(n6);
		
		Assert.assertEquals(12, new MCQ8().xSum(n0));
	}
}
