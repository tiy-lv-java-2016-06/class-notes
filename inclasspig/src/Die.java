import java.util.Random;

/**
 * Created by jeff on 6/21/16.
 */
public class Die {
    Random random = new Random();

    public int roll(){
        return random.nextInt(6) + 1;
    }

}
