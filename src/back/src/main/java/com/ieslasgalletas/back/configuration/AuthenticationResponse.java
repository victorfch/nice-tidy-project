package com.ieslasgalletas.back.configuration;

public class AuthenticationResponse {
	private String fullName;
	private String role;
	
	public AuthenticationResponse(String fullName, String role) {
		super();
		this.fullName = fullName;
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
