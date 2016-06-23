package com.theironyard.pig.players;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeff on 6/23/16.
 */
public class Hit24AITest {

    private Hit24AI ai;

    @Before
    public void setup(){
        ai = new Hit24AI("Test");
    }

    @Test
    public void whenRollAgainWith24ThenReturnTrue(){
        boolean again = ai.rollAgain(24);
        assertTrue("AI Should go again with a score of 24", again);
    }

    @Test
    public void whenRollAgainWith25ThenReturnFalse(){
        boolean again = ai.rollAgain(25);
        assertFalse("AI Should stop with a score of 25", again);
    }

}
