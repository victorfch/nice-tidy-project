package com.ieslasgalletas.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieslasgalletas.back.entity.User;
import com.ieslasgalletas.back.repository.UserRepository;
import com.ieslasgalletas.back.service.UserService;

@Service
public class UserServiceMySQL implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

}
