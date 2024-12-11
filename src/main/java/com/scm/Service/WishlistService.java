package com.scm.Service;

import java.util.List;

import com.scm.entity.Wishlist;

public interface WishlistService {
	
	List<Wishlist> getAllWishlistItems();

    List<Wishlist> getWishlistItemsByUserId(Long userId);

    Wishlist addWishlistItem(Wishlist wishlist);

    void removeWishlistItem(Long wishlistId);

}
