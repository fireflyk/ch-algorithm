package com.codinghero.example.concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class LockFreeCounter {
	
	private AtomicLong value;

	public long get() {
		return value.longValue();
	}

	public long incrementAndGet() {
		long v;
		do {
			v = value.longValue();
		} while (!value.compareAndSet(v, v + 1));
		return v + 1;
	}

	public long incrementAndGet2() {
		long v = value.longValue();
		while (!value.compareAndSet(v, v + 1)) {
			v = value.longValue();
		}
		return v + 1;
	}

	public long incrementAndGet3() {
		for (;;) {
			long v = value.longValue();
			if (value.compareAndSet(v, v + 1)) {
				return v + 1;
			}
		}
	}
}
