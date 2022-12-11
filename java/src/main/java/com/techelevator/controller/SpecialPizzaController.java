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
    private final String API_BASE = "/SpecialtyPizzas"; // need to determine what local host this is running on

    public SpecialPizzaController(SpecialtyDao SpecialtyDao, ToppingDao toppingDao) {
        this.SpecialtyDao=SpecialtyDao;
        this.toppingDao=toppingDao;
    }
    @RequestMapping(path = API_BASE + "/{Id}", method = RequestMethod.GET)
    public SpecialtyPizza getPizzaById(int specialId){
        return SpecialtyDao.getSpecialById(specialId);
    }

    @RequestMapping(path= API_BASE, method = RequestMethod.GET)
    public List<SpecialtyPizza> getAllSpecialtyPizzas() {
        return SpecialtyDao.getAllSpecials();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path= API_BASE, method=RequestMethod.POST)
    public SpecialtyPizza createNewSpecialtyPizza(@RequestBody SpecialtyPizza newPizza){
        SpecialtyPizza createdPizza = SpecialtyDao.createNewSpecial(newPizza.getName(), newPizza.getPizzaSize(), newPizza.getCrust(),newPizza.getSauce());
        if (newPizza.getToppings() != null){
            SpecialtyDao.addToppingsToPizza(newPizza.getToppings(), createdPizza.getPizzaId());
            createdPizza.setToppings(newPizza.getToppings());
        }
        return createdPizza;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path= API_BASE + "/{id}", method=RequestMethod.PUT)
    public SpecialtyPizza updateSpecialtyPizza(@RequestBody SpecialtyPizza newPizza){
        SpecialtyPizza createdPizza = SpecialtyDao.updateSpecial(newPizza.getPizzaId(), newPizza.getName(), newPizza.getPizzaSize(), newPizza.getCrust(),newPizza.getSauce());
        if (newPizza.getToppings() != null){
            SpecialtyDao.addToppingsToPizza(newPizza.getToppings(), newPizza.getPizzaId());
            createdPizza.setToppings(newPizza.getToppings());
        }
        return createdPizza;
    }
    

}
