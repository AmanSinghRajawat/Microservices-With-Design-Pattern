package com.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	private long userId;
	private String username;
	private String email;
	private String city;
	
	// ratings
	
	@Transient
	private List<Ratings> ratings = new ArrayList<>();
	
	
	
	@Override
	public String toString() {
		return "Users [userid=" + userId + ", username=" + username + ", email=" + email + ", city=" + city + "]";
	}



	public Users(long userId, String username, String email, String city) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.city = city;
	}
	
	
	
	
	

}
