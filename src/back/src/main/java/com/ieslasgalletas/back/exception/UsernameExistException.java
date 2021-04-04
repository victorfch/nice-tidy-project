package com.ieslasgalletas.back.exception;

public class UsernameExistException extends RuntimeException{
	public UsernameExistException() {
		super("Username alredy exist");
	}

}
