package com.app.dto;

import java.time.LocalDateTime;

public class ApiResponse {

	private String mesg;
	private LocalDateTime dt;
	
	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ApiResponse(String mesg) {
		super();
		this.mesg = mesg;
		this.dt = LocalDateTime.now();
	}




	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public LocalDateTime getDt() {
		return dt;
	}
	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}
	
	
}
