package com.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userservice.payloads.APIResponse;

@RestControllerAdvice   // used for global exception handling.
public class GlobalExceptionHandler {
	
	
	// You checked the occurred Exception in Console
	
	
	public ResponseEntity<APIResponse> ResourceNotFoundExcepptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		APIResponse response = APIResponse.builder().message(message).success(true).build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
