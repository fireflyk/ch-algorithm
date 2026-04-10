package com.codinghero.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		List<NumberWithIndex> list = transform(numbers);
		Collections.sort(list);
		int left = 0, right = list.size() - 1;
		while (true) {
			NumberWithIndex leftNwi = list.get(left);
			NumberWithIndex rightNwi = list.get(right);
			if (leftNwi.number + rightNwi.number < target) {
				left++;
			} else if (leftNwi.number + rightNwi.number > target) {
				right--;
			} else {
				result[0] = Math.min(leftNwi.index, rightNwi.index) + 1;
				result[1] = Math.max(leftNwi.index, rightNwi.index) + 1;
				break;
			}
		}

		return result;
	}

	/**
	 * transform the array to the specified list
	 * 
	 * @param numbers
	 * @return
	 */
	private List<NumberWithIndex> transform(int[] numbers) {
		List<NumberWithIndex> list = new ArrayList<NumberWithIndex>();
		for (int i = 0; i < numbers.length; i++) {
			NumberWithIndex nwi = new NumberWithIndex();
			nwi.number = numbers[i];
			nwi.index = i;
			list.add(nwi);
		}
		return list;
	}

	private class NumberWithIndex implements Comparable<NumberWithIndex> {
		private int number;
		private int index;

		public int compareTo(NumberWithIndex nwi) {
			if (number > nwi.number)
				return 1;
			else if (number < nwi.number)
				return -1;
			else
				return 0;
		}
	}
}
