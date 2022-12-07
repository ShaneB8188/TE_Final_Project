package com.techelevator.controller;

import com.techelevator.dao.JdbcOrderDao;
import com.techelevator.dao.OrderDao;
import com.techelevator.model.NewOrderDto;
import com.techelevator.model.Order;
import com.techelevator.model.OrderStatusUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class OrderController {
  private final OrderDao orderDao;

  public OrderController (OrderDao orderDao) {
      this.orderDao=orderDao;

  }
  @ResponseStatus(HttpStatus.CREATED)
  @RequestMapping(path = "/orders", method = RequestMethod.POST)
    public Order createOrder (@RequestBody NewOrderDto order) {
      return orderDao.insertOrder(order);
  }

  @RequestMapping(path = "/orders/", method = RequestMethod.GET)
    public List<Order> getAllOrders () {
      return orderDao.getAllOrders();
  }

  @RequestMapping(path = "/orders/{id}", method = RequestMethod.GET)
    public Order getOrderById (int id) {
      return orderDao.getOrderById(id);
  }

  @RequestMapping(path = "/orders/{id}", method = RequestMethod.PUT)
    public Order updateOrder(int id, OrderStatusUpdateDto update) {
      return orderDao.updateOrderStatus(id,update);
  }
}
