package com.codinghero.interview.google;

public class IncrementalIDGenerator {

	private static IncrementalIDGenerator instance = new IncrementalIDGenerator();

	private long id = 0;

	private IncrementalIDGenerator() {

	}

	public static IncrementalIDGenerator getInstance() {
		return instance;
	}

	public synchronized long get() {
		id++;
		return id;
	}
}
