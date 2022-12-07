package com.techelevator.controller;

import com.techelevator.dao.JdbcToppingDao;
import com.techelevator.dao.ToppingDao;
import com.techelevator.model.Toppings;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ToppingController {
    private final ToppingDao toppingDao;

    public ToppingController( ToppingDao toppingDao) {
        this.toppingDao=toppingDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/toppings", method = RequestMethod.POST)
    public Toppings createTopping(@RequestBody Toppings topping) {
        return toppingDao.createTopping(topping.getName(),topping.getPrice().doubleValue(),topping.isPremium());
    }
    // potential for this to cause floating point error in price if there is one its most likely this method

    @RequestMapping(path="/toppings/{id}", method = RequestMethod.GET)
    public Toppings getToppingById (int topId) {
        return toppingDao.getToppingById(topId);
    }
}
