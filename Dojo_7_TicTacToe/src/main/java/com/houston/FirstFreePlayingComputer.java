package com.houston;

public class FirstFreePlayingComputer implements TicTacToePlayer {

	@Override
	public int move(int[] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				return i;
			}
		}
		throw new IllegalArgumentException("Board is full.");
	}

}
