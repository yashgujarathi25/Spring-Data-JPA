package com.app.dto;

public class EmployeeFirstAndLast {

	private String firstName;
	private String lastName;
	
	public EmployeeFirstAndLast() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeFirstAndLast(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
