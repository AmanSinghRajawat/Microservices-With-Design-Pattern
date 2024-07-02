package com.userservice.exceptions;

//You checked the occurred Exception in Console

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource not found exception.");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
