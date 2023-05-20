package com.gl.inventorymanagement.exception;

public class SellerNotFoundException extends RuntimeException {

	public SellerNotFoundException() {
		super(String.format("Seller does not exist for the given the id."));
	}
}