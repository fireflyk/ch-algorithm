package com.codinghero.interview.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * handle firstly, then execute recursively
 * 
 * @author Tong Liu
 * 
 */
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
		getAll(str, index + 1, results, handle(str, index, results, prevResults));
	}
	
	List<String> handle(String str, int index, Set<String> results, List<String> prevResults) {
		List<String> curResults = new ArrayList<String>();
		// add ("" + c)
		curResults.add(String.valueOf(str.charAt(index)));
		// add (prevSubString + c)
		for (String prevResult : prevResults) {
			curResults.add(prevResult + str.charAt(index));
		}
		results.addAll(curResults);
		return curResults;
	}
}
