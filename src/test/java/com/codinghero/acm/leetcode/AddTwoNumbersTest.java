package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class AddTwoNumbersTest {
	@Test
	public void addTwoNumbers() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		
		ListNode s = new AddTwoNumbers().addTwoNumbers(l1, l2);
		Assert.assertEquals(7, s.val);
		Assert.assertEquals(0, s.next.val);
		Assert.assertEquals(0, s.next.next.val);
		Assert.assertEquals(1, s.next.next.next.val);
	}
}
