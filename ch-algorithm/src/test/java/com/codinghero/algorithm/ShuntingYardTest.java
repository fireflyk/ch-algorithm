package com.codinghero.algorithm;

import com.codinghero.util.ArrayUtils;
import com.codinghero.util.StringUtils;

public class ShuntingYardTest {
	public void test() {
		String[] nifix = new String[] { "3", "+", "4", "*", "2", "/", "(", "1",
				"-", "5", ")", "^", "2", "^", "3" };
		String[] suffix = new ShuntingYard().transform(nifix);
		System.out.println(StringUtils.join(ArrayUtils.toList(suffix), " "));
	}
}
