package com.hr.systems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.systems.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
