package com.techelevator.classes;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private LocalDateTime date;
    private BigDecimal price;
    private boolean isDelivery;


    public Order() {

    }

    public Order(int orderId, LocalDateTime date, BigDecimal price, boolean isDelivery) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.isDelivery = isDelivery;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }
}
