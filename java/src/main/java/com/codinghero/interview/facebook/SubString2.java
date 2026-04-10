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
			prevResults = new SubString().handle(str, index, results, prevResults);
		}
		return results;
	}
}
