package com.houston.dojo.fruitwheel;

import java.util.List;

public class WinningCombination {

	public boolean isWinningCombination(List<Symbol> result) {

		// Collections.sort(result);
		// return result.get(0).equals(result.get(result.size()));

		Symbol previousSymbol = result.get(0);

		for (Symbol symbol : result) {
			if (!previousSymbol.equals(symbol))
				return false;
			previousSymbol = symbol;
		}

		return true;
	}

}
