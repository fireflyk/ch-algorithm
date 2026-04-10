package com.codinghero.oj.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderII {

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		
		HashMap<String, ArrayList<String>> paths = new HashMap<String, ArrayList<String>>();
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start.equals(end)) {
			ArrayList<String> path = new ArrayList<String>();
			path.add(start);
			result.add(path);
			return result;
		}
		
		double times = 26 * start.length();
		Queue<String> queue = new ArrayDeque<String>();
		queue.add(start);

		boolean flag = false;
		while (!queue.isEmpty()) {
			Queue<String> nextQueue = new ArrayDeque<String>();
			while (!queue.isEmpty()) {
				// remove the word in dict
				Iterator<String> iter = queue.iterator();
				while(iter.hasNext()) {
					dict.remove(iter.next());
				}
				// find path
				String curStart = queue.poll();
				if (diff(curStart, end) == 1) {
					flag = true;
					addPath(end, curStart, paths);
//					// get reversed path
//					Stack<String> stack = new Stack<String>();
//					stack.add(end);
//					stack.add(curStart);
//					String prev = curStart;
//					while ((prev = paths.get(prev)) != null) {
//						stack.add(prev);
//					}
//					// get path
//					ArrayList<String> path = new ArrayList<String>();
//					while(!stack.isEmpty()) {
//						path.add(stack.pop());
//					}
//					// add to result
//					result.add(path);
				} else if (times > dict.size()) {
					findDiff1Method2(curStart, dict, nextQueue, paths);
				} else {
					findDiff1Method1(curStart, dict, nextQueue, paths);
				}
			}
			if (flag) {
				getPaths(paths, end, new LinkedList<String>(), result);
				break;
			}
			queue = nextQueue;
		}
		return result;
	}

	private void findDiff1Method1(String curStart, HashSet<String> dict, Queue<String> queue, HashMap<String, ArrayList<String>> paths) {
		char[] cArr = curStart.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (cArr[i] == c)
					continue;
				char temp = cArr[i];
				cArr[i] = c;
				String dictStr = String.valueOf(cArr);
				if (dict.contains(dictStr)) {
					queue.add(dictStr);
					addPath(dictStr, curStart, paths);
				}
				cArr[i] = temp;
			}
		}
	}

	private void findDiff1Method2(String curStart, HashSet<String> dict, Queue<String> queue, HashMap<String, ArrayList<String>> paths) {
		Iterator<String> iter = dict.iterator();
		while (iter.hasNext()) {
			String dictStr = iter.next();
			if (diff(curStart, dictStr) == 1) {
				queue.add(dictStr);
				addPath(dictStr, curStart, paths);
			}
		}
	}
	
	private void addPath(String from, String to, HashMap<String, ArrayList<String>> paths) {
		ArrayList<String> path = paths.get(from);
		if (path == null) {
			path = new ArrayList<String>();
			paths.put(from, path);
		}
		path.add(to);
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
	
	private void getPaths(HashMap<String, ArrayList<String>> paths, String from, LinkedList<String> prevPath, ArrayList<ArrayList<String>> result) {
		ArrayList<String> path = paths.get(from);
		prevPath.addFirst(from);
		if (path == null) {
			result.add(new ArrayList<String>(prevPath));
			return;
		} else {
			for (String to : path) {
				getPaths(paths, to, prevPath, result);
			}
		}
		prevPath.removeFirst();
	}
}
