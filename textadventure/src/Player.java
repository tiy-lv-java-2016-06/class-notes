import java.util.Scanner;

/**
 * Created by jeff on 6/15/16.
 */
public class Player {
    private String name;
    private String weapon;
    private String location;
    private Scanner scanner = new Scanner(System.in);

    public String getName(){
        return this.name;
    }

    public String getWeapon(){
        return this.weapon;
    }

    public String getLocation(){
        return this.location;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWeapon(String weapon){
        this.weapon = weapon;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void chooseName(){
        System.out.println("What is your name foolish traveller?");


        String name = scanner.nextLine();

        System.out.println("Welcome, " + name);
    }

    public void chooseWeapon() throws Exception {
        String weapon = null;

        while(weapon == null) {
            System.out.println("Choose your weapon [sword/mace]");
            weapon = scanner.nextLine();

            if (weapon.equalsIgnoreCase("sword")) {
                System.out.println("A sword is a fine choice");
            } else if (weapon.equalsIgnoreCase("mace")) {
                System.out.println("A mace is a stupid weapon");
            }
            else{
                weapon = null;
            }
        }

        this.weapon = weapon;


    }

    public void chooseLocation() throws Exception {
        String message = null;
        do {
            System.out.println("Choose your location [forest/cave]");
            String location = scanner.nextLine();

            if (location.equalsIgnoreCase("forest")) {
                message = "Now entering spooky forest...";
            } else if (location.equalsIgnoreCase("cave")) {
                message = "Now entering dark cave...";
            }
        }while(message == null);
        System.out.println(message);
    }
}
