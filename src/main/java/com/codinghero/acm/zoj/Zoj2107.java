package com.codinghero.acm.zoj;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

/**
 * Runtime Error
 * 
 * @author liutong01
 *
 */
public class Zoj2107 {

	private static Scanner cin = new Scanner(new BufferedInputStream(System.in));
	
	public static void main(String[] args) {
		while (true) {
			int N = cin.nextInt();
			if (N == 0)
				break;
			Node[] nodes = handleInput(N);
			Arrays.sort(nodes, new XComparator());
			Node[] yNodes = createYNodes(nodes);
			Double min = findMin(nodes, yNodes, 0, N - 1) / 2;
			System.out.println(new BigDecimal(min.toString()).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
	}

	private static Node[] handleInput(int size) {
		Node[] nodes = new Node[size];
		for (int i = 0; i < size; i++)
			nodes[i] = new Node(cin.next(), cin.next());
		return nodes;
	}
	
	private static Node[] createYNodes(Node[] nodes) {
		Node[] yNodes = new Node[nodes.length];
		System.arraycopy(nodes, 0, yNodes, 0, nodes.length);
		Arrays.sort(yNodes, new YComparator());
		return yNodes;
	}
	
	public static double findMin(Node[] nodes, Node[] yNodes, int start, int end) {
		if(start >= end)
			throw new RuntimeException("There is just one node");
		else if (start + 1 == end)
			return distance(nodes[start], nodes[end]);
		else if (start + 2 == end) {
			double d0 = distance(nodes[start], nodes[start + 1]);
			double d1 = distance(nodes[start], nodes[end]);
			double d2 = distance(nodes[start + 1], nodes[end]);
			return min(d0, d1, d2);
		} else {
			int pivotIndex = (start + end) >> 1;
			partition(yNodes, nodes[pivotIndex].x, start, pivotIndex, end);
			Node[] tempYNodes = new Node[yNodes.length];
			System.arraycopy(yNodes, 0, tempYNodes, 0, yNodes.length);
			
			double d0 = findMin(nodes, tempYNodes, start, pivotIndex);
			double d1 = findMin(nodes, tempYNodes, pivotIndex + 1, end);
			double d = min(d0, d1);
			return calMinDistBetweenTwoParts(yNodes, nodes[pivotIndex].x, start, end, new BigDecimal(String.valueOf(d)));
		}
	}
	
	private static void partition(Node[] yNodes, BigDecimal pivot, int start, int pivotIndex, int end) {
		for (int i = 0, j = pivotIndex; i <= pivotIndex && j <= end;) {
			if (yNodes[i].x.compareTo(pivot) > 0
					&& yNodes[j].x.compareTo(pivot) <= 0) {
				swap(yNodes, i, j);
				i++;
				j++;
			} else if(yNodes[i].x.compareTo(pivot) <= 0) {
				i++;
			} else if (yNodes[j].x.compareTo(pivot) > 0) {
				j++;
			}
		}
	}
	
	private static double calMinDistBetweenTwoParts(Node[] yNodes, BigDecimal pivot, int start, int end, BigDecimal min) {
		Node[] leftNodes = new Node[yNodes.length];
		Node[] rightNodes = new Node[yNodes.length];
		BigDecimal zero = new BigDecimal("0");
		for (int i = start, l = 0, r = 0; i <= end; i++) {
			// left side && less than min
			if (pivot.subtract(yNodes[i].x).compareTo(zero) >= 0
					&& pivot.subtract(yNodes[i].x).compareTo(min) < 0) {
				leftNodes[l++] = yNodes[i];
			} 
			// right side && less than min
			else if (yNodes[i].x.subtract(pivot).compareTo(zero) > 0
					&& yNodes[i].x.subtract(pivot).compareTo(min) < 0) {
				rightNodes[r++] = yNodes[i];
			}
		}
		
		double dmin = min.doubleValue();
		for (int l = 0, r = 0; l < leftNodes.length && r < rightNodes.length;) {
			Node left = leftNodes[l];
			Node right = rightNodes[r];
			if (left == null || right == null)
				break;
			BigDecimal yDistance = left.y.subtract(right.y).abs();
			if (yDistance.compareTo(min) > 0) {
				r++;
				if (r == rightNodes.length || rightNodes[r] == null) {
					r--;
					l++;
				}
			} else if (yDistance.compareTo(min) > 0) {
				l++;
			} else {
				int tempR = r;
				while (yDistance.compareTo(min) <= 0 && tempR - r <= 5) {
					// System.out.println(l + "," + tempR);
					double distance = distance(left, rightNodes[tempR]);
					if (distance < dmin)
						dmin = distance;
					tempR++;
					if (tempR == rightNodes.length || rightNodes[tempR] == null)
						break;
					yDistance = left.y.subtract(rightNodes[tempR].y).abs();
				}
				l++;
			}
		}
		return dmin;
	}
	
	private static void swap(Node[] nodes, int index1, int index2) {
		Node temp = nodes[index1];
		nodes[index1] = nodes[index2];
		nodes[index2] = temp;
	}
	
	private static double distance(Node n1, Node n2) {
		BigDecimal diffX = n1.x.subtract(n2.x);
		BigDecimal diffY = n1.y.subtract(n2.y);
		BigDecimal sqrSum = 
			diffX.multiply(diffX)
				.add(
			diffY.multiply(diffY)
				);
		return Math.sqrt(sqrSum.doubleValue());
	}

	private static double min(double d0, double d1) {
		if (d0 < d1)
			return d0;
		else
			return d1;
	}
	
	private static double min(double d0, double d1, double d2) {
		double min;
		int minIndex;
		if (d0 <= d1) {
			if (d0 <= d2) {
				min = d0;
				minIndex = 0;
			} else {
				min = d2;
				minIndex = 2;
			}
		} else {
			if (d1 <= d2) {
				min = d1;
				minIndex = 1;
			} else {
				min = d2;
				minIndex = 2;
			}
		}
		// return min to show the minimum distance
		// return Object[] to show the minimum index
		Object[] result = new Object[2];
		result[0] = min;
		result[1] = minIndex;
		return min;
	}
	
	private static class Node {
		private BigDecimal x;
		private BigDecimal y;
		
		public Node(String x, String y) {
			this.x = new BigDecimal(x);
			this.y = new BigDecimal(y);
		}
	}
	
	private static class XComparator implements Comparator<Node> {

		public int compare(Node o1, Node o2) {
			return o1.x.compareTo(o2.x);
		}
		
	}
	
	private static class YComparator implements Comparator<Node> {

		public int compare(Node o1, Node o2) {
			return o1.y.compareTo(o2.y);
		}
		
	}
	
//	@Test
//	public void test() {
//		Random r = new Random();
//		int TEST_TIMES = 1, N = 100000;
//		for (int i = 0; i < TEST_TIMES; i++) {
//			// System.out.println(N);
//			Node[] nodes = new Node[N];
//			for (int j = 0; j < N; j++) {
//				String x = String.valueOf(r.nextDouble() * 1000);
//				String y = String.valueOf(r.nextDouble() * 1000);
//				System.out.println(x + " " + y);
//				nodes[j] = new Node(x, y);
//			}
//			Arrays.sort(nodes, new XComparator());
//			Node[] yNodes = createYNodes(nodes);
//			Double min = findMin(nodes, yNodes, 0, N - 1) / 2;
//			System.out.println(new BigDecimal(min.toString()).setScale(2, BigDecimal.ROUND_HALF_UP));
//		}
//	}
}
