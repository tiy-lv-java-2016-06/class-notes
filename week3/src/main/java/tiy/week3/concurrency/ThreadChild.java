package tiy.week3.concurrency;

/**
 * Created by jeff on 6/28/16.
 */
public class ThreadChild extends Thread{

    @Override
    public void run() {
        System.out.println("Doin my task");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with my task");
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadChild();
        Thread t2 = new ThreadChild();
        Thread t3 = new ThreadChild();

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main method done");
    }
}
