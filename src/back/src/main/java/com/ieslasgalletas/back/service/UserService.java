package com.ieslasgalletas.back.service;

import java.util.List;
import java.util.Optional;

import com.ieslasgalletas.back.configuration.AuthenticationRequest;
import com.ieslasgalletas.back.entity.User;

public interface UserService {
	public abstract User addUser(User user);

	public abstract void deleteUser(int id);

	public abstract List<User> getUsers();

	public abstract User getUserById(int id);
	
	public abstract User getByUsername(AuthenticationRequest request);
}
