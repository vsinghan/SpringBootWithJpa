package com.cg.frs.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ticket")
public class TicketDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	@SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq")
	private int pnr;

	@Column(name = "seat_no")

	private int seatNo;

	@Column(name = "flight_id")
	public int flighTID = 303;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passenger_id", referencedColumnName = "id")
	private PassengerDTO passengerDTO;

	@Transient
	private String passengerName;

	@Transient
	private LocalDate departureDate;

	@Transient
	private String departureTime;

	@Transient
	private String source;

	@Transient
	private String destination;

	// @ManyToOne
	// private FlightDTO flightDTO;

	// @Column(name = "passenger_id")
	// private String passengerId;
	//
	// @Column(name = "flight_id")
	// private String flightId;
	//
	// public String getPassengerId() {
	// return passengerId;
	// }
	//
	// public void setPassengerId(String passengerId) {
	// this.passengerId = passengerId;
	// }
	//
	// public String getFlightId() {
	// return flightId;
	// }
	//
	// public void setFlightId(String flightId) {
	// this.flightId = flightId;
	// }

	public int getFlighTID() {
		return flighTID;
	}

	public PassengerDTO getPassengerDTO() {
		return passengerDTO;
	}

	public void setPassengerDTO(PassengerDTO passengerDTO) {
		this.passengerDTO = passengerDTO;
	}

	public TicketDTO() {
		super();
	}

	public TicketDTO(String passengeName, int pnr, int seatNo, String date, String time, String source,
			String destination) {
		super();
		this.passengerName = passengeName;
		this.pnr = pnr;
		this.seatNo = seatNo;
		this.departureTime = date;
		this.departureTime = time;
		this.source = source;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "\n\tPassengerName: " + passengerName + "\n\tPnr: " + pnr + "\n\tSeat no: " + seatNo
				+ "\n\tDeparture date: " + departureTime + "\n\tDeparture time: " + departureTime + "\n\tSource: "
				+ source + "\n\tDestination: " + destination;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengeName) {
		this.passengerName = passengeName;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
