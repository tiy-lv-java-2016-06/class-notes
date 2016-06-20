/**
 * Created by jeff on 6/20/16.
 */
public class Dog extends Animal {

    public Dog(String name, String breed, String color) {
        super(name, breed, color);
    }

    @Override
    public void speak(){
        System.out.println("Woof Woof!!!!");
    }

    public void sit(){
        System.out.println("** Sits **");
    }

    @Override
    public String toString(){
        return "Dog{" + getColor()+ " " + getBreed() + " named " + getName() + "}";
    }

}
