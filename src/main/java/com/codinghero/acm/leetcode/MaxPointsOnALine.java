package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
					if (points[i].x == points[j].x && points[i].y == points[j].y)
						same++;
					else
						calGradient(gradientPoints, gradients, points, i, j);
				}
			}
			// find max of this round
			if (!gradientPoints.isEmpty()) {
				for (Map.Entry<Double, List<Point>> entry : gradientPoints.entrySet()) {
					List<Point> sameGradientPoints = entry.getValue();
					if (sameGradientPoints != null
							&& sameGradientPoints.size() + 1 + same > max)
						max = sameGradientPoints.size() + 1 + same;
				}
			} else {
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
	
	private void calGradient(Map<Double, List<Point>> gradientPoints, Double[][] gradients, Point[] points, int i, int j) {
		double gradient = getGradient(gradients, points, i, j);
		// is same point
		List<Point> sameGradientPoints = gradientPoints.get(gradient);
		/*
		boolean isSame = false;
		if (sameGradientPoints != null) {
			for (Point sameGradientPoint : sameGradientPoints) {
				if (points[j].x == sameGradientPoint.x
						&& points[j].y == sameGradientPoint.y) {
					isSame = true;
				}
			}
		}
		*/
		// not same, add point
//		if(!isSame) {
			if (sameGradientPoints == null) {
				sameGradientPoints = new ArrayList<Point>();
				gradientPoints.put(gradient, sameGradientPoints);
			}
			sameGradientPoints.add(points[j]);
//		}
	}
}
