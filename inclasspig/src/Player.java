import java.util.Scanner;

/**
 * Created by jeff on 6/21/16.
 */
public class Player {
    private String name;
    private Die die;
    private Scanner scanner = new Scanner(System.in);
    private int score = 0;

    public Player(String name){
        this.name = name;
        die = new Die();
    }

    public int addScore(int score){
        this.score += score;
        return this.score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int roll(){
        return this.die.roll();
    }

    public boolean rollAgain(){
        boolean rval = false;
        System.out.println("Do you want to roll again?");
        String choice = scanner.nextLine();

        if(choice.toLowerCase().startsWith("y")){
            rval = true;
        }

        return rval;
    }

}
