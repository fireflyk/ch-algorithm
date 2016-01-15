package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class ReverseLinkedListTest {

    private ReverseLinkedList instance = new ReverseLinkedList();

    @Test
    public void testReverseList1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        Assert.assertEquals(node3.val, instance.reverseList(node1).val);
    }

    @Test
    public void testReverseList2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        Assert.assertEquals(node2.val, instance.reverseList(node1).val);
    }
}
