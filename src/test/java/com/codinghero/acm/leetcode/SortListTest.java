package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class SortListTest {
	@Test
	public void test1() {
		SortList instance = new SortList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node6.next = node4;
		node4.next = node1;
		node1.next = node8;
		node8.next = node7;
		node7.next = node3;
		node3.next = node5;
		node5.next = node2;
		ListNode newHead = instance.sortList(node6);
		Assert.assertEquals(1, newHead.val);
		Assert.assertEquals(2, newHead.next.val);
	}

	@Test
	public void test2() {
		SortList instance = new SortList();
		ListNode node1 = new ListNode(1);
		ListNode newHead = instance.sortList(node1);
		Assert.assertEquals(1, newHead.val);
		Assert.assertEquals(null, newHead.next);
	}

	@Test
	public void test3() {
		SortList instance = new SortList();
		ListNode newHead = instance.sortList(null);
		Assert.assertEquals(null, newHead);
	}
}
