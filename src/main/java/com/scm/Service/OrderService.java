package com.scm.Service;

import java.util.List;

import com.scm.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrders();

    Order getOrderById(Integer orderId);

    List<Order> getOrdersByUserId(Integer userId);

    Order createOrder(Order order);

    void deleteOrder(Integer orderId);

    Order updateOrderStatus(Integer orderId, String status);

}
