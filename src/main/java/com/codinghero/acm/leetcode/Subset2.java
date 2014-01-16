package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] arr) {
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> result = subsets(arr, 0);
		ArrayList<Integer> newE = new ArrayList<Integer>();
		result.add(newE);
		return result;
	}

	private ArrayList<ArrayList<Integer>> subsets(int[] arr, int curIndex) {
		
		ArrayList<ArrayList<Integer>> curResult = new ArrayList<ArrayList<Integer>>();
		if (curIndex == arr.length - 1 || arr[curIndex] != arr[curIndex + 1]) {
			ArrayList<Integer> newE = new ArrayList<Integer>();
			newE.add(arr[curIndex]);
			curResult.add(newE);
		}

		if (curIndex == arr.length - 1)
			return curResult;

		ArrayList<ArrayList<Integer>> nextResult = subsets(arr, curIndex + 1);

		if (arr[curIndex] == arr[curIndex + 1]) {
			for (ArrayList<Integer> e : nextResult) {
				if (arr[curIndex] == e.get(0)) {
					ArrayList<Integer>  newE = new ArrayList<Integer>();
					newE.add(arr[curIndex]);
					newE.addAll(e);
					curResult.add(newE);
				}
			}
		} else {
			for (ArrayList<Integer> e : nextResult) {
				ArrayList<Integer>  newE = new ArrayList<Integer>();
				newE.add(arr[curIndex]);
				newE.addAll(e);
				curResult.add(newE);
			}
		}
		curResult.addAll(nextResult);

		return curResult;
	}
}
