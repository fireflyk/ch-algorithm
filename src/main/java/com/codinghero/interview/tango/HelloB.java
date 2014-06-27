package com.codinghero.interview.tango;

public class HelloB extends HelloA {
	public HelloB() {
		System.out.println("HelloB");
	}

	{
		System.out.println("Class B");
	}

	static {
		System.out.println("Static B");
	}

	public static void main(String[] args) {
		new HelloB();
	}
}
