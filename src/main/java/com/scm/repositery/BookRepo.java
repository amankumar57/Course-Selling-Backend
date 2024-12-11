package com.scm.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Book;

  public interface BookRepo extends JpaRepository<Book, Integer> {
	
	

}
