package com.codinghero.interview.tango;

import java.util.ArrayList;
import java.util.List;

public class Output1And2 {

	private Object add1 = new Object();
	private Object add2 = new Object();
	
	private Object tail1 = new Object();
	private Object tail2 = new Object();
	
	private List<Integer> list = new ArrayList<Integer>();

	public void output1() throws InterruptedException {
		synchronized (add1) {
			synchronized (tail2) {
				if (!list.isEmpty() && list.get(list.size() - 1) == 1) {
					tail2.wait();
				}
			}
			synchronized (tail1) {
				list.add(1);
				tail1.notify();
			}
		}
	}

	public void output2() throws InterruptedException {
		synchronized (add2) {
			synchronized (tail1) {
				if (list.isEmpty() || list.get(list.size() - 1) == 2) {
					tail1.wait();
				}
			}
			synchronized (tail2) {
				list.add(2);
				tail2.notify();
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
