package com.scm.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
