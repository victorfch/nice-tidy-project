package com.ieslasgalletas.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	
	//modifica el usuario salvo id
	@Override
	public ResponseEntity<User> updateUser(int id, User user) {
		Optional<User> opUser = userRepository.findById(id);
		if(opUser.isPresent()) {
			User updatedUser = opUser.get();
			if(user.getUsername() != null) { updatedUser.setUsername(user.getUsername()); }
			if(user.getName() != null) { updatedUser.setName(user.getName()); }
			if(user.getSurname() != null) { updatedUser.setSurname(user.getSurname()); }
			if(user.getRole() != null) { updatedUser.setRole(user.getRole()); }
			if(user.getPassword() != null) { updatedUser.setPassword(bCryptPasswordEncode.encode(user.getPassword())); }
			return new ResponseEntity<>(userRepository.save(updatedUser), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
		User user = userRepository.findByUsername(request.getUsername());
		if (user == null) {
			throw new UserNotFoundException();
		}
		if (!bCryptPasswordEncode.matches(request.getPassword(), user.getPassword())) {
			throw new UserNotFoundException();
		} 
		
		return user;
	}

	
}
