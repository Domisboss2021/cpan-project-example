package com.szwec1.model;

public abstract class Game {
    private String name;
    private double price;
    private int quantity;
    private String producer;

    public Game(String name, double price, int quantity, String producer ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
