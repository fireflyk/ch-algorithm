package com.codinghero.acm.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class WordLadder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start.equals(end)) {
			return 1;
		}
		@SuppressWarnings("unused")
		double times = Math.pow(26, start.length());

		Queue<String> queue = new ArrayDeque<String>();
		queue.add(start);

		int length = 1;
		while (!queue.isEmpty()) {
			length++;
			Queue<String> nextQueue = new ArrayDeque<String>();
			while (!queue.isEmpty()) {
				String curStart = queue.poll();
				if (diff(curStart, end) == 1) {
					return length;
				}

//				if (times > dict.size()) {
//					findDiff1Method2(curStart, dict, nextQueue);
//				} else {
					findDiff1Method1(curStart, dict, nextQueue);
//				}
			}
			queue = nextQueue;
		}

		return 0;
	}

	private void findDiff1Method1(String curStart, HashSet<String> dict, Queue<String> queue) {
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
					dict.remove(dictStr);

				}
				cArr[i] = temp;
			}
		}
	}

	@SuppressWarnings("unused")
	private void findDiff1Method2(String curStart, HashSet<String> dict, Queue<String> queue) {
		Iterator<String> iter = dict.iterator();
		while (iter.hasNext()) {
			String str = iter.next();
			if (diff(curStart, str) == 1) {
				queue.add(str);
				iter.remove();
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
