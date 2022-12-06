package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;

public class JdbcOrderPizzasDao implements OrderPizzasDao{
    private final JdbcTemplate jdbcTemplate;
    private OrderPizzasDao orderPizzasDao;
    private PizzaDao pizzaDao;

    public JdbcOrderPizzasDao(JdbcTemplate jdbcTemplate, OrderPizzasDao orderPizzasDao, PizzaDao pizzaDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.orderPizzasDao = orderPizzasDao;
        this.pizzaDao = pizzaDao;
    }

    @Override
    public Order insertPizzasIntoOrder(ArrayList<Pizza> pizzaArrayList, int orderId) {
        Order newOrder = new Order();
        Integer newOrderId = 0;
        for (Pizza pizza : pizzaArrayList){
            String sql = "INSERT into order_pizza (order_id, pizza_id) VALUES (?, ?) returning order_id;";
            newOrderId = jdbcTemplate.queryForObject(sql, Integer.class, orderId, pizza.getPizzaId());
        }
        newOrder = getOrderWithPizza(newOrderId);
        return newOrder;
    }

    @Override
    public Order getOrderWithPizza(int orderId) {
        Order order = new Order();
        ArrayList<Pizza> pizzaArrayList = new ArrayList<>();
        String sql = "SELECT pizza_id from order_pizza where order_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, orderId);
        while (results.next()){
            int pizzaIdToInsert = results.getInt("pizza_id");
            pizzaArrayList.add(pizzaDao.getPizzaById(pizzaIdToInsert));
        }
        order.setPizzaArrayList(pizzaArrayList);
        return order;
    }
}
