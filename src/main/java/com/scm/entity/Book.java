package com.scm.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import 	jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String title;
	private double price;
	private Long sku;
	private Long page;
	private String language;
	private String description;
	private String weight;
	 @NotNull(message = " field is requerd Dimensions")
	private String Dimensions;
	 @NotNull(message = " field is requerd Publication Date")
	private String PublicationDate;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "author_id")
       @JsonIgnore
	    private Author author;

	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    @JsonIgnore
	    private Category category;

	    @OneToMany(mappedBy = "book")
	    @JsonIgnore
	    private List<Review> reviews;

	    @ManyToMany(mappedBy = "books")
	    @JsonIgnore
	    private List<Cart> carts;
	    
	    @OneToMany(mappedBy = "book")
	    private List<Wishlist> wishlistUsers;
    

}
