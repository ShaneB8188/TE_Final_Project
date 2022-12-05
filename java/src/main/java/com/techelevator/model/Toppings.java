package com.techelevator.model;

import java.math.BigDecimal;

public class Toppings {
    private String name;
    private int toppingId;
    private BigDecimal price;
    private boolean isPremium;
    private boolean isAvailable;

    public Toppings(String name, int toppingId, BigDecimal price, boolean isPremium, boolean isAvailable) {
        this.name = name;
        this.toppingId = toppingId;
        this.price = price;
        this.isPremium = isPremium;
        this.isAvailable = isAvailable;
    }
    public Toppings() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}