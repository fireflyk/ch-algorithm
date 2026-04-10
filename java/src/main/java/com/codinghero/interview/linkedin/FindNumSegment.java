package com.codinghero.interview.linkedin;

public class FindNumSegment {
	
	public Segment find(int[] arr, int num) {
		if (arr == null || arr.length == 0)
			return null;
		
		Integer start = findStart(arr, num, 0, arr.length - 1);
		if (start == null)
			return null;
		
		Segment segment = new Segment();
		segment.startIndex = start;
		segment.endIndex = findEnd(arr, num, start, arr.length - 1);
		
		return segment;
	}
	
	private Integer findStart(int[] arr, int num, int start, int end) {
		if (start > end)
			return null;
		
		int mid = (start + end) / 2;
		if (arr[mid] == num && (mid == 0 || arr[mid - 1] < num)) {
			return mid;
		} else if (arr[mid] < num) {
			return findStart(arr, num, mid + 1, end);
		} else {
			return findStart(arr, num, start, mid - 1);
		}
	}
	
	private Integer findEnd(int[] arr, int num, int start, int end) {
		if (start > end)
			return null;
		
		int mid = (start + end) / 2;
		if (arr[mid] == num && (mid == arr.length - 1 || arr[mid + 1] > num)) {
			return mid;
		} else if (arr[mid] <= num) {
			return findEnd(arr, num, mid + 1, end);
		} else {
			return findEnd(arr, num, start, mid - 1);
		}
	}
	
	public class Segment {
		private int startIndex;
		private int endIndex;
		public int getStartIndex() {
			return startIndex;
		}
		public int getEndIndex() {
			return endIndex;
		}
		
	}
}
