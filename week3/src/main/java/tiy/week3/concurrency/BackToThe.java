package tiy.week3.concurrency;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

/**
 * Created by jeff on 6/28/16.
 */
public class BackToThe implements Callable<String>{
    private int timeout = 0;

    public BackToThe(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": We don't need roads");
        Thread.sleep(timeout);
        return Thread.currentThread().getName() + ":Future";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> c1 = new BackToThe(5000);
        Callable<String> c2 = new BackToThe(2000);

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> task1 = service.submit(c1);
        Future<String> task2 = service.submit(c2);


//        FutureTask<String> task1 = new FutureTask<String>(c1);
//        FutureTask<String> task2 = new FutureTask<String>(c2);
//
//        Thread t = new Thread(task1);
//        Thread t2 = new Thread(task2);
//
//        t.start();
//        t2.start();
//
        while(!task1.isDone() || !task2.isDone()){
            System.out.println("Task1: " + (task1.isDone() ? "done" : "running"));
            System.out.println("Task2: " + (task2.isDone() ? "done" : "running"));
            Thread.sleep(100);
        }

        System.out.println(task1.get());
        System.out.println(task2.get());


    }
}
