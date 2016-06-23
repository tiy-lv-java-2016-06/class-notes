package com.theironyard.pig.players;

/**
 * Created by jeff on 6/22/16.
 */
public class ScaredyCatAI extends AbstractPlayer{

    public ScaredyCatAI(String name) {
        super(name);
    }

    public boolean rollAgain(int turnScore){
        return false;
    }

}
