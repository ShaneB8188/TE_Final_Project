package com.techelevator.dao;

import com.techelevator.classes.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcPizzaDao implements PizzaDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPizzaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Retrieve a pizza from the database using the pizzaId integer associated with pizza_id. Should return toppings as well.
     * @param pizzaId the Id associated with a unique pizza object
     * @return a pizza object with all values
     */
    @Override
    public Pizza getPizzaById(int pizzaId) {
        String sql="SELECT * FROM pizza " +
                "JOIN pizza_toppings ON pizza.pizza_id = pizza_toppings.pizza_id " +
                "JOIN  WHERE pizza_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, pizzaId);
        if (results.next()) {
            return mapRowToPizza(results);
        } else {
            return null;
        }
    }

    /**
     * Create a new pizza in the pizza table. Note that no toppings are associated here.
     * @param size String indicating pizza size
     * @param crust String indicating pizza crust type
     * @param sauce String indicating pizza sauce type
     * @return if the pizza has been created with a new id int
     */
    @Override
    public boolean createPizza(String size, String crust, String sauce) {
        String insertToppingSql = "INSERT into pizza (pizza_size, crust, sauce) VALUES (?, ?, ?) RETURNING pizza_id";
        Integer newPizzaId;
        newPizzaId = jdbcTemplate.queryForObject(insertToppingSql, Integer.class, size, crust, sauce);
        return newPizzaId != null;
    }


    private Pizza mapRowToPizza(SqlRowSet rowSet) {
        Pizza pizza = new Pizza();
        pizza.setPizzaId(rowSet.getInt("pizza_id"));
        pizza.setSize(rowSet.getString("pizza_size"));
        pizza.setCrust(rowSet.getString("crust"));
        pizza.setSauce(("sauce"));

    }

}
