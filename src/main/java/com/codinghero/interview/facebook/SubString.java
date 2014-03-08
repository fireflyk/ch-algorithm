package com.codinghero.interview.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubString {

	public Set<String> getAll(String str) {
		Set<String> results = new HashSet<String>();
		List<String> prevResults = new ArrayList<String>();
		results.add("");
		
		getAll(str, 0, results, prevResults);
		return results;
	}

	private void getAll(String str, int index, Set<String> results, List<String> prevResults) {
		if (index == str.length())
			return;
		List<String> curResults = new ArrayList<String>();
		curResults.add(String.valueOf(str.charAt(index)));
		results.add(String.valueOf(str.charAt(index)));
		for (String prevResult : prevResults) {
			curResults.add(prevResult + str.charAt(index));
			results.add(prevResult + str.charAt(index));
		}
		getAll(str, index + 1, results, curResults);
	}
}
