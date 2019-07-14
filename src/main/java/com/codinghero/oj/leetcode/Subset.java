package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsets(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> result = subsets(arr, 0);
		List<Integer> newE = new ArrayList<Integer>();
		result.add(newE);
		return result;
	}

	private List<List<Integer>> subsets(int[] arr, int curIndex) {
		
		List<List<Integer>> curResult = new ArrayList<List<Integer>>();
		if (curIndex == arr.length - 1 || arr[curIndex] != arr[curIndex + 1]) {
			List<Integer> newE = new ArrayList<Integer>();
			newE.add(arr[curIndex]);
			curResult.add(newE);
		}

		if (curIndex == arr.length - 1)
			return curResult;

		List<List<Integer>> nextResult = subsets(arr, curIndex + 1);

		if (arr[curIndex] == arr[curIndex + 1]) {
			for (List<Integer> e : nextResult) {
				if (arr[curIndex] == e.get(0)) {
					List<Integer>  newE = new ArrayList<Integer>();
					newE.add(arr[curIndex]);
					newE.addAll(e);
					curResult.add(newE);
				}
			}
		} else {
			for (List<Integer> e : nextResult) {
				List<Integer>  newE = new ArrayList<Integer>();
				newE.add(arr[curIndex]);
				newE.addAll(e);
				curResult.add(newE);
			}
		}
		curResult.addAll(nextResult);

		return curResult;
	}
}
