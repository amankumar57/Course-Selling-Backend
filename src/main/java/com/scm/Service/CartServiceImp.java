package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Book;
import com.scm.entity.Cart;
import com.scm.entity.User;
import com.scm.repositery.BookRepo;
import com.scm.repositery.CartRepo;
import com.scm.repositery.UserRepo;

@Service
public class CartServiceImp implements CartService{
	
	@Autowired
    private CartRepo cartRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Cart addBookToCart(Integer userId, Integer bookId, int quantity) {
        Optional<User> userOptional = userRepo.findById(userId);
        Optional<Book> bookOptional = bookRepo.findById(bookId);

        if (userOptional.isPresent() && bookOptional.isPresent()) {
            User user = userOptional.get();
            Book book = bookOptional.get();

            // Check if the user already has a cart
            Cart cart = cartRepo.findByUser(user).orElse(new Cart());
            cart.setUser(user);
            
            // Add the book to the cart
            List<Book> books = cart.getBooks();
            if (books != null) {
            	 books.add(book);   
                 books.add(book);
                 cart.setBooks(books);
                 cart.setQuantity(quantity);
            }
            // Save and return the cart
            return cartRepo.save(cart);
        }
        return null;
    }

    @Override
    public List<Cart> getUserCart(Integer userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            return cartRepo.findAllByUser(userOptional.get());
        }
        return null;
    }

    @Override
    public void removeBookFromCart(Integer userId, Integer bookId) {
        Optional<User> userOptional = userRepo.findById(userId);
        Optional<Book> bookOptional = bookRepo.findById(bookId);

        if (userOptional.isPresent() && bookOptional.isPresent()) {
            User user = userOptional.get();
            Book book = bookOptional.get();

            // Get the cart of the user
            Optional<Cart> cartOptional = cartRepo.findByUser(user);
            if (cartOptional.isPresent()) {
                Cart cart = cartOptional.get();

                // Remove the book from the cart
                cart.getBooks().remove(book);

                // Save the updated cart
                cartRepo.save(cart);
            }
        }
    }
}
