package tiy.week3.concurrency;

/**
 * Created by jeff on 6/28/16.
 */
public class Single {

    public void task() throws InterruptedException {
        System.out.println("Doin my task");
        Thread.sleep(1000);
        System.out.println("Done with my task");
    }

    public static void main(String[] args) throws InterruptedException {
        Single single = new Single();
        for(int i = 0; i < 10; i++){
            single.task();
        }
    }
}
