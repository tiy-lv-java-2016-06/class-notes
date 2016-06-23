package com.theironyard.pig.players;

/**
 * Created by jeff on 6/22/16.
 */
public interface Player {

    String getName();
    int addScore(int score);
    boolean rollAgain(int turnScore);
    int roll();
    int getScore();
}
