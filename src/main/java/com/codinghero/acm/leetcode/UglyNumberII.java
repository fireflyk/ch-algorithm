package com.codinghero.acm.leetcode;

import java.util.PriorityQueue;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		Integer curU = 1;
		PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> heap3 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> heap5 = new PriorityQueue<Integer>();
		heap2.offer(1);
		for (int i = 1; i < n; i++) {
			Integer u2 = heap2.peek();
			Integer u3 = heap3.peek();
			Integer u5 = heap5.peek();

			Integer nu2 = u2 != null ? u2 * 2 : null;
			Integer nu3 = u3 != null ? u3 * 3 : null;
			Integer nu5 = u5 != null ? u5 * 5 : null;

			curU = min(nu2, min(nu3, nu5));
			if (curU == null)
				throw new NullPointerException();

			if (curU.equals(nu5)) {
				heap5.poll();
			}
			if (curU.equals(nu3)) {
				heap3.poll();
				heap5.offer(u3);
			}
			if (curU.equals(nu2)) {
				heap2.poll();
				heap3.offer(u2);
			}
			heap2.offer(curU);
		}
		return curU;
	}

	private Integer min(Integer a, Integer b) {
		if (a != null && b != null)
			return Math.min(a, b);
		else if (a == null && b != null)
			return b;
		else if (a != null && b == null)
			return a;
		else
			return null;
	}

	public static void main(String[] args) {
		System.out.println(new UglyNumberII().nthUglyNumber(39));
	}
}
