package com.codinghero.oj.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class WordLadderII {

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		HashMap<String, ArrayList<ArrayList<String>>> paths = new HashMap<String, ArrayList<ArrayList<String>>>();
		ArrayList<ArrayList<String>> curPaths = new ArrayList<ArrayList<String>>();
		paths.put(end, curPaths);
		// special case
		if (start.equals(end)) {
			ArrayList<String> curPath = new ArrayList<String>();
			curPath.add(start);
			curPaths.add(curPath);
			return curPaths;
		}
		
		double times = 26 * start.length();
		Queue<String> queue = new ArrayDeque<String>();
		queue.add(start);
		boolean flag = false;
		while (!queue.isEmpty()) {
			// remove the visited word in dict
			Iterator<String> iter = queue.iterator();
			while(iter.hasNext()) {
				dict.remove(iter.next());
			}
			// find path
			Queue<String> nextQueue = new ArrayDeque<String>();
			while (!queue.isEmpty()) {
				String curStart = queue.poll();
				if (diff(curStart, end) == 1) {
					flag = true;
					addPath(curStart, end, paths);
				} else if (times > dict.size()) {
					findDiff1Method2(curStart, dict, nextQueue, paths);
				} else {
					findDiff1Method1(curStart, dict, nextQueue, paths);
				}
			}
			if (flag)
				break;
			queue = nextQueue;
		}

		return paths.get(end);
	}
	
	private void addPath(String from, String to, HashMap<String, ArrayList<ArrayList<String>>> paths) {
		ArrayList<ArrayList<String>> curPaths = paths.get(to);
		// not null, if 'to' is visited more than once
		if (curPaths == null) {
			curPaths = new ArrayList<ArrayList<String>>();
			paths.put(to, curPaths);
		}

		ArrayList<ArrayList<String>> prevPaths = paths.get(from);
		// null, if 'from' is in 1st level
		if (prevPaths == null) {
			ArrayList<String> curPath = new ArrayList<String>();
			curPath.add(from);
			curPath.add(to);
			curPaths.add(curPath);
		}
		// not null, if 'from' in other level
		else {
			for (ArrayList<String> prevPath : prevPaths) {
				ArrayList<String> curPath = new ArrayList<String>(prevPath);
				curPath.add(to);
				curPaths.add(curPath);
			}
		}
	}

	private void findDiff1Method1(String curStart, HashSet<String> dict, Queue<String> queue, HashMap<String, ArrayList<ArrayList<String>>> paths) {
		char[] cArr = curStart.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (cArr[i] == c)
					continue;
				char temp = cArr[i];
				cArr[i] = c;
				String dictStr = String.valueOf(cArr);
				if (dict.contains(dictStr)) {
					if (!paths.containsKey(dictStr))
						queue.add(dictStr);
					addPath(curStart, dictStr, paths);
				}
				cArr[i] = temp;
			}
		}
	}

	private void findDiff1Method2(String curStart, HashSet<String> dict, Queue<String> queue, HashMap<String, ArrayList<ArrayList<String>>> paths) {
		Iterator<String> iter = dict.iterator();
		while (iter.hasNext()) {
			String dictStr = iter.next();
			if (diff(curStart, dictStr) == 1) {
				if (!paths.containsKey(dictStr))
					queue.add(dictStr);
				addPath(curStart, dictStr, paths);
			}
		}
	}

	private int diff(String str1, String str2) {
		char[] cArr1 = str1.toCharArray();
		char[] cArr2 = str2.toCharArray();
		int diff = 0;
		for (int i = 0; i < cArr1.length; i++) {
			if (cArr1[i] != cArr2[i])
				diff++;
		}
		return diff;
	}
}
