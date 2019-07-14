package com.codinghero.oj.poj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * find the minimum distance between 2 node
 * 
 * @author liutong01
 * 
 */
public class Poj3714 {

	private static Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = cin.nextInt();
		while (N > 0) {
			for (int i = 0; i < N; i++) {
				int size = cin.nextInt();
				ArrayList<Node> nodes = handleInput(size);
				Collections.sort(nodes, new XComparator());
				ArrayList<Node> yNodes = createYNodes(nodes);
				System.out.println(findMin(nodes, yNodes, 0, N - 1));
			}
			N = cin.nextInt();
		}
	}

	private static ArrayList<Node> handleInput(int size) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < size; i++) {
			nodes.set(i, new Node(cin.next(), cin.next()));
		}
		return nodes;
	}
	
	private static ArrayList<Node> createYNodes(ArrayList<Node> nodes) {
		ArrayList<Node> yNodes = new ArrayList<Node>(nodes);
		Collections.sort(yNodes, new YComparator());
		return yNodes;
	}
	
	private static double findMin(ArrayList<Node> nodes, ArrayList<Node> yNodes, int start, int end) {
		if(start >= end)
			throw new RuntimeException("There is just one node");
		else if (start + 1 == end)
			return distance(nodes.get(start), nodes.get(end));
		else if (start + 2 == end) {
			double d0 = distance(nodes.get(start), nodes.get(start + 1));
			double d1 = distance(nodes.get(start), nodes.get(end));
			double d2 = distance(nodes.get(start + 1), nodes.get(end));
			return min(d0, d1, d2);
		} else {
			int pivotIndex = (start + end) / 2;
			partition(yNodes, nodes.get(pivotIndex).x, start, pivotIndex, end);
			ArrayList<Node> tempYNodes = new ArrayList<Node>(yNodes);
			
			double d0 = findMin(nodes, tempYNodes, start, pivotIndex);
			double d1 = findMin(nodes, tempYNodes, pivotIndex + 1, end);
			double d = min(d0, d1);
			return calMinDistBetweenTwoParts(yNodes, nodes.get(pivotIndex).x, start, end, new BigDecimal(String.valueOf(d)));
		}
	}
	
	private static void partition(ArrayList<Node> yNodes, BigDecimal pivot, int start, int pivotIndex, int end) {
		for (int i = 0, j = pivotIndex; i <= pivotIndex && j <= end;) {
			if (yNodes.get(i).x.compareTo(pivot) > 0
					&& yNodes.get(j).x.compareTo(pivot) <= 0) {
				swap(yNodes, i, j);
				i++;
				j++;
			} else if(yNodes.get(i).x.compareTo(pivot) <= 0) {
				i++;
			} else if (yNodes.get(j).x.compareTo(pivot) > 0) {
				j++;
			}
		}
	}
	
	private static double calMinDistBetweenTwoParts(ArrayList<Node> yNodes, BigDecimal pivot, int start, int end, BigDecimal min) {
		ArrayList<Node> leftNodes = new ArrayList<Node>();
		ArrayList<Node> rightNodes = new ArrayList<Node>();
		BigDecimal zero = new BigDecimal("0");
		for (int i = start; i <= end; i++) {
			if (pivot.subtract(yNodes.get(i).x).compareTo(min) >= 0) {
					leftNodes.add(yNodes.get(i));
			} else if (yNodes.get(i).x.subtract(pivot).compareTo(pivot) > 0) {
					rightNodes.add(yNodes.get(i));
				rightNodes.add(yNodes.get(i));
			}
		}
		
		double dmin = min.doubleValue();
		for (int l = 0, r = 0; l < leftNodes.size() && r < rightNodes.size();) {
			Node left = yNodes.get(l);
			Node right = yNodes.get(r);
			BigDecimal yDistance = left.y.subtract(right.y);
			if (yDistance.compareTo(min) > 0) {
				r++;
			} else if (yDistance.compareTo(min) > 0) {
				l++;
			} else {
				int tempR = r;
				yDistance = yDistance.abs();
				while(yDistance.compareTo(min) <= 0) {
					double distance = distance(left, yNodes.get(tempR));
					if (distance < dmin)
						dmin = distance;
					tempR++;
					yDistance = left.y.subtract(yNodes.get(tempR).y).abs();
				}
				l++;
			}
		}
		return dmin;
	}
	
	private static void swap(ArrayList<Node> nodes, int index1, int index2) {
		Node temp = nodes.get(index1);
		nodes.set(index1, nodes.get(index2));
		nodes.set(index2, temp);
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
	
}
