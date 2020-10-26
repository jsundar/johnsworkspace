package com.hr.systems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.systems.entity.User;
import com.hr.systems.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}

	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}

}
