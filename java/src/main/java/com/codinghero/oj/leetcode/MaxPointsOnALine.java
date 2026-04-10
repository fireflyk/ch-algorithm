package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * calculate the gradient. same gradient lines with public point must be same line. Time O(n^2) 
 * 
 * @author Tong Liu
 *
 */
public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		int max = 1;
		Double[][] gradients = new Double[points.length][points.length];
		for (int i = 0; i < points.length; i++) {
			int same = 0;
			Map<Double, List<Point>> gradientPoints = new HashMap<Double, List<Point>>();
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					// same, then plus 1 to every gradient
					if (points[i].x == points[j].x && points[i].y == points[j].y)
						same++;
					// not same, calculate the gradient
					else {
						double gradient = getGradient(gradients, points, i, j);
						addSameGradientPoint(gradientPoints, points[j], gradient);
					}
				}
			}
			// find max of this round
			// have gradient, then find max
			if (!gradientPoints.isEmpty()) {
				for (Map.Entry<Double, List<Point>> entry : gradientPoints.entrySet()) {
					List<Point> sameGradientPoints = entry.getValue();
					if (sameGradientPoints != null
							&& sameGradientPoints.size() + 1 + same > max)
						max = sameGradientPoints.size() + 1 + same;
				}
			}
			// no gradient, then check variable same & max
			else {
				if (same + 1 > max)
					max = same + 1;
			}
		}
		return max;
	}
	
	private double getGradient(Double[][] gradients, Point[] points, int i, int j) {
		if (i > j) {
			return getGradient(gradients, points, j, i);
		}
		if (gradients[i][j] == null) {
			gradients[i][j] = ((double) (points[j].y - points[i].y))
					/ ((double) (points[j].x - points[i].x));
		}
		return gradients[i][j];
	}
	
	private void addSameGradientPoint(Map<Double, List<Point>> gradientPoints, Point point, double gradient) {
		List<Point> sameGradientPoints = gradientPoints.get(gradient);
		if (sameGradientPoints == null) {
			sameGradientPoints = new ArrayList<Point>();
			gradientPoints.put(gradient, sameGradientPoints);
		}
		sameGradientPoints.add(point);
	}
}
