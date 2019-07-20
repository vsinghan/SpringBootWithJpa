package com.cg.frs.exception;

import java.util.Date;

public class ServerError {

	private String error;
	private String message;
	private Date timestamp;
	private String details;

	public ServerError() {
		super();
	}

	public ServerError(String error, String message, Date timestamp, String details) {
		super();
		this.error = error;
		this.message = message;
		this.timestamp = timestamp;
		this.details = details;
	}

	public String getError() {
		return error;
	}

	public void setStatus(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ServerError [error=" + error + ", message=" + message + ", timestamp=" + timestamp + ", details="
				+ details + "]";
	}
}
