package com.mindtree.customer.exceptions;

import java.util.Date;

public class HandleException {
      private Date timestamp;
      private String message;
      private String description;
	public HandleException(Date timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
      
}
