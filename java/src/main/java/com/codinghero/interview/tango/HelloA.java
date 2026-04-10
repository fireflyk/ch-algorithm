package com.codinghero.interview.tango;

class HelloA {
	public HelloA() {
		System.out.println("HelloA");
	}

	{
		System.out.println("Class A");
	}

	static {
		System.out.println("Static A");
	}
}
