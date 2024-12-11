package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Author;
import com.scm.repositery.AuthorRepo;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepo authorRepo;
	
	public List<Author> getAllAuthor() {
		return authorRepo.findAll();
		}
	
		public boolean saveAuthor(Author author) {
			Author savedAuthor = authorRepo.save(author);
			if(savedAuthor.getId() !=null) {
				return true;
			} return false ; }

		public void deleteAuthor(Integer authorId) {
		authorRepo.deleteById(authorId);
		}

		public Author getAuthorById(Integer authorId) {
			Optional<Author> findById = authorRepo.findById(authorId);
			if(findById.isPresent()) {
				return findById.get();
			}
			return null;
		}


}
