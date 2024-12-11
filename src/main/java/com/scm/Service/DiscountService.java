package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Discount;
import com.scm.repositery.DiscountRepo;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepo discountRepo;

    // Get all discounts
    public List<Discount> getAllDiscounts() {
        return discountRepo.findAll();  }

    // Save a discount
    public Discount saveDiscount(Discount discount) {
        return discountRepo.save(discount);    }

    // Get discount by ID
    public Discount getDiscountById(Integer discountId) {
        Optional<Discount> discount = discountRepo.findById(discountId);
        return discount.orElse(null);    }

    // Delete a discount by ID
    public void deleteDiscount(Integer discountId) {
        discountRepo.deleteById(discountId);       }

    // Update a discount
    public Discount updateDiscount(Integer discountId, Discount discountDetails) {
        Discount discount = getDiscountById(discountId);
        if (discount != null) {
            discount.setCode(discountDetails.getCode());
            discount.setDiscountAmount(discountDetails.getDiscountAmount());
            discount.setExprirationDate(discountDetails.getExprirationDate());
            return discountRepo.save(discount);
        }
        return null;
    }
}
