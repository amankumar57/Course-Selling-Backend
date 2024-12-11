package com.scm.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scm.entity.Discount;

public interface DiscountRepo extends JpaRepository<Discount, Integer>{

	// Custom JPQL query to find discounts by code
    @Query("SELECT d FROM Discount d WHERE d.code = :code")
    List<Discount> findDiscountsByCode(@Param("code") String code);

    // Custom native SQL query to find discounts that haven't expired
    @Query(value = "SELECT * FROM Discount d WHERE d.expriration_date > CURRENT_DATE", nativeQuery = true)
    List<Discount> findActiveDiscounts();

    // Custom JPQL query to find discounts with discountAmount greater than a certain value
    @Query("SELECT d FROM Discount d WHERE d.discountAmount > :amount")
    List<Discount> findDiscountsWithAmountGreaterThan(@Param("amount") String amount);

    // Custom JPQL query to search for discounts by code, using like (partial match)
    @Query("SELECT d FROM Discount d WHERE d.code LIKE %:code%")
    List<Discount> searchDiscountsByCode(@Param("code") String code);
}
