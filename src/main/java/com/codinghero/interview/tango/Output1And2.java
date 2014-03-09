package com.codinghero.interview.tango;

import java.util.ArrayList;
import java.util.List;

public class Output1And2 {

	private Object add1Lock = new Object();

	private Object add2Lock = new Object();
	
	private List<Integer> list = new ArrayList<Integer>();

	public void output1() throws InterruptedException {
		synchronized (add2Lock) {
			if (list.isEmpty() || list.get(list.size() - 1) == 2) {
				list.add(1);
				add2Lock.notify();
				return;
			}
		}
		synchronized (add1Lock) {
			if (!list.isEmpty() && list.get(list.size() - 1) == 1) {
				add1Lock.wait();
				list.add(1);
			}
		}
	}

	public void output2() throws InterruptedException {
		synchronized (add1Lock) {
			if (!list.isEmpty() && list.get(list.size() - 1) == 1) {
				list.add(2);
				add1Lock.notify();
				return;
			}
		}
		synchronized (add2Lock) {
			if (list.isEmpty() || list.get(list.size() - 1) == 2) {
				add2Lock.wait();
				list.add(2);
			}
		}
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
}
