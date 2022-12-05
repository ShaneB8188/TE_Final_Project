package com.techelevator.dao;

import com.techelevator.model.Pizza;

public interface PizzaDao {

    Pizza getPizzaById(int pizzaId);

    boolean createPizza(String size, String crust, String sauce);

    Pizza getPizzaToppings(int pizzaId);
}
