package com.hr.systems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.systems.domain.Role;
import com.hr.systems.repository.RoleRepo;

@Service
public class RoleService {
	@Autowired
	private RoleRepo roleRepo;

	public Role createRole(Role role) {
		return roleRepo.save(role);
	}

	public void deleteAllRoles() {
		roleRepo.deleteAll();
	}

	public void deleteRoleById(Long id) {
		roleRepo.deleteById(id);
	}

	public void deleteRole(Role role) {
		roleRepo.delete(role);
	}

	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

	public Optional<Role> getRoleById(Long id) {
		return roleRepo.findById(id);
	}
}
