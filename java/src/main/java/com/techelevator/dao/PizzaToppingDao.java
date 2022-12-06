package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Toppings;

import java.util.ArrayList;

public interface PizzaToppingDao {
    Pizza insertToppingsOnPizza(ArrayList<Toppings> toppingsList, int pizzaId);

    Pizza getPizzaWithToppings(int pizzaId);
}
