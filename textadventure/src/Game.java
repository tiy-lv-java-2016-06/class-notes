import java.util.*;

public class Game {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome, traveller");

        Player player = new Player();
        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

        Enemy enemy = new Enemy(20, 10, "Morgoth");
        enemy.battle(player);

        player.addItem(new Item("Potion", "Heals 10 hit points"));
        player.addItem(new Item("Wheel of Cheese", "Heals 20 hit points"));
    }
}
