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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.systems.entity.Role;
import com.hr.systems.repo.RoleRepo;
import com.hr.systems.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping()
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		
		Role roleObj = roleService.createRole(role);
		ResponseEntity<Role> responseEntity = new ResponseEntity<>(roleObj, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@PutMapping()
	public ResponseEntity<Role> updateRole(@RequestBody Role role) {
		ResponseEntity<Role> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		roleService.createRole(role);
		return responseEntity;
	}
	
	@DeleteMapping()
	public ResponseEntity<Role> deleteAllRole() {
		ResponseEntity<Role> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		roleService.deleteAllRoles();
		return responseEntity;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Role> deleteAllRole(@PathVariable Long id) {
		ResponseEntity<Role> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		roleService.deleteRoleById(id);
		return responseEntity;
	}
	
	@GetMapping()
	public ResponseEntity<List<Role>> findAllRole() {
		ResponseEntity<List<Role>> responseEntity = null;
		List<Role> RoleList = roleService.getAllRoles();
		 responseEntity = new ResponseEntity<>(RoleList, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> findAllRole(@PathVariable Long id) {
		ResponseEntity<Role> responseEntity = null;
		Role Role = roleService.getRoleById(id).get();
		 responseEntity = new ResponseEntity<>(Role, HttpStatus.ACCEPTED);
		return responseEntity;
	}

}
