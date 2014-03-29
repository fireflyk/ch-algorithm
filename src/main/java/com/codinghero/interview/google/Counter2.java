package com.codinghero.interview.google;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter2 {
	
	private Long initialTime; 
	
	private Map<Long, Integer> cache = new HashMap<Long, Integer>();
	
	private AtomicInteger size = new AtomicInteger(0);
	
	private Object putIndexMutex = new Object();
	
	private Object fillIndexMutex = new Object();
	
	private long ONE_SECOND = 1000;
	private long ONE_MINUTE = ONE_SECOND * 60;
	private long ONE_HOUR = ONE_MINUTE * 60;
	private long ONE_DAY = ONE_HOUR * 60;
	
	public Counter2() {
		initialTime = getSecondTime(System.currentTimeMillis());
		increment(initialTime);
	}
	
	public void increment() {
		increment(getSecondTime(System.currentTimeMillis()));
	}
	
	private void increment(long secondTime) {
		int index = size.incrementAndGet();
		put(secondTime, index);
	}

	public int getCountInLastSecond() {
		long time = System.currentTimeMillis();
		long endTime = getSecondTime(time);
		long startTime = endTime - ONE_SECOND;
		return getCount(startTime, endTime);
	}

	public int getCountInLastMinute() {
		long time = System.currentTimeMillis();
		long endTime = getSecondTime(time);
		long startTime = endTime - ONE_MINUTE;
		return getCount(startTime, endTime);
	}

	public int getCountInLastHour() {
		long time = System.currentTimeMillis();
		long endTime = getSecondTime(time);
		long startTime = endTime - ONE_HOUR;
		return getCount(startTime, endTime);
	}

	public int getCountInLastDay() {
		long time = System.currentTimeMillis();
		long endTime = getSecondTime(time);
		long startTime = endTime - ONE_DAY;
		return getCount(startTime, endTime);
	}
	
	private int getCount(long startTime, long endTime) {
		return get(endTime) - get(startTime);
	}
	
	/**
	 * get index of second time
	 * 
	 * @param secondTime
	 * @return
	 */
	private int get(long secondTime) {
		if (!cache.containsKey(secondTime)) {
			synchronized (fillIndexMutex) {
				if (!cache.containsKey(secondTime)) {
					fillIndex(secondTime);
				}
			}
		}
		return cache.get(secondTime);
	}
	
	/**
	 * put index of second time
	 * 
	 * @param secondTime
	 * @param index
	 */
	private void put(long secondTime, int index) {
		// put
		if (!cache.containsKey(secondTime)) {
			synchronized (putIndexMutex) {
				if (!cache.containsKey(secondTime)) {
					// record this second time index
					cache.put(secondTime, index);
				}
			}
		}
		// fill previous
		if (!cache.containsKey(secondTime - ONE_SECOND)) {
			synchronized (fillIndexMutex) {
				if (!cache.containsKey(secondTime - ONE_SECOND)) {
					fillIndex(secondTime - ONE_SECOND);
				}
			}
		}
	}
	
	/**
	 * fill index of previous time
	 * 
	 * @param endTime
	 */
	private void fillIndex(final long endTime) {
		// find previous second time index
		long startTime = endTime;
		while (!cache.containsKey(startTime)) {
			startTime -= ONE_SECOND;
		}
		
		// fill index (startTime, endTime]
		int previousIndex = cache.get(startTime);
		for (long tempTime = endTime; startTime < tempTime; tempTime -= ONE_SECOND) {
			cache.put(tempTime, previousIndex);
		}
	}
	
	private long getSecondTime(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}
}
