package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class MergeKSortedListsTest {

    private MergeKSortedLists2 instance = new MergeKSortedLists2();

    @Test
    public void test1() {
        ListNode l0Node0 = new ListNode(2);
        ListNode l0Node1 = new ListNode(5);
        l0Node0.next = l0Node1;

        ListNode l1Node0 = null;

        ListNode l2Node0 = new ListNode(1);
        ListNode l2Node1 = new ListNode(4);
        ListNode l2Node2 = new ListNode(7);
        l2Node0.next = l2Node1;
        l2Node1.next = l2Node2;

        ListNode[] lists = new ListNode[3];
        lists[0] = l0Node0;
        lists[1] = l1Node0;
        lists[2] = l2Node0;

        ListNode result = instance.mergeKLists(lists);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.next.val, 2);
        Assert.assertEquals(4, result.next.next.val, 4);
        Assert.assertEquals(5, result.next.next.next.val, 5);
        Assert.assertEquals(7, result.next.next.next.next.val, 7);
        Assert.assertEquals(null, result.next.next.next.next.next);
    }

    @Test
    public void test2() {
        Assert.assertEquals(null, instance.mergeKLists(null));
    }

    @Test
    public void test3() {
        ListNode l0Node0 = new ListNode(0);
        ListNode l1Node0 = new ListNode(1);
        ListNode[] lists = new ListNode[2];
        lists[0] = l0Node0;
        lists[1] = l1Node0;
        ListNode result = instance.mergeKLists(lists);
        Assert.assertEquals(0, result.val);
        Assert.assertEquals(1, result.next.val);
    }
}
