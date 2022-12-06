package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDao {
    Order createNewOrder();


    List<Order> getAllOrders();

    Order getOrderById();



}
