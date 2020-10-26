package com.people.systems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.people.systems.domain.Library;
import com.people.systems.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepo;
	
	public Library createLibrary(Library library) {
		return libraryRepo.save(library);
	}
	
	public List<Library> createLibraries(List<Library> libraries) {
		return libraryRepo.saveAll(libraries);
	}
	
	public Library updateLibrary(Library library) {
		return libraryRepo.save(library);
	}
	
	public void deleteAllLibraies() {
		libraryRepo.deleteAll();
	}
	
	public void deleteByLibraryid(Long id) {
		libraryRepo.deleteById(id);
	}

	public Library getLibraryById(Long id) {
		Optional<Library> optionalLibrary = libraryRepo.findById(id);
		Library library = null;
		if(optionalLibrary.isPresent()) {
			library = optionalLibrary.get();
		}
		return library;
	}
	
	public List<Library> getAllLibraries() {
		return libraryRepo.findAll();
	}
	
	public Page<Library> getAllLibraries(Pageable pageable) {
		return libraryRepo.findAll(pageable);
	}
}
