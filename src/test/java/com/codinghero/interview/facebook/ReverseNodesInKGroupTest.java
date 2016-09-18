package com.codinghero.interview.facebook;

import junit.framework.Assert;

import org.junit.Test;

public class ReverseNodesInKGroupTest {

    private ReverseNodesInKGroup2 instance = new ReverseNodesInKGroup2();

    @Test
    public void testReverseKGroup1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode head = instance.reverseKGroup(n1, 4);
        Assert.assertEquals(1, head.val);
        head = head.next;
        Assert.assertEquals(2, head.val);
        head = head.next;
        Assert.assertEquals(3, head.val);
    }

    @Test
    public void testReverseKGroup2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode head = instance.reverseKGroup(n1, 4);
        Assert.assertEquals(4, head.val);
        head = head.next;
        Assert.assertEquals(3, head.val);
        head = head.next;
        Assert.assertEquals(2, head.val);
        head = head.next;
        Assert.assertEquals(1, head.val);
    }

    @Test
    public void testReverseKGroup3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = instance.reverseKGroup(n1, 4);
        Assert.assertEquals(4, head.val);
        head = head.next;
        Assert.assertEquals(3, head.val);
        head = head.next;
        Assert.assertEquals(2, head.val);
        head = head.next;
        Assert.assertEquals(1, head.val);
        head = head.next;
        Assert.assertEquals(5, head.val);
    }

    @Test
    public void testReverseKGroup4() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode head = instance.reverseKGroup(n1, 4);
        Assert.assertEquals(4, head.val);
        head = head.next;
        Assert.assertEquals(3, head.val);
        head = head.next;
        Assert.assertEquals(2, head.val);
        head = head.next;
        Assert.assertEquals(1, head.val);
        head = head.next;
        Assert.assertEquals(5, head.val);
        head = head.next;
        Assert.assertEquals(6, head.val);
    }

    @Test
    public void testReverseKGroup5() {
        Assert.assertEquals(null, instance.reverseKGroup(null, 4));
    }

    @Test
    public void testReverseKGroup6() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode head = instance.reverseKGroup(n1, 2);
        Assert.assertEquals(2, head.val);
        head = head.next;
        Assert.assertEquals(1, head.val);
    }
}
