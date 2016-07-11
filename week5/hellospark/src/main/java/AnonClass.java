/**
 * Created by jeff on 7/11/16.
 */
public class AnonClass {

    public static void main(String[] args) {

        Reptile alligator = new Reptile() {
            @Override
            public void makeSound() {
                System.out.println("Croak");
            }
        };


        Object foo = new Object(){
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
