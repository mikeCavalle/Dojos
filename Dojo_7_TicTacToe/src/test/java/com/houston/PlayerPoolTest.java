package com.houston;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerPoolTest {

	@Test
	public void shouldReturnLetterAWith1PlayerAdded() {
		
		PlayerPool playerPool = new PlayerPool.Builder().addPlayer("A").build();
		String letter = playerPool.getNextPlayer().getLetter();
		
		assertEquals("Incorrect letter.", "A", letter);
		
	}
	
	@Test
	public void shouldReturnLetterCWith3PlayersAdded() {
		
		PlayerPool playerPool = new PlayerPool.Builder().addPlayer("A").addPlayer("B").addPlayer("C").build();
		playerPool.getNextPlayer();
		playerPool.getNextPlayer();
		
		String letter = playerPool.getNextPlayer().getLetter();
		 
		assertEquals("Incorrect letter.", "C", letter);
		
	}
	
	@Test
	public void shouldReturnLetterAWith2PlayersAdded() {
		
		PlayerPool playerPool = new PlayerPool.Builder().addPlayer("A").addPlayer("B").build();
		playerPool.getNextPlayer();
		playerPool.getNextPlayer();
		
		String letter = playerPool.getNextPlayer().getLetter();
		 
		assertEquals("Incorrect letter.", "A", letter);
		
	}
	
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void shouldRaiseAnExceptionSinceNoPlayersAdded() {
		
		PlayerPool playerPool = new PlayerPool.Builder().build();
		playerPool.getNextPlayer().getLetter();
		
		assertTrue("Exception not raised", false);
		
	}

}
