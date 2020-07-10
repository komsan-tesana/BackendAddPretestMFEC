package com.example.ProjectMfec;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionAdvice {

	public UserExceptionAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String UserNotfound(UserNotFoundException ex) {
		return ex.getMessage();
	}

}

