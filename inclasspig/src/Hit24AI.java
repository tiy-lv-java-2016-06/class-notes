/**
 * Created by jeff on 6/22/16.
 */
public class Hit24AI extends AbstractPlayer{


    public Hit24AI(String name) {
        super(name);
    }

    @Override
    public boolean rollAgain(int turnScore) {
        boolean rval = false;
        if (turnScore < 25){
            rval = true;
        }

        return rval;
    }
}
