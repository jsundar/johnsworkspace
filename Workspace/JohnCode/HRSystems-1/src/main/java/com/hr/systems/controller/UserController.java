package com.hr.systems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.systems.domain.User;
import com.hr.systems.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User UserObj = userService.createUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(UserObj, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@PutMapping()
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		userService.updateUser(user);
		return responseEntity;
	}
	
	@DeleteMapping()
	public ResponseEntity<User> deleteAllUser() {
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		userService.deleteAllUsers();
		return responseEntity;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteAllUser(@PathVariable Long id) {
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		userService.deleteUserById(id);
		return responseEntity;
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> findAllUser() {
		ResponseEntity<List<User>> responseEntity = null;
		List<User> UserList = userService.getAllUsers();
		 responseEntity = new ResponseEntity<>(UserList, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findAllUser(@PathVariable Long id) {
		ResponseEntity<User> responseEntity = null;
		User User = userService.getUserById(id).get();
		 responseEntity = new ResponseEntity<>(User, HttpStatus.ACCEPTED);
		return responseEntity;
	}

}
