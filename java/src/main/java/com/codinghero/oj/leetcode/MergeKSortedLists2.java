package com.codinghero.oj.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        ListNode tail = null, head = null;
        while (!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            if (tail != null) {
                tail.next = new ListNode(cur.val);
                tail = tail.next;
            } else {
                head = new ListNode(cur.val);
                tail = head;
            }
            ListNode next = cur.next;
            if (next != null) {
                minHeap.offer(next);
            }
        }
        return head;
    }

    private class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }

    }
}
