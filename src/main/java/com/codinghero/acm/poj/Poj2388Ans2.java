package com.codinghero.acm.poj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poj2388Ans2 {

	private static int findKth(List<Integer> list, int k) {
		return findKth(list, 0, list.size() - 1, k);
	}

	private static int findKth(List<Integer> list, int start, int end, int k) {
		int pivotIndex = sortTwoPartition(list, start, end);
		int leftLength = pivotIndex - start + 1;
		if (k == leftLength)
			return list.get(pivotIndex);
		else if (k < leftLength) {
			return findKth(list, start, pivotIndex - 1, k);
		} else {
			return findKth(list, pivotIndex + 1, end, k - leftLength);
		}
	}

	private static int sortTwoPartition(List<Integer> list, int start, int end) {
		int pivot = list.get(start);
		int i = start, j = end;
		while (i != j) {
			if (list.get(i) > list.get(j)) {
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			if (list.get(i) == pivot)
				j--;
			else
				i++;
		}
		return i;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			list.add(cin.nextInt());
		System.out.println(findKth(list, (list.size() + 1) / 2));
	}

}
