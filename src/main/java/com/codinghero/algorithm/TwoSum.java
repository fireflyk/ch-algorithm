package com.codinghero.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		List<NumberWithIndex> list = transform(numbers);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			NumberWithIndex nwi = list.get(i);
			if (nwi.number * 2 > target) {
				break;
			}
			NumberWithIndex another = new NumberWithIndex();
			another.number = target - nwi.number;
			List<NumberWithIndex> subList = list.subList(i + 1, list.size());
			int anotherIndex = Collections.binarySearch(subList, another);
			if (anotherIndex < 0)
				continue;
			else {
				anotherIndex += (i + 1);
				result[0] = Math.min(nwi.index, list.get(anotherIndex).index) + 1;
				result[1] = Math.max(nwi.index, list.get(anotherIndex).index) + 1;
				break;
			}
		}

		return result;
	}

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
