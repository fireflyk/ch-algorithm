package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {
	
	private RemoveDuplicatesFromSortedList instance = new RemoveDuplicatesFromSortedList();

	@Test
	public void test3() {
		ListNode node0 = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		node0.next=node1;
		node1.next=node2;
		
		instance.deleteDuplicates(node0);
		Assert.assertEquals(1, node0.val);
		Assert.assertEquals(null, node0.next);
	}
	
	@Test
	public void test1() {
		ListNode node0 = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		node0.next=node1;
		node1.next=node2;
		node2.next=node3;
		
		instance.deleteDuplicates(node0);
		Assert.assertEquals(1, node0.val);
		Assert.assertEquals(2, node0.next.val);
		Assert.assertEquals(null, node0.next.next);
	}
	
	@Test
	public void test2() {
		ListNode node0 = new ListNode(1);
		
		instance.deleteDuplicates(node0);
		Assert.assertEquals(1, node0.val);
		Assert.assertEquals(null, node0.next);
	}
}
