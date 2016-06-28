package tiy.week3;

import java.time.Instant;

/**
 * Created by jeff on 6/27/16.
 */
public class Fib {

    public long fib(int number){
        long rval = 0;
        if(number < 1){
            rval = 0;
        }
        else if(number == 1){
            rval = 1;
        }
        else{
            rval = fib(number - 1) + fib(number - 2);
        }

        return rval;
    }

    public static void main(String[] args) throws InterruptedException {
        Fib fib = new Fib();
        long startTime = Instant.now().getEpochSecond();
        System.out.println(fib.fib(44));
        System.out.printf("Took %d", Instant.now().getEpochSecond() - startTime);
    }
}
