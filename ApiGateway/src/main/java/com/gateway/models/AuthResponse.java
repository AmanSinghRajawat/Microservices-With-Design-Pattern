package com.gateway.models;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	
	private String userEmailId;
	
	private String accessToken;
	
	private String refreshToken;
	
	private long expireAt;
	
	private Collection<String> authorities;

}
