package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Category;
import com.scm.repositery.CategoryRepo;

@Service
public class CategoryServive {
	
	@Autowired
	private CategoryRepo categroyRepo;
	
	public List<Category> getAllCategory() {
		return categroyRepo.findAll();	
		}
	
		public boolean saveCategory(Category category) {
			Category savedCategory = categroyRepo.save(category);
			if(savedCategory.getId() !=null) {
				return true;
			}
			return false ;
		}

		public boolean deleteCategory(Integer authorId) {
			// Hard Delete
			if(categroyRepo.existsById(authorId)) {
			categroyRepo.deleteById(authorId);
			return true;
			}else {
				return false;
			}
			
			// Soft Delete
//			Optional<Author> findbyId = authorRepo.findById(authorId);
//			if(findbyId.isPresent()) {
//				Author author = findbyId.get();
//			//	book.setActiveSW("N");
//				authorRepo.save(author);
//			}
			
		}

		public Category getCategoryById(Integer categoryId) {
			Optional<Category> findById = categroyRepo.findById(categoryId);
			if(findById.isPresent()) {
				return findById.get();
			}
			return null;
		}
		
		

}
