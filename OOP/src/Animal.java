/**
 * Created by jeff on 6/20/16.
 */
public class Animal {
    private String name;
    private String breed;
    private String color;

    public Animal(String name, String breed, String color){
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public void speak(){
        System.out.println("** Sits quietly **");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Animal)){
            return false;
        }

        Animal animal = (Animal) o;

        if (name != null){
            if(!name.equals(animal.name)){
                return false;
            }
            else if(animal.name != null){
                return false;
            }
        }
        int number = 0;
        if(number % 2 == 0){
            System.out.println("I am even");
        }
        else{
            System.out.println("I am odd");
        }

        number % 2 == 0 ? System.out.println("I am even") : System.out.println("I am odd")

        if (breed != null ? !breed.equals(animal.breed) : animal.breed != null) return false;
        return color != null ? color.equals(animal.color) : animal.color == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "Animal{" + getColor()+ " " + getBreed() + " named " + getName() + "}";
    }
}
