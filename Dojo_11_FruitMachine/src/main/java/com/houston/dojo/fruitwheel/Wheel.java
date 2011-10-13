package com.houston.dojo.fruitwheel;

import java.util.List;

public class Wheel {

	public static final int SIZE = 10;

	private final List<Symbol> symbolList;
	private int currentState;

	public Wheel(List<Symbol> symbols) {
		this.symbolList = symbols;
	}

	public Symbol getCurrentSymbol() {
		return symbolList.get(currentState);
	}

	public int size() {
		return symbolList.size();
	}

	public void spin(int i) {
		currentState = ((currentState += i) % SIZE);
	}

}
