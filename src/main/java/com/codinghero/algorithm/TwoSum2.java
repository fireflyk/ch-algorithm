package com.codinghero.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Average time complexity: O(nlogn)<br/>
 * Worst time complexity: O(n^2) 
 * 
 * @author Tong Liu
 *
 */
public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		List<NumberWithIndex> list = transform(numbers);
		Collections.sort(list);
		int left = 0, right = list.size() - 1;
		while (left < right) {
			// less than the target
			if (list.get(left).number + list.get(right).number < target) {
				int lastLeft = left;
				left = (left + right) / 2;
				while (list.get(left).number + list.get(right).number < target) {
					lastLeft = left;
					left = (left + right) / 2;
				}
				left = lastLeft + 1;
			}
			// greater than the target
			else if (list.get(left).number + list.get(right).number > target) {
				int lastRight = right;
				right = (left + right) / 2;
				while (list.get(left).number + list.get(right).number > target) {
					lastRight = right;
					right = (left + right) / 2;
				}
				right = lastRight - 1;
			}
			// equals to the target
			else {
				result[0] = Math.min(list.get(left).index, list.get(right).index) + 1;
				result[1] = Math.max(list.get(left).index, list.get(right).index) + 1;
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
