package com.cg.frs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.frs.dto.TicketDTO;
import com.cg.frs.exception.TicketIdNotFoundException;
import com.cg.frs.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

	/**
	 * this method shows the available seats in a selected flight
	 * 
	 * @return
	 */
	@GetMapping(value = "/viewseats", produces = "application/json")
	public int viewSeats() {
		LOGGER.trace("A TRACE Message");
		LOGGER.debug("A DEBUG Message");
		LOGGER.info("An INFO Message");
		LOGGER.warn("A WARN Message");
		LOGGER.error("An ERROR Message");
		return bookingService.viewAvailableSeats();
	}

	/**
	 * this method takes the details of passenger and return the ticket no.
	 * 
	 * @param passengerList
	 * @return
	 */
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public List<Integer> addPassenger(@RequestBody List<TicketDTO> ticketDTOs) {

		return bookingService.bookTicket(ticketDTOs);
	}

	/**
	 * this method takes ticket id from passenger and cancel the ticket
	 * 
	 * @param ticketId
	 * @return
	 */
	@GetMapping(value = "/CancelTicket/{ticketId}", produces = "application/json")
	@ResponseBody
	public String removePassenger(@PathVariable("ticketId") int ticketId) throws TicketIdNotFoundException {
		bookingService.cancelTicket(ticketId);
		return "Your ticket has been cancelled!!!";
	}

	/**
	 * this method takes ticket id from passenger and return the details of ticket
	 * 
	 * @param ticketId
	 * @return
	 */
	@GetMapping(value = "/ViewTicket/{ticketId}", produces = "application/json")
	@ResponseBody
	public TicketDTO viewTicket(@PathVariable("ticketId") int ticketId) throws TicketIdNotFoundException {
		return bookingService.viewTicket(ticketId);
	}
}
