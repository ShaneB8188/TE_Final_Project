package com.techelevator.dao;

import com.techelevator.model.SpecialtyPizza;
import com.techelevator.model.Toppings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcSpecialtyDao implements SpecialtyDao{
    private final JdbcTemplate jdbc;
    private final ToppingDao toppingDao;


    public JdbcSpecialtyDao(JdbcTemplate jdbc, ToppingDao toppingDao) {
        this.jdbc = jdbc;
        this.toppingDao = toppingDao;
    }

    @Override
    public SpecialtyPizza getSpecialById(int specialId) {
        String sql = "SELECT pizza_id FROM specialty_pizza WHERE pizza_id = ?";
        SqlRowSet results = jdbc.queryForRowSet(sql, specialId);
        if (results.next()) {

        }return mapRowToSpecial(results);
    }


    @Override
    public SpecialtyPizza createNewSpecial(int pizzaId, String name, String pizzaSize, String crust, String sauce) {
        String sql = "INSERT INTO specialty_pizzas(pizza_id, name, pizza_size, crust, sauce) VALUES (?,?,?,?,?) ";


        Integer newPizzaId = jdbc.queryForObject(sql, Integer.class, pizzaId, name, pizzaSize, crust, sauce);
        if (newPizzaId != null) {

        }return getSpecialById(newPizzaId);
    }

    @Override
    public SpecialtyPizza getSpecialsPizzaWithToppings(int specialId) {
        SpecialtyPizza pizza = new SpecialtyPizza();
        List<Toppings>toppingsList = new ArrayList<>();
        String sql = "SELECT topping_id FROM specialty_pizza_toppings WHERE pizza_id = ? ";
        SqlRowSet results = jdbc.queryForRowSet(sql,specialId);
        while(results.next()){
            int insert = results.getInt("topping_id");
            toppingsList.add(toppingDao.getToppingById(insert));

        }
        pizza.setToppings(toppingsList);
        return pizza;
    }

    @Override
    public SpecialtyPizza addToppingsToPizza(List<Toppings> toppingsList, int pizzaId ) {
        SpecialtyPizza pizza = new SpecialtyPizza();
        int newSpecialId = 0;
        for(Toppings topping: toppingsList){
            String sql = "INSERT INTO specialty_pizza_toppings (pizza_id, topping_id) VALUES (?,?) RETURNING pizza_id";


            newSpecialId = jdbc.queryForObject(sql, Integer.class, pizzaId, topping.getToppingId());
            pizza = getSpecialsPizzaWithToppings(newSpecialId);
        }
        return pizza;
    }
    private SpecialtyPizza mapRowToSpecial(SqlRowSet rowSet){
        SpecialtyPizza special = new SpecialtyPizza();
        special.setPizzaId(rowSet.getInt("topping_id"));
        special.setPizzaName(rowSet.getString("name"));
        special.setCrust(rowSet.getString("crust"));
        special.setSauce(rowSet.getString("sauce"));
        special.setPizzaSize(rowSet.getString("pizza_size"));

        return special;
    }


}
