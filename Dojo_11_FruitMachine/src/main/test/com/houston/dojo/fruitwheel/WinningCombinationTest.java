package com.houston.dojo.fruitwheel;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class WinningCombinationTest {

	@Test
	public void canValidateWinningCombination() {
		List<Symbol> result = Arrays.asList(new Symbol("X"), new Symbol("X"),
				new Symbol("X"));

		WinningCombination combination = new WinningCombination();
		Assert.assertTrue(combination.isWinningCombination(result));

	}

	@Test
	public void canValidateLosingCombination() {
		List<Symbol> result = Arrays.asList(new Symbol("X"), new Symbol("X"),
				new Symbol("Y"));

		WinningCombination combination = new WinningCombination();
		Assert.assertFalse(combination.isWinningCombination(result));
	}

}
