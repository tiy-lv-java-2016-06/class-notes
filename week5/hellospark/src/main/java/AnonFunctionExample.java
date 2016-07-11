/**
 * Created by jeff on 7/11/16.
 */
public class AnonFunctionExample {

    public static void main(String[] args) {
        sayHello();

        Runnable oldSchool = new RunnableRefresh();
        oldSchool.run();

        Runnable r2 = () -> {
           System.out.println("Hello from a lambda!");
        };
        r2.run();

    }

    static void sayHello(){
        System.out.println("Hello from a method!");
    }
}
