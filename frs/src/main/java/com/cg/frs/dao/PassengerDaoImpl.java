package com.cg.frs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.frs.dto.FlightDTO;
import com.cg.frs.dto.RouteDTO;
import com.cg.frs.dto.ScheduleDTO;
import com.cg.frs.dto.TicketDTO;
import com.cg.frs.exception.ExceptionMessages;
import com.cg.frs.exception.TicketIdNotFoundException;

@Repository
@Transactional
public class PassengerDaoImpl implements PassengerDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * this method will insert details of passenger and generate the ticket
	 */
	public List<Integer> insertPassenger(List<TicketDTO> ticketDTOs) {

		List<Integer> tickets = new ArrayList<>();
		for (TicketDTO ticketDTO : ticketDTOs) {

			entityManager.persist(ticketDTO);

			FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());
			flightDTO.setCapacity(flightDTO.getCapacity() - 1);

			tickets.add(ticketDTO.getPnr());
		}

		return tickets;
	}

	/**
	 * this method will cancel the ticket and delete the passenger details
	 */
	public void deletePassenger(int ticketId) throws TicketIdNotFoundException {

		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO = entityManager.find(TicketDTO.class, ticketId);
		if (ticketDTO == null) {
			throw new TicketIdNotFoundException(ExceptionMessages.MESSAGE9);
		}

		FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());

		entityManager.remove(ticketDTO);
		flightDTO.setCapacity(flightDTO.getCapacity() + 1);
	}

	/**
	 * this method will fetch the ticket details
	 */
	public TicketDTO getPassengerInfo(int ticketId) throws TicketIdNotFoundException {

		TicketDTO ticketDTO = entityManager.find(TicketDTO.class, ticketId);
		if (ticketDTO == null) {
			throw new TicketIdNotFoundException(ExceptionMessages.MESSAGE9);
		}

		ticketDTO.setPassengerName(ticketDTO.getPassengerDTO().getName());

		FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());
		ScheduleDTO scheduleDTO = flightDTO.getScheduleDTO();
		RouteDTO routeDTO = flightDTO.getRouteDTO();

		ticketDTO.setSource(routeDTO.getSource());
		ticketDTO.setDestination(routeDTO.getDestination());
		ticketDTO.setDepartureDate(scheduleDTO.getDepartureDate());
		ticketDTO.setDepartureTime(scheduleDTO.getDepartureTime());

		return ticketDTO;
	}

	/**
	 * this method will fetch the available seats in a particular flight
	 */
	public int getAvailableSeats() {

		TicketDTO ticketDTO = new TicketDTO();
		FlightDTO flightDTO = entityManager.find(FlightDTO.class, ticketDTO.getFlighTID());
		// try {
		//
		// } catch (IllegalArgumentException illegalArgumentException) {
		// // throw new FRSException(ExceptionMessages.MESSAGE9);
		// throw new TicketIdNotFoundException(ExceptionMessages.MESSAGE9);
		// }
		return flightDTO.getCapacity();
	}
}