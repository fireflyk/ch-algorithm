package com.codinghero.algorithm;

import java.util.List;

public class QuickSort {
	// public static <T> void sort(T[] arr) {
	// Arrays.sort(arr);
	// }
	//
	// public static <T extends Comparable<? super T>> void sort(List<T> list) {
	// Collections.sort(list);
	// }

	public static <T extends Comparable<? super T>> void sort(List<T> list) {
		sort(list, 0, list.size() - 1);
	}

	private static <T extends Comparable<? super T>> void sort(List<T> list,
			int start, int end) {
		if (start < end) {
			int pivotLoc = sortPartition(list, start, end);
			sort(list, start, pivotLoc - 1);
			sort(list, pivotLoc + 1, end);
		}
	}

	private static <T extends Comparable<? super T>> int sortPartition(
			List<T> list, int start, int end) {
		T pivotVal = list.get(start);
		while (start < end) {
			if (list.get(start).compareTo(list.get(end)) > 0) {
				T t = list.get(start);
				list.set(start, list.get(end));
				list.set(end, t);
			}
			if (pivotVal.compareTo(list.get(end)) < 0) {
				--end;
			} else {
				++start;
			}
		}
		return start;
	}
}
