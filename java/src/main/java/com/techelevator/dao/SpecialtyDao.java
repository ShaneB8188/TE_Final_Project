package com.techelevator.dao;

import com.techelevator.model.SpecialtyPizza;
import com.techelevator.model.Toppings;

import java.util.List;

public interface SpecialtyDao {

    SpecialtyPizza getSpecialById(int specialId);

    SpecialtyPizza createNewSpecial(String name, String pizzaSize, String crust, String sauce);

    SpecialtyPizza getSpecialsPizzaWithToppings(int specialId);

    SpecialtyPizza addToppingsToPizza(List<Toppings> toppingsList, int pizzaId);
    List<SpecialtyPizza> getAllPizzas();
}
