 package com.scm.entity;
  import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import  jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import  jakarta.persistence.Id;
import  jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
  

  @Entity
  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  @Setter
  @Getter
  @Table
  public class Wishlist {
  
  //id, userId, bookId
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonIgnore
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "book_id", nullable = false)
	    @JsonIgnore
	    private Book book;

	    private LocalDate addedDate;
  
  }
 