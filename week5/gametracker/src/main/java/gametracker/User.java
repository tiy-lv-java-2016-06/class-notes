package gametracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeff on 7/12/16.
 */
public class User {
    private String name;
    private List<Game> games = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addGame(Game game){
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }
}
