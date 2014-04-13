package com.codinghero.example.concurrent;

public class LinkedList {
	public synchronized void get() {
		for (long i = 0; i < 10000000000l; i++)
			;
		System.out.println("get");
	}
	
	public synchronized void add() {
		for (long i = 0; i < 1000l; i++)
			;
		System.out.println("add");
	}
}
