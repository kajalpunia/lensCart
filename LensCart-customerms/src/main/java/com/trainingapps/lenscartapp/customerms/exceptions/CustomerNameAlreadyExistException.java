package com.trainingapps.lenscartapp.customerms.exceptions;

public class CustomerNameAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomerNameAlreadyExistException(String message) {
		super(message);
	}

}