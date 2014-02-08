package com.codinghero.interview.google;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Counter {
	
	private CircularArray<Long> arr = new CircularArray<Long>(1000 * 60 * 60 * 24);
	
	private Map<Long, Integer> cache = new HashMap<Long, Integer>();

	private static Object INCREMENT_SEMAPHORE = new Object();
	
	private long ONE_SECOND = 1000;
	private long ONE_MINUTE = ONE_SECOND * 60;
	private long ONE_HOUR = ONE_MINUTE * 60;
	private long ONE_DAY = ONE_HOUR * 60;
	
	
	public void increment() {
		long time = System.currentTimeMillis();
		long milliSecondZeroTime = setMilliSecond(time, 0);
		synchronized (INCREMENT_SEMAPHORE) {
			int index = arr.addLast(time);
			trySetIndex(milliSecondZeroTime, index);
		}
	}

	public int getCountInLastSecond() {
		long time = System.currentTimeMillis();
		long endTime = setMilliSecond(time, 0);
		long startTime = endTime - ONE_SECOND;
		return getCount(startTime, endTime);
	}

	public int getCountInLastMinute() {
		long time = System.currentTimeMillis();
		long endTime = setMilliSecond(time, 0);
		long startTime = endTime - ONE_MINUTE;
		return getCount(startTime, endTime);
	}

	public int getCountInLastHour() {
		long time = System.currentTimeMillis();
		long endTime = setMilliSecond(time, 0);
		long startTime = endTime - ONE_HOUR;
		return getCount(startTime, endTime);
	}

	public int getCountInLastDay() {
		long time = System.currentTimeMillis();
		long endTime = setMilliSecond(time, 0);
		long startTime = endTime - ONE_DAY;
		return getCount(startTime, endTime);
	}
	
	private int getCount(long startTime, long endTime) {
		Integer startIndex = cache.get(startTime);
		
		Integer endIndex = null;
		if (cache.get(endTime) == null) {
			synchronized (INCREMENT_SEMAPHORE) {
				if (cache.get(endTime) == null) {
					endIndex = arr.getTailIndex() + 1;
				} else {
					endIndex = cache.get(endTime);
				}
			}
		} else {
			endIndex = cache.get(endTime);
		}
		
		if (startIndex == null) {
			return 0;
		} else {
			return arr.subtractIndex(endIndex, startIndex);
		}
	}
	
	private void trySetIndex(long milliSecondZeroTime, int index) {
		if (!cache.containsKey(milliSecondZeroTime)) {
			cache.put(milliSecondZeroTime, index);
		}
	}
	
	private long setMilliSecond(long time, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}
}
