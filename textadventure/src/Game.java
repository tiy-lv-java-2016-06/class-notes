import java.io.FileNotFoundException;
import java.util.*;

public class Game {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome, traveller");

        Player player = null;
        try{
            player = Player.loadPlayer();
            System.out.println("Player loaded and ready");
        }
        catch (FileNotFoundException e){
            player = new Player();
            System.out.println("Creating new player.");
        }

        if(player.getName() == null){
            player.chooseName();
        }

        if(player.getWeapon() == null) {
            player.chooseWeapon();
        }

        if(player.getLocation() == null) {
            player.chooseLocation();
        }

        Enemy enemy = new Enemy(20, 10, "Morgoth");
        enemy.battle(player);

        player.addItem(new Item("Potion", "Heals 10 hit points"));
        player.addItem(new Item("Wheel of Cheese", "Heals 20 hit points"));

        player.savePlayer();
    }
}
