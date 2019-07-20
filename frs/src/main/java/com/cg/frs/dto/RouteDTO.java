package com.cg.frs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class RouteDTO {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROUTE_SEQ")
	@SequenceGenerator(name = "ROUTE_SEQ", sequenceName = "route_seq")

	@Column(name = "route_id", updatable = false, nullable = false)
	private int routeId;

	@Column(name = "Source")
	private String source;

	@Column(name = "Destination")
	private String destination;

	@OneToOne(mappedBy = "scheduleDTO")
	private FlightDTO FlightDTO;

	public RouteDTO(int routeId, String source, String destination) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
	}

	public RouteDTO(int route_id) {
		this.routeId = route_id;
	}

	public RouteDTO(String source, String destination) {
		super();

		this.source = source;
		this.destination = destination;
	}

	public RouteDTO() {
		super();

	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
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

	@Override
	public String toString() {
		return "routeId=" + routeId + ", source=" + source + ", destination=" + destination;
	}

}
