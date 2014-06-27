package com.codinghero.interview.tango;

import java.util.Arrays;
import java.util.List;

public class MinHeap {
	private Integer[] data;
	private int capacity;
	private int size;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		data = new Integer[capacity];
	}

	public void add(int num) {
		data[size] = num;
		int i = size++;
		while (i > 0) {
			int pi = getParentIndex(i);
			if (data[pi] > data[i]) {
				swap(pi, i);
				i = pi;
			} else {
				break;
			}
		}
	}

	public void replacePeek(int num) {
		data[0] = num;
		int i = 0;
		while (getLeftSonIndex(i) < size) {
			int li = getLeftSonIndex(i);
			int ri = li + 1;
			// right not exsits or left is smaller than right
			if (ri >= size || data[li] < data[ri]) {
				// left is smaller than parent
				if (data[li] < data[i]) {
					swap(li, i);
					i = li;
				}
				// swap end
				else {
					break;
				}
			}
			// right is smaller or equal than left
			else {
				// right is smaller than parent
				if (data[ri] < data[i]) {
					swap(ri, i);
					i = ri;
				}
				// swap end
				else {
					break;
				}
			}
		}
	}

	public boolean isFull() {
		return size == capacity;
	}

	public Integer peek() {
		return data[0];
	}

	public List<Integer> list() {
		return Arrays.asList(data);
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private int getLeftSonIndex(int index) {
		return 2 * index + 1;
	}

	private void swap(int i, int j) {
		Integer temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
