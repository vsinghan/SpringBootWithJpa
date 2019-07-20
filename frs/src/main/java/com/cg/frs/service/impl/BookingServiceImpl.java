package com.cg.frs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.frs.dao.PassengerDao;
import com.cg.frs.dto.TicketDTO;
import com.cg.frs.exception.TicketIdNotFoundException;
import com.cg.frs.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private PassengerDao passengerDao;

	/**
	 * this method will return no. of seats available
	 */
	@Override
	public int viewAvailableSeats() {
		return passengerDao.getAvailableSeats();
	}
	
	/**
	 * this method will book the ticket
	 */
	public List<Integer> bookTicket(List<TicketDTO> ticketDTOs) {

		return passengerDao.insertPassenger(ticketDTOs);
	}

	/**
	 * this method will cancel the ticket using ticket id
	 */
	@Override
	public void cancelTicket(int ticketId) throws TicketIdNotFoundException {

		passengerDao.deletePassenger(ticketId);
	}

	/**
	 * this method will return passenger details
	 */
	@Override
	public TicketDTO viewTicket(int ticketId) throws TicketIdNotFoundException {

		return passengerDao.getPassengerInfo(ticketId);
	}
}
