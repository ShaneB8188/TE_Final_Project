package com.techelevator.controller;


import com.techelevator.dao.SpecialtyDao;
import com.techelevator.dao.ToppingDao;
import com.techelevator.model.SpecialtyPizza;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SpecialPizzaController {
    private final SpecialtyDao SpecialtyDao;
    private final ToppingDao toppingDao;
    private String API_BASE = ""; // need to determine what local host this is running on

    public SpecialPizzaController(SpecialtyDao SpecialtyDao, ToppingDao toppingDao) {
        this.SpecialtyDao=SpecialtyDao;
        this.toppingDao=toppingDao;
    }
    @RequestMapping(path = "/SpecialtyPizza/{Id}", method = RequestMethod.GET)
    public SpecialtyPizza getPizzaById(int specialId){
        return SpecialtyDao.getSpecialById(specialId);
    }

    @RequestMapping(path= "/SpecialtyPizza", method = RequestMethod.GET)
    public List<SpecialtyPizza> getAllSpecialtyPizzas() {
        return SpecialtyDao.getAllSpecials();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/SpecialtyPizza", method=RequestMethod.POST)
    public SpecialtyPizza createNewSpecialtyPizza(@RequestBody SpecialtyPizza newPizza){
        SpecialtyPizza createdPizza = SpecialtyDao.createNewSpecial(newPizza.getName(), newPizza.getPizzaSize(), newPizza.getCrust(),newPizza.getSauce());
        if (newPizza.getToppings() != null){
        createdPizza.setToppings(newPizza.getToppings());
        }
            return createdPizza;
    }

}
