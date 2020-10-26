package com.hr.systems.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.systems.domain.User;
import com.hr.systems.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public User createUser(User user) {
		user.setCreatedBy("System");
		user.setCreatedDt(new Date().toString());
		return userRepo.save(user);
	}
	
	public User updateUser(User user) {
		user.setMaintainedBy("System");
		user.setMaintainedDt(new Date().toString());
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
