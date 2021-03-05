package com.szwec1;


import com.szwec1.interceptor.Logged;
import com.szwec1.model.Game;
import com.szwec1.model.gameModel;
import com.szwec1.qualifiers.AddEvent;
import com.szwec1.qualifiers.DeleteEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class GameBean {
    private String name;
    private double price;
    private int quantity;
    private String producer;

    @Inject
    @AddEvent
    private Event<Game> addGameEvent;

    @Inject
    @DeleteEvent
    private Event<Game> deleteGameEvent;

    @Inject
    private GameManager gameManagementService;

    @PostConstruct
    public List<Game> getGames() {
        return  gameManagementService.getGames();
    }

    @Logged
    public void addGame() {
        Game game = new gameModel(name, price, quantity, producer);
    }
    @Logged
    public void deleteGame() {
        Game game = new gameModel(name, price, quantity, producer);
        deleteGameEvent.fire(game);
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
