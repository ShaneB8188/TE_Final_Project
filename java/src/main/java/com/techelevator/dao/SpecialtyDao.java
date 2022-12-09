package com.techelevator.dao;

import com.techelevator.model.SpecialtyPizza;
import com.techelevator.model.Toppings;

import java.util.List;

public interface SpecialtyDao {

    List<SpecialtyPizza> getAllSpecials();

    SpecialtyPizza getSpecialById(int specialId);

    SpecialtyPizza createNewSpecial(String name, String pizzaSize, String crust, String sauce);

    SpecialtyPizza getSpecialsPizzaWithToppings(int specialId);

    SpecialtyPizza addToppingsToPizza(List<Toppings> toppingsList, int pizzaId);
}
