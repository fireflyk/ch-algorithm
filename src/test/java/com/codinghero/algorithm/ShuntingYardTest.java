package com.codinghero.algorithm;

import org.junit.Assert;
import org.junit.Test;

import com.codinghero.util.ArrayUtils;
import com.codinghero.util.StringUtils;

public class ShuntingYardTest {
	
	@Test
	public void test() {
		String nifix = "3+4*2/(1-5)+1";
		String[] suffix = new ShuntingYard().transform(nifix.toCharArray());
		Assert.assertEquals("342*15-/+1+", StringUtils.join(ArrayUtils.toList(suffix), ""));
		Assert.assertEquals(2, new ReversePolish().cal(suffix));
		
		nifix = "3+4*2+5/1+6";
		suffix = new ShuntingYard1().transform(nifix.toCharArray());
		Assert.assertEquals("342*+51/+6+", StringUtils.join(ArrayUtils.toList(suffix), ""));
		Assert.assertEquals(22, new ReversePolish().cal(suffix));
	}
}
