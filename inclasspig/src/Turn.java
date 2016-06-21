/**
 * Created by jeff on 6/21/16.
 */
public class Turn {
    private Player player;
    private int score = 0;

    public Turn(Player player){
        this.player = player;
    }

    public int runTurn(){

        boolean turnOver = false;

        System.out.format("It is %s's turn to roll\n", player.getName());
        do {
            int roll = player.roll();
            System.out.format("You rolled a %d\n", roll);

            if(roll > 1){
                score += roll;
                System.out.format("Your total is now %d\n", score);
                turnOver = !player.rollAgain();
            }
            else{
                score = 0;
                turnOver = true;
                System.out.println("You forfeit all points and your turn is over");
            }

        } while(!turnOver);

        return score;
    }
}
