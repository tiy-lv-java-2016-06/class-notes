import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeff on 6/15/16.
 */
public class Player extends Character{
    private String weapon;
    private String location;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Item> items = new ArrayList<>();
    private static final String SAVEFILE = "player.json";

    /**
     * Sets heath to 500 and damage to 30
     */
    public Player(){
        super(500, 30);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Finds an item in the item list with a given name
     * @param name name of item to find
     * @return ArrayList of all items that are found
     */
    public ArrayList<Item> findItem(String name){
        ArrayList<Item> rval = null;

        for(Item item : this.items){
            if(item.getName().equalsIgnoreCase(name)){
                rval.add(item);
            }
        }

        return rval;
    }

    public String getWeapon(){
        return this.weapon;
    }

    public String getLocation(){
        return this.location;
    }

    public void setWeapon(String weapon){
        this.weapon = weapon;
    }

    public void setLocation(String location){
        this.location = location;
    }

    /**
     * Prompts user to enter a name
     */
    public void chooseName(){
        System.out.println("What is your name foolish traveller?");


        setName(scanner.nextLine());

        System.out.println("Welcome, " + getName());
    }

    /**
     * Prompts user to choose a weapon [sword/mace] until they enter it correctly
     * @throws Exception For some unknown condition
     */
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
            location = scanner.nextLine();

            if (location.equalsIgnoreCase("forest")) {
                message = "Now entering spooky forest...";
            } else if (location.equalsIgnoreCase("cave")) {
                message = "Now entering dark cave...";
            }
        } while(message == null);

        System.out.println(message);
    }

    public void savePlayer() {
        File saveFile = new File(SAVEFILE);
        JsonSerializer serializer = new JsonSerializer();
        String playerJson = serializer.include("*").serialize(this);

        try {
            FileWriter fw = new FileWriter(saveFile);
            fw.write(playerJson);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player loadPlayer() throws FileNotFoundException {
        File loadFile = new File(SAVEFILE);
        Scanner scanner = new Scanner(loadFile);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();

        JsonParser parser = new JsonParser();
        Player player = parser.map("items", ArrayList.class).parse(contents, Player.class);

        return player;

    }
}
