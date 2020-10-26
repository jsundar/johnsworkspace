package com.hr.systems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.systems.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
