package com.codinghero.oj.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        ListNode head = new ListNode(0), tail = head;
        while (!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            tail.next = new ListNode(cur.val);
            tail = tail.next;
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
        }
        return head.next;
    }
}
