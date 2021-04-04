package com.ieslasgalletas.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ieslasgalletas.back.configuration.AuthenticationRequest;
import com.ieslasgalletas.back.entity.User;
import com.ieslasgalletas.back.exception.UserNotFoundException;
import com.ieslasgalletas.back.exception.UsernameExistException;
import com.ieslasgalletas.back.repository.UserRepository;
import com.ieslasgalletas.back.service.UserService;

@Service
public class UserServiceMySQL implements UserService {
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncode;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncode() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	public User addUser(User user) {
		user.setPassword(bCryptPasswordEncode.encode(user.getPassword()));
		try {
			return userRepository.save(user);			
		} catch (Exception e) {
			throw new UsernameExistException();
		}
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
	public User getUserById(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException());
	}

	@Override
	public User getByUsername(AuthenticationRequest request) {
		System.out.println(request.getPassword());
		System.out.println(request.getUsername());
		User user = userRepository.findByUsername(request.getUsername());
		if (bCryptPasswordEncode.matches(request.getPassword(), user.getPassword())) {
			System.out.println("son iguales");
		} else {
			System.out.println("no son iguales");
		}
		
		return user;
	}

	
}
