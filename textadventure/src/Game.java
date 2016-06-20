import java.util.*;

public class Game {

    public static void main(String[] args) throws Exception {
        
        System.out.println("Welcome, traveller");

        Player player = new Player();
        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

        player.addItem(new Item("Potion", "Heals 10 hit points"));
        player.addItem(new Item("Wheel of Cheese", "Heals 20 hit points"));
    }
}
