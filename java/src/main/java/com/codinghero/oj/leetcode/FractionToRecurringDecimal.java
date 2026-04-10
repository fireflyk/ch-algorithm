package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2,
 * denominator = 1, return "2". Given numerator = 2, denominator = 3, return
 * "0.(6)".
 * 
 * @author Tong Liu
 *
 */
public class FractionToRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		long dd = numerator, d = denominator;
		if (dd == 0) {
			return "0";
		} else if (dd < 0 && d < 0) {
			return calculate(dd * -1, d * -1).toString();
		} else if (dd > 0 && d < 0) {
			return calculate(dd, d * -1).insert(0, '-').toString();
		} else if (dd < 0 && d > 0) {
			return calculate(dd * -1, d).insert(0, '-').toString();
		} else {
			return calculate(dd, d).toString();
		}

	}

	private StringBuilder calculate(long dd, long d) {
		StringBuilder sb = new StringBuilder();
		while (dd > d) {
			sb.append(dd / d);
			dd = dd % d;
		}
		if (sb.length() == 0) {
			sb.append('0');
		}

		Map<Long, Integer> rMap = new HashMap<Long, Integer>();
		List<Long> dParts = new ArrayList<Long>();

		return sb.append(getDecimalPart(rMap, dParts, dd, d));
	}

	private StringBuilder getDecimalPart(Map<Long, Integer> rMap,
			List<Long> dParts, long dd, long d) {
		for (int i = 0; !rMap.containsKey(dd); i++) {
			if (dd == 0)
				break;
			rMap.put(dd, i);
			dd *= 10;
			dParts.add(dd / d);
			dd = dd % d;
		}

		StringBuilder sb = new StringBuilder();
		if (!dParts.isEmpty()) {
			sb.append('.');
			if (rMap.containsKey(dd)) {
				for (int j = 0; j < rMap.get(dd); j++) {
					sb.append(dParts.get(j));
				}
				sb.append('(');
				for (int j = rMap.get(dd); j < dParts.size(); j++) {
					sb.append(dParts.get(j));
				}
				sb.append(')');
			} else {
				for (int j = 0; j < dParts.size(); j++) {
					sb.append(dParts.get(j));
				}
			}
		}
		return sb;
	}
}
