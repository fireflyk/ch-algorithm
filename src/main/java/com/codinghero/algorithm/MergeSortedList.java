package com.codinghero.algorithm;

import java.util.List;

public class MergeSortedList {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T extends Comparable> void merge(List<T> list1, List<T> list2) {
		int i = 0, j = 0;
		while (i < list1.size()) {
			if ((list1.get(i).compareTo(list2.get(j)) > 0)) {
				swap(list1, i, list2, j);
				rightMove(list2, j);
				i++;
			} else {
				i++;
			}
		}
	}
	
	private <T> void swap(List<T> list1, int index1, List<T> list2, int index2) {
		T temp = list1.get(index1);
		list1.set(index1, list2.get(index2));
		list2.set(index2, temp);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T extends Comparable> void rightMove(List<T> list, int index) {
		T t = list.get(index);
		int i = index + 1;
		while (i < list.size()) {
			// swap
			if (t.compareTo(list.get(i)) > 0) {
				list.set(i - 1, list.get(i));
				i++;
			}
			// right move in the correct position
			else {
				list.set(i - 1, t);
				return;
			}
		}
		
		// right move in the right most position
		list.set(i - 1, t);
		return;
	}
}
