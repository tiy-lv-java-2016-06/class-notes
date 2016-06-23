package com.theironyard.pig.players;

import com.theironyard.pig.Die;

/**
 * Created by jeff on 6/22/16.
 */
public abstract class AbstractPlayer implements Player{
    private String name;
    private int score;
    private Die die;

    public AbstractPlayer(String name) {
        this.name = name;
        score = 0;
        die = new Die();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public int addScore(int score) {
        this.score += score;
        return this.score;
    }


    public int roll() {
        return this.die.roll();
    }
}
