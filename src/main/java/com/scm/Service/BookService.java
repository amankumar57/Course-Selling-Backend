package com.scm.Service;

import java.util.List;

import com.scm.entity.Book;

public interface BookService {
	
public List<Book> getAllBook();
	
	public boolean saveBook(Book book);
	
	public void deleteBook(Integer bookId);
	
	public Book getBookById(Integer bookId);

}
