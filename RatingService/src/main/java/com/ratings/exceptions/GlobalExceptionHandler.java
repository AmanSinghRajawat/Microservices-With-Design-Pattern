package com.ratings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ratings.payloads.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	ResponseEntity<APIResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
		String msg = exception.getMessage();
		APIResponse response = APIResponse.builder().message(msg).success(true).build();
		return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);

	}

}
