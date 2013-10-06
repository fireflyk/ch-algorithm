package com.codinghero.algorithm;

import java.util.LinkedList;

public class MinQueue {
	private static int[] maxSlidingWindow(int a[], int w) {
		int b[] = new int[a.length];
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < w; i++) {
			if(!q.isEmpty())
				System.out.println(a[i] + " " + a[q.getLast()]);
			while (!q.isEmpty() && a[i] <= a[q.getLast()])
				q.removeLast();
			q.offer(i);
		}
		for (int i = w; i < a.length; i++) {
			b[i - w] = a[q.getFirst()];
			while (!q.isEmpty() && a[i] <= a[q.getLast()])
				q.removeLast();
			while (!q.isEmpty() && q.getFirst() <= i - w)
				q.removeFirst();
			q.offer(i);
		}
		b[a.length - w] = a[q.getFirst()];
		return b;
	}
	
	public static void main(String[] args) {
		int a[] = new int[]{2,4,5,3,6,7,1};
		int b[] = maxSlidingWindow(a, 4);
		System.out.println(b);
	}
}
