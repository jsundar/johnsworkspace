package com.hr.systems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.systems.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
