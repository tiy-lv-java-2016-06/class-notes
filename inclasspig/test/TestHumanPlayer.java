import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by jeff on 6/22/16.
 */
public class TestHumanPlayer {

    @Test
    public void testChoice(){
        InputStream in = new ByteArrayInputStream("Yes\n".getBytes());
        System.setIn(in);

        HumanPlayer player = new HumanPlayer("Test");
        assertTrue(player.rollAgain(10));
    }

    @Test
    public void testNo(){
        InputStream in = new ByteArrayInputStream("No\n".getBytes());
        System.setIn(in);

        HumanPlayer player = new HumanPlayer("Test");
        assertFalse(player.rollAgain(10));
    }
}
