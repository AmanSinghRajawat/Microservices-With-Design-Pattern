package com.restaurants.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restaurants.payloads.APIResponse;

@RestControllerAdvice
public class GlobalExceptionsHandler {
	ResponseEntity<APIResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException exception){
		String msg = exception.getMessage();  // get the exception message.
		APIResponse response = APIResponse.builder().message(msg).success(true).build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
