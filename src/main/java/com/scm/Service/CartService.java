package com.scm.Service;

import java.util.List;

import com.scm.entity.Cart;

public interface CartService {
	
	 Cart addBookToCart(Integer userId, Integer bookId, int quantity);
	 
	    List<Cart> getUserCart(Integer userId);
	    
	    void removeBookFromCart(Integer userId, Integer bookId);

}
