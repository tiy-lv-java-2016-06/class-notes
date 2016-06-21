/**
 * Created by jeff on 6/20/16.
 */
public class Cat extends Animal implements Speakable{

    public Cat(String name, String breed, String color) {
        super(name, breed, color);
    }

    @Override
    public void speak() {
        System.out.println("Meow");
    }
}
