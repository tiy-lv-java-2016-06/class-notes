package com.theironyard.pig.players;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * Created by jeff on 6/23/16.
 */
public class HumanPlayerTest {

    @Test
    public void whenRollAgainUserChoosesYesThenReturnTrue() throws IOException {
        InputStream in = new ByteArrayInputStream("Yes\n".getBytes());
        //InputStream in = IOUtils.toInputStream("Yes\n", "UTF-8");
        System.setIn(in);
        HumanPlayer player = new HumanPlayer("Test");

        boolean again = player.rollAgain(100);
        assertTrue("Player wants to roll again but method returned false", again);

    }

}
