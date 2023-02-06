package com.app.custom_exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException  extends  RuntimeException{

	public ResourceNotFoundException(String mesg) {
		// TODO Auto-generated constructor stub
		super(mesg);
	}
}
