package com.people.systems.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.people.systems.domain.Book;
import com.people.systems.domain.Library;
import com.people.systems.service.BookService;
import com.people.systems.service.LibraryService;

@RestController
@RequestMapping("/app/v1/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private LibraryService libraryService;
	
	@PostMapping("/")
	public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
		
		Library library = libraryService.getLibraryById(book.getLibrary().getId());
		if(library == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		book.setLibrary(library);
		
		Book savedBook = bookService.createBook(book);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId()).toUri();
		@SuppressWarnings("unchecked")
		ResponseEntity<Book> responeEntity = (ResponseEntity<Book>) ResponseEntity.created(location);
		return responeEntity;
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody @Valid Book book, @PathVariable Long id) {
		Library optionalLibrary = libraryService.getLibraryById(book.getLibrary().getId());
        if (optionalLibrary == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Book optionalBook = bookService.getBookById(id);
        if (optionalBook == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setLibrary(optionalLibrary);
        book.setId(optionalBook.getId());

        return ResponseEntity.noContent().build();
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
		Book optionalBook = bookService.getBookById(id);
        if (optionalBook == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        bookService.deleteByBookid(optionalBook.getId());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
    	Book optionalBook = bookService.getBookById(id);
        if (optionalBook == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalBook);
    }

    @GetMapping("/")
    public ResponseEntity<Page<Book>> getAll(Pageable pageable) {
        return ResponseEntity.ok(bookService.getAllBooks(pageable));
    }

}
