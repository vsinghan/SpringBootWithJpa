package com.cg.frs.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class PassengerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_seq")
	@SequenceGenerator(name = "passenger_seq", sequenceName = "passenger_seq", allocationSize = 1)
	private int id;

	private String name;

	private int age;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email_id")
	private String emailId;

	@OneToOne(mappedBy = "passengerDTO")
	private TicketDTO ticketDTO;

	public PassengerDTO() {
		super();
	}

	public PassengerDTO(String name, int age, String mobileNo, String emailId) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public PassengerDTO(int id, String name, int age, String mobileNo, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Passenger :\n\tId: " + id + "\n\tName: " + name + "\n\tAge: " + age + "\n\tMobile no.: " + mobileNo
				+ "\n\tEmailId: " + emailId;
	}
}
