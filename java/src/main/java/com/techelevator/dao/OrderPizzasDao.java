package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.Pizza;

import java.util.ArrayList;

public interface OrderPizzasDao {
    Order insertPizzasIntoOrder(ArrayList<Pizza> pizzaArrayList, int orderId);

    Order getOrderWithPizza(int orderId);

}
