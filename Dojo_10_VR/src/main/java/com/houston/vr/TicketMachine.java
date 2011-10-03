package com.houston.vr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.houston.vr.model.Ticket;

@Controller
public class TicketMachine {
	
	@RequestMapping(value="/buy", method=RequestMethod.GET)
	public String showForm() {
		return "buy";
	}

	@RequestMapping(value="/ticket", method=RequestMethod.POST)
	public String buyTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		
		if (ticket.getName() == null || "".equals(ticket.getName())){
			return "buy";
		}
		
		ticket.setSeatnumber(new SeatNumberGenerator().getSeatId());
		
		model.addAttribute("ticket", ticket);
		return "ticket";
	}	
}
