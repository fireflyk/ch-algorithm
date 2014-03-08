package com.codinghero.interview.facebook;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {
	public Set<String> getAll(String str) {
		return getAll(str, 0);
	}

	private Set<String> getAll(String str, int start) {
		if (start == str.length() - 1) {
			Set<String> results = new HashSet<String>();
			results.add(String.valueOf(str.charAt(start)));
			return results;
		}
		Set<String> prevResults = getAll(str, start + 1);
		Set<String> curResults = new HashSet<String>();
		for (String prevResult : prevResults) {
			for (int j = 0; j <= prevResult.length(); j++) {
				curResults.add(prevResult.substring(0, j) + str.charAt(start)
						+ prevResult.substring(j, prevResult.length()));
			}
		}
		
		return curResults;
	}
}
