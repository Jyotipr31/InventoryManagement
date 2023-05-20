package com.gl.inventorymanagement.exception;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
		super(String.format("Customer does not exist for the given the id."));
	}
}
