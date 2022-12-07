package com.techelevator.controller;

import com.techelevator.dao.JdbcPizzaDao;
import com.techelevator.dao.PizzaDao;
import com.techelevator.model.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PizzaController {
    private final PizzaDao pizzaDao;
    private String API_BASE = ""; // need to determine what local host this is running on

    public PizzaController(PizzaDao pizzaDao) {
        this.pizzaDao=pizzaDao;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping (path = "/pizzas", method = RequestMethod.POST)
    public Pizza createPizza (@RequestBody Pizza newPizza) {
        return pizzaDao.createPizza(newPizza.getSize(), newPizza.getCrust(),newPizza.getSauce());
    }

    @RequestMapping (path= "/pizzas/{id}", method = RequestMethod.GET)
    public Pizza getPizzaById (int pizzaId) {
        return pizzaDao.getPizzaById(pizzaId);
    }
    //update pizza controller method
//    @RequestMapping (path= "/pizzas/{id}" method = RequestMethod.PUT)
//    public Pizza updatePizza (Pizza pizza) {
//        return
//    }
}
