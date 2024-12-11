package com.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Service.CartService;
import com.scm.entity.Cart;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
    private CartService cartService;

    // Add book to cart
	//http://localhost:8080/cart/add?userId=2&bookId=4&quantity=2
    @PostMapping("/add")
    public ResponseEntity<String> addBookToCart(@RequestParam Integer userId, @RequestParam Integer bookId, @RequestParam int quantity) {
        Cart cart = cartService.addBookToCart(userId, bookId, quantity);
        if (cart != null) {
            return ResponseEntity.ok("Book added to cart");
        } else {
            return ResponseEntity.badRequest().body("Failed to add book to cart");
        }}

    // Get user cart
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable Integer userId) {
        List<Cart> cart = cartService.getUserCart(userId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Remove book from cart
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeBookFromCart(@RequestParam Integer userId, @RequestParam Integer bookId) {
        cartService.removeBookFromCart(userId, bookId);
        return ResponseEntity.ok("Book removed from cart");
    }

}
