package com.ieslasgalletas.back.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ieslasgalletas.back.configuration.AuthenticationRequest;
import com.ieslasgalletas.back.configuration.AuthenticationResponse;
import com.ieslasgalletas.back.entity.User;
import com.ieslasgalletas.back.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/chambermaids")
	public List<User> getChamberMaids() {
		return userService.getChambermaids();
	}

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		User user = userService.getByUsername(authenticationRequest);
		return new AuthenticationResponse(user.getFullName(), user.getRole(), user.getId());
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/users/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user){
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
}
