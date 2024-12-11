package com.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Service.BookService;
import com.scm.entity.Book;

@RestController
@RequestMapping("/api/books") // Base URL for all book-related operations
public class BookController {

    @Autowired
    private BookService bookService;

    // Retrieve all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
         List<Book> allBook = bookService.getAllBook();
        return new ResponseEntity<>(allBook, HttpStatus.OK);
    }

    // Retrieve a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Save a new book
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        boolean isSaved = bookService.saveBook(book);
        if (isSaved) {
            return new ResponseEntity<>("Book saved successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save book", HttpStatus.BAD_REQUEST);
        } }
    // Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Integer bookId, @RequestBody Book bookDetails) {
        Book existingBook = bookService.getBookById(bookId);
        if (existingBook != null) {
            // Update the details
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setPrice(bookDetails.getPrice());
            existingBook.setSku(bookDetails.getSku());
            existingBook.setPage(bookDetails.getPage());
            existingBook.setLanguage(bookDetails.getLanguage());
            existingBook.setDescription(bookDetails.getDescription());
            existingBook.setWeight(bookDetails.getWeight());
            existingBook.setDimensions(bookDetails.getDimensions());
            existingBook.setPublicationDate(bookDetails.getPublicationDate());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setCategory(bookDetails.getCategory());
            
            bookService.saveBook(existingBook);
            return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    // Hard delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            bookService.deleteBook(bookId);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }}