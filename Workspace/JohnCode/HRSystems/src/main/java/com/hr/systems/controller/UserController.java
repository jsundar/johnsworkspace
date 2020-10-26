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

import com.hr.systems.entity.User;
import com.hr.systems.repo.UserRepo;
import com.hr.systems.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User UserObj = userRepo.save(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(UserObj, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@PutMapping()
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		userRepo.save(user);
		return responseEntity;
	}
	
	@DeleteMapping()
	public ResponseEntity<User> deleteAllUser() {
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		userRepo.deleteAll();
		return responseEntity;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteAllUser(@PathVariable Long id) {
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		userRepo.deleteById(id);
		return responseEntity;
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> findAllUser() {
		ResponseEntity<List<User>> responseEntity = null;
		List<User> UserList = userRepo.findAll();
		 responseEntity = new ResponseEntity<>(UserList, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findAllUser(@PathVariable Long id) {
		ResponseEntity<User> responseEntity = null;
		User User = userRepo.findById(id).get();
		 responseEntity = new ResponseEntity<>(User, HttpStatus.ACCEPTED);
		return responseEntity;
	}

}
