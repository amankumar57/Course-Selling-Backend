package com.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Service.WishlistService;
import com.scm.entity.Wishlist;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController{

    @Autowired
    private WishlistService wishlistService;

    // GET all wishlist items
   // get Method :-    http://localhost:8080/api/wishlist
    @GetMapping
    public List<Wishlist> getAllWishlistItems() {
        return wishlistService.getAllWishlistItems();
    }

    // GET wishlist items by user ID
    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistItemsByUserId(@PathVariable Long userId) {
        return wishlistService.getWishlistItemsByUserId(userId);
    }

    // POST add an item to the wishlist
    @PostMapping
    public ResponseEntity<Wishlist> addWishlistItem(@RequestBody Wishlist wishlist) {
        Wishlist addedItem = wishlistService.addWishlistItem(wishlist);
        return new ResponseEntity<>(addedItem ,HttpStatus.OK);
    }

    // DELETE remove an item from the wishlist
    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<Void> removeWishlistItem(@PathVariable Long wishlistId) {
        wishlistService.removeWishlistItem(wishlistId);
        return ResponseEntity.noContent().build();
    }
}