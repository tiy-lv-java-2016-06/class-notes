package tiy.week3.concurrency;

/**
 * Created by jeff on 6/27/16.
 */
public class Threadable implements Runnable {
    private int timeout;

    public Threadable(int timeout) {
        this.timeout = timeout;
    }

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
        Thread t1 = new Thread(new Threadable(5000));
        Thread t2 = new Thread(new Threadable(1000));

        t1.start();
        t2.start();
    }
}
