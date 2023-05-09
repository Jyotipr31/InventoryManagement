//package com.gl.inventorymanagement.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.gl.inventorymanagement.payloads.ApiResponse;
//
//@RestControllerAdvice
//public class MyExceptionHandler {
//	
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = Exception.class)
//	public String exceptionHandlerGeneric() {
//		return "An exception has occurred";
//	}
//	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
//		String message = ex.getMessage();
//		ApiResponse apiResponse = new ApiResponse(message,false);
//		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
//	}
//}
