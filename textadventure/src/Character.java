/**
 * Created by jeff on 6/21/16.
 */
public class Character {
    private String name;
    private int health;
    private int damage;

    public Character(int health, int damage) {
        this.damage = damage;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void battle(Character foe){

        System.out.format("%s appears!\n", foe.getName());

        while (health > 0 && foe.health > 0){
            health -= foe.damage;
            foe.health -= damage;
            System.out.printf("%s's health: %d\n", name, health);
            System.out.printf("%s's health: %d\n", foe.getName(), foe.getHealth());
        }

        String message = "%s has died.\n";

        if(health <= 0){
            System.out.format(message, name);
        }

        if(foe.health <= 0){
            System.out.format(message, foe.getName());
        }

    }
}
