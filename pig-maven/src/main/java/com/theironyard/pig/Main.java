package com.theironyard.pig;

import com.theironyard.pig.players.Hit24AI;
import com.theironyard.pig.players.Player;
import com.theironyard.pig.players.ScaredyCatAI;

/**
 * Created by jeff on 6/21/16.
 */
public class Main {

    public static void main(String[] args) {
        Player player1 = new Hit24AI("Fred");
        Player player2 = new ScaredyCatAI("Shaggy");
        Game game = new Game(player1, player2);
        game.runGame();
    }
}
