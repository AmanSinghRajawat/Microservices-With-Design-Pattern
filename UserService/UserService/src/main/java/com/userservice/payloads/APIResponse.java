package com.userservice.payloads;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse {

	private String message;
	private boolean success;
	private HttpStatus status;
	
	
	@Override
	public String toString() {
		return "APIResponse [message=" + message + ", success=" + success + ", status=" + status + "]";
	}
	
	
	
	
	
}
