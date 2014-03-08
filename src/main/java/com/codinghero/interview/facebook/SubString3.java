package com.codinghero.interview.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * execute recursively firstly, then handle
 * 
 * @author Tong Liu
 * 
 */
public class SubString3 {

	public Set<String> getAll(String str) {
		Set<String> results = new HashSet<String>();
		results.add("");

		getAll(str, str.length() - 1, results);
		return results;
	}

	private List<String> getAll(String str, int index, Set<String> results) {
		if (index == -1) {
			return new ArrayList<String>();
		}
		return new SubString().handle(str, index, results, getAll(str, index - 1, results));
	}
}
