package com.codinghero.interview.tango;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
	public void removeDuplicate(Integer[] arr) {
		if (arr == null)
			throw new NullPointerException();

		int leftMove = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				leftMove++;
			} else if (!set.contains(arr[i])) {
				set.add(arr[i]);
				if (leftMove > 0) {
					arr[i - leftMove] = arr[i];
					arr[i] = null;
				}
			} else {
				arr[i] = null;
				leftMove++;
			}
		}
	}

}
