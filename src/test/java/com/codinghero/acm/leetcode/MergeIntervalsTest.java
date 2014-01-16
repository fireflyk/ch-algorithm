package com.codinghero.acm.leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class MergeIntervalsTest {

	@Test
	public void test1() {
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(3,6);
		Interval i3 = new Interval(4,5);
		Interval i4 = new Interval(11,18);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		
		Interval r1 = new Interval(1,6);
		Interval r2 = new Interval(11,18);
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add(r1);
		result.add(r2);
		Assert.assertEquals(result, new MergeIntervals().merge(intervals));
	}


	@Test
	public void test2() {
		Assert.assertEquals(null, new MergeIntervals().merge(null));
		Assert.assertEquals(new ArrayList<Interval>(), new MergeIntervals().merge(new ArrayList<Interval>()));
		
		Interval i1 = new Interval(1,3);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		Assert.assertEquals(intervals, new MergeIntervals().merge(intervals));
	}
}
