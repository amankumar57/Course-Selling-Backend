package com.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Service.AuthorService;
import com.scm.entity.Author;

@RestController
@RequestMapping("/api/authors") // Base URL for all book-related operations
public class AuthorController {
    
	@Autowired
	private AuthorService authorService;
	
	// Retrieve all author
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthor();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    // Retrieve a single author by ID
    @GetMapping("/{id}")
    public ResponseEntity<Author> getauthorById(@PathVariable("id") Integer authorId) {
        Author author = authorService.getAuthorById(authorId);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Save a new author
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Author author) {
        boolean isSaved = authorService.saveAuthor(author);
        if (isSaved) {
            return new ResponseEntity<>("author saved successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save author", HttpStatus.BAD_REQUEST);
        }
    }

    // Update an existing author info
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable("id") Integer authorId, @RequestBody Author authorDeatils) {
        Author existingAuthor = authorService.getAuthorById(authorId);
        if (existingAuthor != null) {
            // Update the details
        	existingAuthor.setName(authorDeatils.getName());
        	existingAuthor.setBio(authorDeatils.getBio());
        	existingAuthor.setBooks(authorDeatils.getBooks());
            
            authorService.saveAuthor(existingAuthor);
            return new ResponseEntity<>("Author deatiles updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Author deatiles not found", HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    
    // delete author 
    // Retrieve a single author by name

   
}
