package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {
	
	private RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();

	@Test
	public void test4() {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		node0.next = node1;
		ListNode result = instance.removeNthFromEnd(node0, 1);

		Assert.assertEquals(0, result.val);
	}

	@Test
	public void test2() {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		node0.next = node1;
		ListNode result = instance.removeNthFromEnd(node0, 2);

		Assert.assertEquals(1, result.val);
	}
	
	@Test
	public void test1() {
		ListNode node0 = new ListNode(0);
		ListNode result = instance.removeNthFromEnd(node0, 1);

		Assert.assertEquals(null, result);
	}

	@Test
	public void test3() {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		node0.next = node1;
		ListNode result = instance.removeNthFromEnd(node0, 3);

		Assert.assertEquals(null, result);
	}
}
