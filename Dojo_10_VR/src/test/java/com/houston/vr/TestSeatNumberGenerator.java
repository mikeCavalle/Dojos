package com.houston.vr;

import static junit.framework.Assert.*;

import org.junit.Test;

public class TestSeatNumberGenerator {

	@Test
	public void shouldGenerateCarAndSeatNumber() {
		SeatNumberGenerator generator = new SeatNumberGenerator();
		Integer seatNumber = generator.generateSeatNumber();
		Integer carNumber = generator.generateCarNumber();
		assertNotNull(seatNumber);
		assertNotNull(carNumber);
	}
	
	@Test
	public void shouldReturnCombinedId() {
		SeatNumberGenerator generator = new SeatNumberGenerator();
		String seatId = generator.getSeatId();
		assertNotNull(seatId);
	}
	
	@Test
	public void seatIDContainsCarAndSeatAsAString(){
		SeatNumberGenerator generator = new SeatNumberGenerator();
		String seatId = generator.getSeatId();
		assertTrue(seatId.matches("[0-9]*:[0-9]*"));	
	}

}
