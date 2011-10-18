package com.houston.dojo.fruitwheel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SymbolTest {

	@Test
	public void symbolStringPresentationNotNull() {
		Symbol symbol = new Symbol("X");
		String value = symbol.toString();
		assertNotNull(value);
	}

	@Test
	public void symbolStringPresentationEqualsX() {
		Symbol s = new Symbol("X");
		assertEquals("X", s.toString());
	}

	@Test
	public void symbolsEqual() {

		Symbol s1 = new Symbol("X");
		Symbol s2 = new Symbol("X");

		assertEquals(s1, s2);
	}


}
