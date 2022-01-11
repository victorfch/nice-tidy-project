package com.ieslasgalletas.back.configuration;

public class AuthenticationResponse {
	private String fullName;
	private String role;
	private int id;

	public AuthenticationResponse(String fullName, String role, int id) {
		super();
		this.fullName = fullName;
		this.role = role;
		this.id = id;
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

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }
	
	
}
