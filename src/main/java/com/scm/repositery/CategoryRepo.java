package com.scm.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
