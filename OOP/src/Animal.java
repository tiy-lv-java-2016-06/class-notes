/**
 * Created by jeff on 6/20/16.
 */
public abstract class Animal {
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

    public abstract void speak();

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Animal)){
            return false;
        }

        Animal animal = (Animal) o;

        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
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
