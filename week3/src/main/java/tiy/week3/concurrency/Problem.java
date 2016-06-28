package tiy.week3.concurrency;

/**
 * Created by jeff on 6/28/16.
 */
public class Problem implements Runnable{
    private int hit = 0;

    public synchronized void increment(){
        int number = this.hit;

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number += 1;
        this.hit = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        increment();
    }

    public int getHit() {
        return hit;
    }

    public static void main(String[] args) throws InterruptedException {
        Problem p = new Problem();

        for(int i =0; i < 100; i++){
            Thread t = new Thread(p);
            t.start();
        }

        Thread.sleep(5000);
        System.out.println(p.getHit());
    }
}
