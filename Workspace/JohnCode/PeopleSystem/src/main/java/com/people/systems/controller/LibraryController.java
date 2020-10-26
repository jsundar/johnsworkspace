package com.people.systems.controller;

import java.net.URI;
import java.util.List;

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
@RequestMapping("/api/v1/libraries")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	@Autowired
	private BookService bookService;
	
	@PostMapping("/")
	public ResponseEntity<Library> create(@Valid @RequestBody Library library) {
		Library savedLibrary = libraryService.createLibrary(library);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedLibrary.getId()).toUri();
		@SuppressWarnings("unchecked")
		ResponseEntity<Library> response = (ResponseEntity<Library>) ResponseEntity.created(location);
		return response; 
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<Library> update(@PathVariable Long id, @Valid @RequestBody Library library) {
		Library libraryObj = libraryService.getLibraryById(id);
        if (libraryObj == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
	    library.setId(libraryObj.getId());
	    return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Library> delete(@PathVariable Long id) {
		Library libraryObj = libraryService.getLibraryById(id);
        if (libraryObj == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        libraryService.deleteByLibraryid(libraryObj.getId());

        return ResponseEntity.noContent().build();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable Long id) {
		Library libraryObj = libraryService.getLibraryById(id);
        if (libraryObj == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(libraryObj);
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getAllBooksById(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(bookService.getBookByLibraryId(id, pageable));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Library>> getAll(Pageable pageable) {
        return ResponseEntity.ok(libraryService.getAllLibraries(pageable));
    }

}
