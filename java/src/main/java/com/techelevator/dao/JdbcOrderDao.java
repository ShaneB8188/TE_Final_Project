package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.NewOrderDto;
import com.techelevator.model.OrderStatusUpdateDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcOrderDao implements OrderDao{

    private final JdbcTemplate jdbcTemplate;
    private OrderDao orderDao;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate, OrderDao orderDao){
        this.jdbcTemplate = jdbcTemplate;
        this.orderDao = orderDao;
    }


    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Order order = mapRowtoOrder(results);
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = new Order();
        String sql = "Select * from orders where order_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, orderId);
        while (results.next()){
            order = mapRowtoOrder(results);
        }
        return order;
    }

    @Override
    public Order insertOrder(NewOrderDto order) {
        Integer orderId = 0;
        Order newOrder = new Order();
        String sql = "INSERT into orders (order_time, order_status, price, isDelivery) VALUES (CURRENT_TIMESTAMP,?,?,?) returning order_id;";
        orderId = jdbcTemplate.queryForObject(sql, Integer.class, order.getOrderStatus(), order.getPrice(), order.isDelivery());
        newOrder = getOrderById(orderId);
        return newOrder;
    }

    @Override
    public Order updateOrderStatus(int orderId, OrderStatusUpdateDto updateDto) {
        String sql = "UPDATE orders SET order_status = ? WHERE order_id = ?;";
        jdbcTemplate.update(sql, updateDto.getOrderStatus(), orderId);
        return getOrderById(orderId);
    }

    private Order mapRowtoOrder(SqlRowSet rowSet){
        Order order = new Order();
        order.setOrderId(rowSet.getInt("order_id"));
        order.setDate(rowSet.getObject("order_time", LocalDateTime.class));
        order.setDelivery(rowSet.getBoolean("isDelivery"));
        order.setPrice(rowSet.getBigDecimal("price"));

        return order;
    }
}
