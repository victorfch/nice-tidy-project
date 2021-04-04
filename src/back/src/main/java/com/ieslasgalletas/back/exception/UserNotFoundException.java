package com.ieslasgalletas.back.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("usuario no encontrado");
	}
}
