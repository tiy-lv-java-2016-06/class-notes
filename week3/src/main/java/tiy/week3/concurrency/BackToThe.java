package tiy.week3.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by jeff on 6/27/16.
 */
public class BackToThe implements Callable<String> {
    private int timeout;

    public BackToThe(int timeout){
        this.timeout = timeout;
    }

    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": We don't need roads");
        Thread.sleep(timeout);
        return "Future" + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> list = new ArrayList<>();

        //Create the callables
        Callable<String> b1 = new BackToThe(5000);
        Callable<String> b2 = new BackToThe(1000);

        //Create the new future tasks
        FutureTask<String> task1 = new FutureTask<>(b1);
        FutureTask<String> task2 = new FutureTask<>(b2);

        //Run them
        Thread t = new Thread(task1);
        Thread t2 = new Thread(task2);

        t.start();
        t2.start();

        while(!task1.isDone() || !task2.isDone()){
            System.out.println("Task1: " + (task1.isDone() ? "done" : "running"));
            System.out.println("Task2: " + (task2.isDone() ? "done" : "running"));
            Thread.sleep(100);
        }

        System.out.println(task2.get());
        System.out.println(task1.get());

    }
}
