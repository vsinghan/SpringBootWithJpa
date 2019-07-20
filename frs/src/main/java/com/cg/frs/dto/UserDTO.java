package com.cg.frs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_login")
public class UserDTO {

	@Id
	private String username;
	private String password;
	private int roleid;
	@Column(name = "count_book_tickets")
	private int countBookTickets;
	@Column(name = "count_cancel_tickets")
	private int countCancelTickets;
	
	@OneToOne(mappedBy = "userDTO")
	private TicketDTO ticketDTO;

	
	public TicketDTO getTicketDTO() {
		return ticketDTO;
	}
	public void setTicketDTO(TicketDTO ticketDTO) {
		this.ticketDTO = ticketDTO;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String username, String password, int roleid, int countBookTickets, int countCancelTickets) {
		super();
		this.username = username;
		this.password = password;
		this.roleid = roleid;
		this.countBookTickets = countBookTickets;
		this.countCancelTickets = countCancelTickets;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getCountBookTickets() {
		return countBookTickets;
	}
	public void setCountBookTickets(int countBookTickets) {
		this.countBookTickets = countBookTickets;
	}
	public int getCountCancelTickets() {
		return countCancelTickets;
	}
	public void setCountCancelTickets(int countCancelTickets) {
		this.countCancelTickets = countCancelTickets;
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", roleid=" + roleid + ", countBookTickets="
				+ countBookTickets + ", countCancelTickets=" + countCancelTickets + "]";
	}
}
