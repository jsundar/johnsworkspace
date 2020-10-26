package com.hr.systems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.systems.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
