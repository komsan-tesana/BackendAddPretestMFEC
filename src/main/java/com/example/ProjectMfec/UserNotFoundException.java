package com.example.ProjectMfec;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	
	public UserNotFoundException(long id) {
		super("Could not find User  " + id);
	}
	
	public UserNotFoundException(String username) {
		super("Could not find User  " + username);
	}
}
