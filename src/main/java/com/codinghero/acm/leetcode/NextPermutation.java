package com.codinghero.acm.leetcode;

import java.util.ArrayList;

public class NextPermutation {

	public void nextPermutation(int[] num) {
		SortedArray<Integer> arr = new SortedArray<Integer>();
		arr.add(num[num.length - 1]);
		int i = num.length - 2;
		for (; i >= 0; i--) {
			Integer largerIndex = findMinimumLargerNumIndex(num[i], arr, 0, arr.size() - 1);
			if (largerIndex < arr.size()) {
				int numI = num[i];
				num[i] = arr.remove(largerIndex);
				arr.add(numI);
				i++;
				break;
			} else 
				arr.add(num[i]);
		}
		
		if (i >= 0) {
			while (arr.size() > 0) {
				num[i++] = arr.popMin();
			}
		} else {
			fillIntArr(arr, num);
		}
	}
	
	private void fillIntArr(SortedArray<Integer> arr, int[] result) {
		for (int i = 0; i < arr.size(); i++) {
			result[i] = arr.get(i);
		}
	}
	
	private Integer findMinimumLargerNumIndex(int target, SortedArray<Integer> arr, int start, int end) {
		if (start == end) {
			if (target < arr.get(start)) {
				return start;
			} else if (target > arr.get(start)) {
				return start + 1;
			} else {
				return start + 1;
			}
		}
		
		int mid = (start + end) / 2;
		if (target < arr.get(mid)) {
			return this.findMinimumLargerNumIndex(target, arr, start, Math.max(start, mid - 1));
		} else {
			return this.findMinimumLargerNumIndex(target, arr, Math.min(mid + 1, end), end);
		}
	}

	private class SortedArray<T extends Comparable<T>> {

		private ArrayList<T> list = new ArrayList<T>();

		public T min() {
			return list.get(0);
		}
		
		public T popMin() {
			return list.remove(0);
		}
		
		public T max() {
			return list.get(list.size() - 1);
		}
		
		public int size() {
			return list.size();
		}
		
		public T get(int index) {
			return list.get(index);
		}
		
		public T remove(int index) {
			return list.remove(index);
		}

		public void add(T t) {
			if (list.size() == 0) {
				list.add(t);
			} else {
				add(t, 0, list.size() - 1);
			}
		}

		private void add(T t, int start, int end) {
			if (start == end) {
				if (t.compareTo(list.get(start)) < 0) {
					list.add(start, t);
				} else if (t.compareTo(list.get(start)) > 0) {
					list.add(start + 1, t);
				} else {
					list.add(start + 1, t);
				}
			} else {
				int mid = (start + end) / 2;
				if (t.compareTo(list.get(mid)) < 0) {
					this.add(t, start, Math.max(start, mid - 1));
				} else if (t.compareTo(list.get(mid)) > 0) {
					this.add(t, Math.min(mid + 1, end), end);
				} else {
					list.add(mid + 1, t);
				}
			}
		}
	}
}
