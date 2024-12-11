package com.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Service.CategoryServive;
import com.scm.entity.Category;

@RestController
@RequestMapping("/api/category") 
public class CategoryController {
	
	@Autowired
	private CategoryServive categoryServive;
	
	// Retrieve all category
    @GetMapping
    public ResponseEntity<List<Category>> getAllAuthors() {
        List<Category> category = categoryServive.getAllCategory();
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // Retrieve a single category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer categoryId) {
        Category category = categoryServive.getCategoryById(categoryId);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Save a new category
    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        boolean isSaved = categoryServive.saveCategory(category);
        if (isSaved) {
            return new ResponseEntity<>("category saved successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save category", HttpStatus.BAD_REQUEST);
        } }

    // Update an existing category
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") Integer categoryId, @RequestBody Category categoryDeatils) {
        Category existingCatehory = categoryServive.getCategoryById(categoryId);
        if (existingCatehory != null) {
            // Update the details
        	existingCatehory.setName(categoryDeatils.getName());  
        	categoryServive.saveCategory(existingCatehory);
            return new ResponseEntity<>("Author deatiles updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Author deatiles not found", HttpStatus.NOT_FOUND);
        } }

    // delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteCategory(@PathVariable("id") Integer categoryId){
    	    	if( categoryServive.deleteCategory(categoryId)) {
    	return new ResponseEntity<>("Category delete ",HttpStatus.OK);
    	    	}else {
    	    		return new ResponseEntity<>("category not avalible",HttpStatus.OK);
    	    	}
    }

}
