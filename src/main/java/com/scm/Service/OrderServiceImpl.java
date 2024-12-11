package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Order;
import com.scm.repositery.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{
	
	 @Autowired
	    private OrderRepo orderRepo;

	    @Override
	    public List<Order> getAllOrders() {
	        return orderRepo.findAll();    }

	    @Override
	    public Order getOrderById(Integer orderId) {
	        Optional<Order> order = orderRepo.findById(orderId);
	        return order.orElse(null);    }

	    @Override
	    public List<Order> getOrdersByUserId(Integer userId) {
	        return orderRepo.findByUserId(userId);    }

	    @Override
	    public Order createOrder(Order order) {
	        return orderRepo.save(order);  }

	    @Override
	    public void deleteOrder(Integer orderId) {
	        orderRepo.deleteById(orderId);    }

	    @Override
	    public Order updateOrderStatus(Integer orderId, String status) {
	        Optional<Order> orderOpt = orderRepo.findById(orderId);
	        if (orderOpt.isPresent()) {
	            Order order = orderOpt.get();
	            order.setStatus(status);
	            return orderRepo.save(order);
	        }
	        return null;
	    }
	}