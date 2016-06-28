package tiy.week3.concurrency;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by jeff on 6/28/16.
 */
public class LetsQueue implements Runnable{
    private BlockingQueue<Integer> queue;

    public LetsQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean done = false;

        while(!done || !queue.isEmpty()) {
            System.out.println("I am patiently waiting for a number");
            try {
                System.out.println("I am taking: " + queue.take());
                Thread.sleep(250);
            } catch (InterruptedException e) {
                done = true;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        LetsQueue q = new LetsQueue(queue);
        Thread t = new Thread(q);
        t.start();

        Thread.sleep(1000);

        for(int i = 0; i < 100; i++){
            System.out.println("Adding number: " + i);
            queue.put(i);
            Thread.sleep(100);
        }

        t.interrupt();
    }

}
