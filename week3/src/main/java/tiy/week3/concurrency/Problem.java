package tiy.week3.concurrency;

/**
 * Created by jeff on 6/27/16.
 */
public class Problem implements Runnable {
    private int counter = 0;

    @Override
    public void run() {
        int counter = this.counter;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter += 1;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        Problem p = new Problem();

        for(int i = 0; i < 100; i++){
            Thread t = new Thread(p);
            t.start();
        }

        Thread.sleep(100);
        System.out.println(p.getCounter());
    }
}
