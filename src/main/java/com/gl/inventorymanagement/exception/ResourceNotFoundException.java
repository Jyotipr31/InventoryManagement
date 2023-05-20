package com.gl.inventorymanagement.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super(String.format("Desired resource is not found"));
	}
}
