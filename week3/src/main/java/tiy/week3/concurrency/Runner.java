package tiy.week3.concurrency;

/**
 * Created by jeff on 6/27/16.
 */
public class Runner extends Thread{
    private int timeout;

    public Runner(int timeout) {
        super();
        this.timeout = timeout;
    }

    @Override
    public void run() {
        System.out.println("About to sleep...yawns " + Thread.currentThread().getName());
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("I am awake "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runner task = new Runner(5000);
        Runner task2 = new Runner(1000);

        task.start();
        task2.start();

        System.out.println("Threads started");

    }
}
