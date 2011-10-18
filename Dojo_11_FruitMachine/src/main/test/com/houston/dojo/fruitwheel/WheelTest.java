package com.houston.dojo.fruitwheel;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class WheelTest {


	@Test
	public void wheelCurrentSymbolCannotBeNull() {
		Wheel wheel = generateWheel();
		assertNotNull(wheel.getCurrentSymbol());
	}

	@Test
	public void wheelSizeIsTen() {
		Wheel wheel = generateWheel();
		assertEquals(10, wheel.size());
	}

	@Test
	public void spinningOnceResultsDifferentSymbol() {
		Wheel wheel = generateWheel();
		Symbol state = wheel.getCurrentSymbol();
		wheel.spin(1);
		assertFalse(state.equals(wheel.getCurrentSymbol()));
	}

	@Test
	public void spinningOneRoundShouldResultSameState() {
		Wheel wheel = generateWheel();
		Symbol state = wheel.getCurrentSymbol();
		wheel.spin(Wheel.SIZE);
		assertTrue(state.equals(wheel.getCurrentSymbol()));
	}


	@Test
	public void spinningMoreThanOneRoundResultsDifferentSymbol() {
		Wheel wheel = generateWheel();
		Symbol state = wheel.getCurrentSymbol();
		wheel.spin(Wheel.SIZE + 1);
		assertFalse("Expected " + state + ", got " + wheel.getCurrentSymbol(),
				state.equals(wheel.getCurrentSymbol()));
	}

	private Wheel generateWheel() {
		return new Wheel(generateSymbols());
	}

	private List<Symbol> generateSymbols() {
		List<Symbol> symbols = new LinkedList<Symbol>();
		for (int i = 0; i < Wheel.SIZE; i++) {
			symbols.add(new Symbol("" + i));
		}
		return symbols;
	}



}
