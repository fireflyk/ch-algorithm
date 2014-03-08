package com.codinghero.interview.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * loop to replace recursive
 * 
 * @author Tong Liu
 *
 */
public class SubString2 {
	public Set<String> getAll(String str) {
		Set<String> results = new HashSet<String>();
		results.add("");
		List<String> prevResults = new ArrayList<String>();
		
		for (int index = 0; index < str.length(); index++) {
			List<String> curResults = new ArrayList<String>();
			// add ("" + c)
			curResults.add(String.valueOf(str.charAt(index)));
			// add (prevSubString + c)
			for (String prevResult : prevResults) {
				curResults.add(prevResult + str.charAt(index));
			}
			results.addAll(curResults);
			prevResults = curResults;
		}
		return results;
	}
}
