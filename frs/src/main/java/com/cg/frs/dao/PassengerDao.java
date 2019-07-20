package com.cg.frs.dao;

import java.util.List;

import com.cg.frs.dto.TicketDTO;
import com.cg.frs.exception.TicketIdNotFoundException;

public interface PassengerDao {

	int getAvailableSeats();

	List<Integer> insertPassenger(List<TicketDTO> ticketDTOs);

	void deletePassenger(int ticketId) throws TicketIdNotFoundException;

	TicketDTO getPassengerInfo(int ticketId) throws TicketIdNotFoundException;

}
