package com.szwec1;

import com.szwec1.model.gameModel;
import com.szwec1.model.Game;
import com.szwec1.qualifiers.AddEvent;
import com.szwec1.qualifiers.DeleteEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GameManagementService implements GameManager {
    private List<Game> games;

    @PostConstruct
    public void addGameModel() {
        games = new ArrayList<>();
        games.add(new gameModel("Fallout 4", 19.99, 5, "Bethesda"));
        games.add(new gameModel("GTA 5", 29.99, 20, "Rockstar"));
        games.add(new gameModel("Cyberpunk 2077", 69.99, 30, "CD Projekt"));
    }

    @Override
    public void add(@Observes @AddEvent Game game) {
        games.add(game);
    }

    @Override
    public List<Game> getGames() {
        return games;
    }

    @Override
    public void delete(@Observes @DeleteEvent Game game) {
        Game deletedGame = games.stream().filter(game1 -> game1.getName().equals(game.getName())).findFirst().orElse(null);
        games.remove(deletedGame);
    }
}
