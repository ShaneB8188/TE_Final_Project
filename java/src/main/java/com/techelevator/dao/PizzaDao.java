package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Toppings;

import java.util.ArrayList;

public interface PizzaDao {

    Pizza getPizzaById(int pizzaId);

    Pizza createPizza(String size, String crust, String sauce);

    Pizza getPizzaToppings(int pizzaId);

    Pizza insertToppingsOnPizza(ArrayList<Toppings> toppingsList, int pizzaId);

    Pizza getPizzaWithToppings(int pizzaId);
}
