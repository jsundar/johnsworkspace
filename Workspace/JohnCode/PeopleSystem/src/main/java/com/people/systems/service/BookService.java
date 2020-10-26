package com.people.systems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.people.systems.domain.Book;
import com.people.systems.domain.Library;
import com.people.systems.repository.BookRepository;
import com.people.systems.repository.LibraryRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> createBooks(List<Book> libraries) {
		return bookRepo.saveAll(libraries);
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	public void deleteAllBooks() {
		bookRepo.deleteAll();
	}
	
	public void deleteByBookid(Long id) {
		bookRepo.deleteById(id);
	}

	public Book getBookById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		Book book = null;
		if(optionalBook.isPresent()) {
			book = optionalBook.get();
		}
		return book;
	}
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public List<Book> getBookByLibraryId(Long libraryId, Pageable pageable) {
		return bookRepo.findByLibraryId(libraryId, pageable);
	}
	
	public Page<Book> getAllBooks(Pageable pageable) {
		return bookRepo.findAll(pageable);
	}

}
