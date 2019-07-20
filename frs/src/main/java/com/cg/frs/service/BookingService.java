package com.cg.frs.service;

import java.util.List;

import com.cg.frs.dto.TicketDTO;
import com.cg.frs.exception.TicketIdNotFoundException;

public interface BookingService {

	int viewAvailableSeats();

	List<Integer> bookTicket(List<TicketDTO> ticketDTOs);

	void cancelTicket(int ticketId) throws TicketIdNotFoundException;

	TicketDTO viewTicket(int ticketId) throws TicketIdNotFoundException;
}
