import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeff on 6/20/16.
 */
public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Speakable> talkers = new ArrayList<>();

        Dog dog = new Dog("Spot", "Dalmation", "White");
        dog.speak();
        animals.add(dog);

        Cat cat = new Cat("Evil", "Tabby", "Grey like its soul");
        cat.speak();
        animals.add(cat);

        for(Animal animal : animals){
            System.out.println(animal);
        }
    }


}
