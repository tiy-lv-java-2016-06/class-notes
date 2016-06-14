/**
 * Created by jeff on 6/14/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");

        Car mustang = new Car("Ford", "Mustang", "Black", 2007);
        mustang.honkHorn();
        try {
            mustang.addMiles(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
