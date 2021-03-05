package com.szwec1;

import com.szwec1.model.Game;

import java.util.List;

public interface GameManager {
    void add(Game game);

    List<Game> getGames();
    void delete(Game game);
}
