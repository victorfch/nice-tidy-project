package com.ieslasgalletas.back.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("User not found");
	}
}
