package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Toppings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;

public class JdbcPizzaToppingDao implements PizzaToppingDao{
    private final JdbcTemplate jdbcTemplate;
    private PizzaToppingDao pizzaToppingDao;
    private ToppingDao toppingDao;

    public JdbcPizzaToppingDao(JdbcTemplate jdbcTemplate, PizzaToppingDao pizzaToppingDao, ToppingDao toppingDao){
        this.jdbcTemplate = jdbcTemplate;
        this.pizzaToppingDao = pizzaToppingDao;
        this.toppingDao = toppingDao;
    }

    @Override
    public Pizza insertToppingsOnPizza(ArrayList<Toppings> toppingsList, int pizzaId) {
        Pizza newPizza = new Pizza();
        Integer newPizzaId = 0;
        for (Toppings topping : toppingsList){
            String sql = "INSERT into pizza_toppings (pizza_id, topping_id) VALUES (?, ?) returning pizza_id;";
            newPizzaId = jdbcTemplate.queryForObject(sql, Integer.class, pizzaId, topping.getToppingId());
            newPizza = getPizzaWithToppings(newPizzaId);
        }
        return newPizza;
    }

    @Override
    public Pizza getPizzaWithToppings(int pizzaId) {
        Pizza pizza = new Pizza();
        ArrayList<Toppings> toppingsArrayList = new ArrayList<>();
        String sql = "SELECT topping_id from pizza_toppings where pizza_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, pizzaId);
        while (results.next()){
            int toppingIdToInsert = results.getInt("topping_id");
            toppingsArrayList.add(toppingDao.getToppingById(toppingIdToInsert));
        }
        pizza.setToppingsArrayList(toppingsArrayList);
        return pizza;
    }
}
