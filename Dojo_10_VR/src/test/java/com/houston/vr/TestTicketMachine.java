package com.houston.vr;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestTicketMachine extends BaseWebContainerTest {

	@Test
	public void shouldShowErrorAndStayOnTheSamePageWhenTicketIsEmpty() {
		beginAt("app/buy"); 
		submit();
		assertFormPresent("ticketForm");
	}
	
	@Test
	public void ticketCanBeOrderedWithAName() {
		beginAt("app/buy");
		setTextField("name", "Urgo");
		submit();
		assertMatchInElement("name", "Urgo");
	}
	
	@Test
	public void epicTicketTest() {
		beginAt("app/buy");
		setTextField("name", "Urgo");
		setTextField("train", "IC55");
		setTextField("from", "Helsinki");
		setTextField("to", "Lahti");
		submit();
		assertMatchInElement("name", "Urgo");
		assertMatchInElement("train", "IC55");
		assertMatchInElement("from", "Helsinki");
		assertMatchInElement("to", "Lahti");
		assertElementPresent("seatnumber");
		assertFormNotPresent("ticketForm");
	}
	
	@Test
	public void validSeatNumber() {
		beginAt("app/buy");
		setTextField("name", "Urgo");
		setTextField("train", "IC55");
		setTextField("from", "Helsinki");
		setTextField("to", "Lahti");
		submit();
		assertMatchInElement("seatnumber", "1:2");
	}
	
	
	
}
