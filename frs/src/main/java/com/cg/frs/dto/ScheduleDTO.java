package com.cg.frs.dto;

import java.time.LocalDate;

/**
 * DTO class to store schedule information
 * @author seeta
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class ScheduleDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULE_SEQ")
	@SequenceGenerator(name = "SCHEDULE_SEQ", sequenceName = "schedule_seq")
	@Column(name = "schedule_id")
	private int scheduleId;

	@Column(name = "arrival_date")
	private LocalDate arrivalDate;
	@Column(name = "departure_date")
	private LocalDate departureDate;
	@Column(name = "arrival_time")
	private String arrivalTime;
	@Column(name = "departure_time")
	private String departureTime;
	private double price;

	@OneToOne(mappedBy = "routeDTO")
	private FlightDTO FlightDTO;

	public ScheduleDTO() {
		super();
	}

	public ScheduleDTO(LocalDate arrivalDate, LocalDate departureDate, String arrivalTime, String departureTime,
			double price) {
		super();
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [scheduleId=" + scheduleId + ", arrivalDate=" + arrivalDate + ", departureDate="
				+ departureDate + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", price="
				+ price + "]";
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
