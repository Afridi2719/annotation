package com.allAnotation.testing.AnotationsTesting.Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


public class ExceptionResponse {
	
	private String status;
	private LocalDateTime time;
	private String message;
	
	

	public ExceptionResponse(String status, LocalDateTime time, String message) {
		this.status = status;
		this.time = time;
		this.message = message;
	}



	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "ExceptionResponse [status=" + status + ", time=" + time + ", message=" + message + "]";
	}
	
	
}
