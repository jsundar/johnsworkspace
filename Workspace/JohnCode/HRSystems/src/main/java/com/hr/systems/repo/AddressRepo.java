package com.hr.systems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.systems.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
