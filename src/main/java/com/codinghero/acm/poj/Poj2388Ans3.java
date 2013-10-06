package com.codinghero.acm.poj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poj2388Ans3 {

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
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			list.add(cin.nextInt());
		sort(list);
		System.out.println(list.get((list.size() - 1) / 2));
	}

}
