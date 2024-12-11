package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Book;
import com.scm.repositery.BookRepo;

@Service
public class BookServiceImpl  implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> getAllBook() {	
	return bookRepo.findAll();
	}
	
	public boolean saveBook(Book book) {
		Book savedBook = bookRepo.save(book);
		if(savedBook.getId() !=null) {
			return true;
		}
		return false ;
	}


	public void deleteBook(Integer bookId) {
		// Hard Delete
	bookRepo.deleteById(bookId);
		
		// Soft Delete
//		Optional<Book> findbyId = bookRepo.findById(bookId);
//		if(findbyId.isPresent()) {
//			Book book = findbyId.get();
//		//	book.setActiveSW("N");
//			bookRepo.save(book);
//		}
		
	}

	public Book getBookById(Integer bookId) {
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
