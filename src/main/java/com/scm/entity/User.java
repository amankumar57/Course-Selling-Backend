package com.scm.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
   @Column(unique = true , nullable = false)
	private String email;
   
	@Column(nullable = false)
	private String Password;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	@OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<ShippingAddress> shippingAddresses;

    @OneToMany(mappedBy = "user")
    private List<Wishlist> wishlistItems;	
}

//@Column(nullable = false)
//private String name;

//@Column(unique = true , nullable = false)
//private String PhoneNumber;

// information
//private boolean enabled = false;
//private boolean emailVerified = false;
//private boolean phoneVerified = false;

// SELF  ,  Google  , Facebook  , Twitter , Linkedin , GitHub
//private Providers Provider = Providers.SELF;
//private String ProviderUserId;


//@ManyToMany
//@JoinTable(
//  name = "wishlist",
//  joinColumns = @JoinColumn(name = "user_id"),
//  inverseJoinColumns = @JoinColumn(name = "book_id")
//)
//private List<Book> wishlistBooks;
