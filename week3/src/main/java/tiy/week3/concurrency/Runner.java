package tiy.week3.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeff on 6/28/16.
 */
public class Runner implements Runnable {
    private int timeout = 0;

    public Runner(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Doin my task");
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": Done with my task");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new Runner(3000));
        Thread t2 = new Thread(new Runner(1000));
        Thread t3 = new Thread(new Runner(2000));

        t1.start();
        t2.start();
        t3.start();

    }
}
