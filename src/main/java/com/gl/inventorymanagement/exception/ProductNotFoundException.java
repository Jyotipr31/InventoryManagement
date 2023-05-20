package com.gl.inventorymanagement.exception;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
		super(String.format("Product does not exist for the given the id."));
	}
}
