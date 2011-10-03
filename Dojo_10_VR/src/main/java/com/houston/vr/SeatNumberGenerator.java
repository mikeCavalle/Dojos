package com.houston.vr;

public class SeatNumberGenerator {

	public Integer generateSeatNumber() {
		return 1;
	}

	public Integer generateCarNumber() {
		return 2;
	}

	public String getSeatId() {
		return generateSeatNumber() + ":" + generateCarNumber();
	}

}
