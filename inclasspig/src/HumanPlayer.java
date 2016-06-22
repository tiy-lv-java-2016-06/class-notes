import java.util.Scanner;

/**
 * Created by jeff on 6/21/16.
 */
public class HumanPlayer extends AbstractPlayer {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name){
        super(name);
    }

    @Override
    public boolean rollAgain(int turnScore){
        boolean rval = false;
        System.out.println("Do you want to roll again?");
        String choice = scanner.nextLine();

        if(choice.toLowerCase().startsWith("y")){
            rval = true;
        }

        return rval;
    }

}
