package com.theironyard.pig;

import com.theironyard.pig.players.Player;

/**
 * Created by jeff on 6/21/16.
 */
public class Game {
    private Player player1;
    private Player player2;
    public static final int WINSCORE = 100;
    private Player winner = null;
    private Player currentPlayer = null;

    public Game(Player player1, Player player2){
        this.player1 = currentPlayer = player1;
        this.player2 = player2;
    }

    public void switchPlayer(){
        if(currentPlayer == player1){
            currentPlayer = player2;
        }
        else{
            currentPlayer = player1;
        }
    }

    public Player runGame(){
        System.out.println("Let's play some pig!!!!!");

        while(winner == null){
            Turn turn = new Turn(currentPlayer);
            currentPlayer.addScore(turn.runTurn());
            System.out.format("%s's score is now %d\n", currentPlayer.getName(), currentPlayer.getScore());

            if(currentPlayer.getScore() >= WINSCORE){
                winner = currentPlayer;
            }
            else{
                switchPlayer();
            }
        }

        System.out.format("Winner is %s with %d points\n", winner.getName(), winner.getScore());

        return winner;
    }

}
