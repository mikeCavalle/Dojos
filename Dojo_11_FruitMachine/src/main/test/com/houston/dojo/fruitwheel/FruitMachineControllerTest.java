package com.houston.dojo.fruitwheel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FruitMachineControllerTest {

	@Test
	public void spinOfTheWheelsDoesNotResultNull() {
		FruitMachineController machine = new FruitMachineController();
		machine.spinTheWheels();
		assertNotNull(machine.getResult());
	}

	@Test
	public void spinOfTheWheelsResultHasThreeSymbols() {
		FruitMachineController machine = new FruitMachineController();
		machine.spinTheWheels();
		List<Symbol> result = machine.getResult();
		assertEquals(3, result.size());
	}
	
	


	
}
