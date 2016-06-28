package tiy.week3.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jeff on 6/28/16.
 */
public class Executioner implements Runnable{

    private int timeout;

    public Executioner(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +  ": Running my butt off");
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println(Thread.currentThread().getName() +  ": All Done");
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Executioner(5000));
        service.submit(new Executioner(2000));

        service.shutdown();
    }
}
