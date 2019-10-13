package com.chateaugiron.basket;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PeriodProvider {
	public List<Integer> getPeriod()
	{
		return Arrays.asList(new Integer[] { 1, 2, 3 });
	}
}
