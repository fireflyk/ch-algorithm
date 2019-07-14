package com.codinghero.oj.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListIITest {
	
	private RemoveDuplicatesFromSortedListII instance = new RemoveDuplicatesFromSortedListII();
	
	@Test
	public void test4() {
		ListNode node0 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node0.next=node1;
		node1.next=node2;
		node2.next=node3;
		
		ListNode result = instance.deleteDuplicates(node0);
		Assert.assertEquals(1, result.val);
		Assert.assertEquals(3, result.next.val);
		Assert.assertEquals(null, result.next.next);
	}

	@Test
	public void test3() {
		ListNode node0 = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		node0.next=node1;
		node1.next=node2;
		
		ListNode result = instance.deleteDuplicates(node0);
		Assert.assertEquals(null, result);
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
		
		ListNode result = instance.deleteDuplicates(node0);
		Assert.assertEquals(null, result);
	}
	
	@Test
	public void test2() {
		ListNode node0 = new ListNode(1);
		
		ListNode result = instance.deleteDuplicates(node0);
		Assert.assertEquals(1, result.val);
	}
	
	@Test
	public void test5() {
		ListNode node0 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node0.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		ListNode result = instance.deleteDuplicates(node0);
		Assert.assertEquals(1, result.val);
		Assert.assertEquals(3, result.next.val);
		Assert.assertEquals(4, result.next.next.val);
		Assert.assertEquals(null, result.next.next.next);
	}
}
