package com.scm.repositery;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{
	
	// Find orders by user ID
    List<Order> findByUserId(Integer userId);

    // Find orders by status
    List<Order> findByStatus(String status);

    // Find orders by date range
    List<Order> findByOrderDateBetween(Date startDate, Date endDate);

}
