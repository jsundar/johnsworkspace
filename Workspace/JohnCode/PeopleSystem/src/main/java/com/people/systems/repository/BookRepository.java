package com.people.systems.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.people.systems.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByLibraryId(Long libraryId, Pageable pageable);
}
