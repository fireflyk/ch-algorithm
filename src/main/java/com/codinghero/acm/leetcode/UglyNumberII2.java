package com.codinghero.acm.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII2 {
    public int nthUglyNumber(int n) {
        Long curU = null;
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        heap.offer(1L);
        for (int i = 0; i < n; i++) {
            curU = heap.poll();
            Long next2 = curU * 2;
            Long next3 = curU * 3;
            Long next5 = curU * 5;
            if (!set.contains(next2)) {
                set.add(next2);
                heap.add(next2);
            }
            if (!set.contains(next3)) {
                set.add(next3);
                heap.add(next3);
            }
            if (!set.contains(next5)) {
                set.add(next5);
                heap.add(next5);
            }
        }
        return curU.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII2().nthUglyNumber(7));
    }
}