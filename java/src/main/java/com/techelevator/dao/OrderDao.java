package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.NewOrderDto;
import com.techelevator.model.OrderStatusUpdateDto;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();

    Order getOrderById(int orderId);

    Order insertOrder(NewOrderDto order);

    Order updateOrderStatus(int orderId, OrderStatusUpdateDto updateDto);



}
