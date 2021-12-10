package com.iocl.dhruva2api.payload;

import java.util.Date;

public class ApiResponse {

	private Boolean success;
	private String message;
	private Date timestamp;

	public ApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
		this.timestamp = new Date();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
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
}
