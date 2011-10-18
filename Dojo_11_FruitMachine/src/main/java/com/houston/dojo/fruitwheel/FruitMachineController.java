package com.houston.dojo.fruitwheel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FruitMachineController {

	private final List<Wheel> wheels;
	private static final WinningCombination winningCombination = new WinningCombination();

	public FruitMachineController() {
		wheels = new ArrayList<Wheel>();
		wheels.add(new Wheel(generateSymbols()));
		wheels.add(new Wheel(generateSymbols()));
		wheels.add(new Wheel(generateSymbols()));
	}

	public void spinTheWheels() {
		for (Wheel wheel : wheels) {
			wheel.spin(new Random().nextInt(20));
		}
	}

	public List<Symbol> getResult() {
		List<Symbol> result = new ArrayList<Symbol>();
		for (Wheel wheel : wheels) {
			result.add(wheel.getCurrentSymbol());
		}
		return result;
	}

	private List<Symbol> generateSymbols() {
		List<Symbol> symbols = new LinkedList<Symbol>();
		for (int i = 0; i < Wheel.SIZE; i++) {
			symbols.add(new Symbol("" + i));
		}
		return symbols;
	}

	public static void main(String[] args) {
		FruitMachineController c = new FruitMachineController();
		int i = 0;

		do {
			i++;
			c.spinTheWheels();
			System.out.println("Round: " + i + " Result: " + c.getResult()
					+ " isWin:"
					+ winningCombination.isWinningCombination(c.getResult()));
		} while (!winningCombination.isWinningCombination(c.getResult()));
	}
}
