package com.ieslasgalletas.back.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ieslasgalletas.back.entity.User;
import com.ieslasgalletas.back.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		System.out.println(user);
		return userService.addUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	@CrossOrigin
	@GetMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}

}
