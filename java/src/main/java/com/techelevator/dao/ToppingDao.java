package com.techelevator.dao;

import com.techelevator.model.Toppings;

public interface ToppingDao {

    Toppings getToppingById(int toppingId);

    Toppings createTopping(String name, double price, boolean isPremium);
}
