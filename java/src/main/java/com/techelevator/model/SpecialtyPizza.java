package com.techelevator.model;


import java.util.List;

public class SpecialtyPizza {
    int pizzaId;
    String name;
    String size;
    String crust;
    String sauce;
    List<Toppings> toppings;

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPizzaSize() {
        return size;
    }

    public void setPizzaSize(String pizzaSize) {
        this.size = pizzaSize;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }
}
