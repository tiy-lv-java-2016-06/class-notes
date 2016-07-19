package gametracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jeff on 7/18/16.
 */
public class ConcurrentModError {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sally");
        names.add("Val");
        names.add("Nigel");
        names.add("Jeff");
        names.add("Eddy");
        names.add("Fred");
        names.add("Sam");

        Iterator<String> namesIter = names.iterator();
        while(namesIter.hasNext()){
            String name = namesIter.next();
            if(name.equals("Sally")){
                namesIter.remove();
            }
        }




    }
}
