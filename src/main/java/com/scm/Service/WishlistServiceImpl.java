package com.scm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Wishlist;
import com.scm.repositery.WishlistRepo;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepo wishlistRepo;

    @Override
    public List<Wishlist> getAllWishlistItems() {
        return wishlistRepo.findAll();
    }
    @Override
    public List<Wishlist> getWishlistItemsByUserId(Long userId) {
        return wishlistRepo.findByUserId(userId);
    }
@Override
    public Wishlist addWishlistItem(Wishlist wishlist) {
        wishlist.setAddedDate(java.time.LocalDate.now());
        return wishlistRepo.save(wishlist);
    }
    @Override
    public void removeWishlistItem(Long wishlistId) {
   //    wishlistRepo.deleteById(wishlistId);
    
    }
}
