package com.bework.beworktracking.common;

public class ResponseError {
	private String status;
	private String message;
	private int errorCode;
	
	public ResponseError(String status, String message, int errorCode) {
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
	}
	public ResponseError(String message) {
		this.message = message;
		this.status = "Error";
		this.errorCode = 400;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
