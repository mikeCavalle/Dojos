package com.houston;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class FirstFreePlayingComputerTest {

	
	private int[] board;
	private TicTacToePlayer player;

	@Before
	public void setUp() {
		player = new FirstFreePlayingComputer();
		board = new int[9];
		for (int i = 0; i < board.length; ++i) {
			board[i] = 0;
		}		
	}
	
	@Test
	public void shouldMoveToSquareZeroWhenEmptyBoard() {
		assertMoveIsAt(0);
	}
	
	@Test
	public void shouldMoveToSquareOneWhenSqureZeroTaken() {
		markSquarePlayed(0);
		assertMoveIsAt(1);	
	}

	@Test
	public void shouldThrowExceptionWhenBoardIsFull() {
		for (int i = 0; i < board.length; ++i) {
			markSquarePlayed(i);
		}
		try {
			player.move(board);
			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("Board is full.", ex.getMessage());
		}
	}

	@Test
	public void shouldMoveToSecondSquareWhenFirstTwoAndFourthIsPlayed() {
		markSquarePlayed(0);
		markSquarePlayed(1);
		markSquarePlayed(3);
		assertMoveIsAt(2);	
	}
	
	
	private void markSquarePlayed(int squareIndex) {
		board[squareIndex] = 1;
	}

	private void assertMoveIsAt(int expectedLocation) {
		assertEquals(expectedLocation, player.move(board));
	}

}
