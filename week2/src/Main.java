/**
 * Created by jeff on 6/23/16.
 */
public class Main {
    public static void main(String[] args) {
        for(Suit s : Suit.values()){
            System.out.println(s);
        }

        for(Rank r : Rank.values()){
            System.out.format("%s has a value of %d\n", r, r.getValue());
        }

    }
}
