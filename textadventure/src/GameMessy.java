import java.util.Scanner;

/**
 * Created by jeff on 6/15/16.
 */
public class GameMessy {

    public static void main(String[] args) throws Exception {
//        String[] items = {"Sword", "Shield", "Healing Potion"};
        System.out.println("Welcome, traveller");
        System.out.println("What is your name foolish traveller?");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Welcome, " + name);

        System.out.println("Choose your weapon [sword/mace]");
        String weapon = scanner.nextLine();

        if(weapon.equalsIgnoreCase("sword")){
            System.out.println("A sword is a fine choice");
        }
        else if(weapon.equalsIgnoreCase("mace")){
            System.out.println("A mace is a stupid weapon");
        }
        else{
            throw new Exception("Invalid Weapon");
        }

        System.out.println("Choose your location [forest/cave]");
        String location = scanner.nextLine();

        if(location.equalsIgnoreCase("forest")){
            System.out.println("Now entering spooky forest...");
        }
        else if(location.equalsIgnoreCase("cave")){
            System.out.println("Now entering dark cave...");
        }
        else{
            throw new Exception("Invalid location");
        }

    }
}
