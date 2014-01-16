package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null)
			return null;
		Collections.sort(intervals, new IntervalComparator());
		ArrayList<Interval> result = new ArrayList<Interval>();
		merge(intervals, result, 0);
		return result;
	}
	
	private void merge(ArrayList<Interval> intervals, ArrayList<Interval> result, int startIndex) {
		if (startIndex >= intervals.size())
			return;
		Interval head = intervals.get(startIndex);
		int i = startIndex + 1;
		for (; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval == null || head.end < interval.start) {
				break;
			} else {
				head.end = Math.max(head.end, interval.end);
			}
		}
		result.add(head);
		merge(intervals, result, i);
	}
	
	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start)
				return 1;
			else if (o1.start == o2.start)
				return 0;
			else
				return -1;
		}
	}
}
