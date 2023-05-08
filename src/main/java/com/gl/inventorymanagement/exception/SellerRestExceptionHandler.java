package com.gl.inventorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

@ControllerAdvice
public class SellerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<SellerErrorResponse> handelException(SellerNotFoundException exc) {
		
SellerErrorResponse error=new SellerErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<SellerErrorResponse>(error,HttpStatus.NOT_FOUND);
	}

}
