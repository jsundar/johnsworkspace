package com.people.systems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people.systems.domain.Library;

public interface LibraryRepository extends JpaRepository<Library, Long>{

}
