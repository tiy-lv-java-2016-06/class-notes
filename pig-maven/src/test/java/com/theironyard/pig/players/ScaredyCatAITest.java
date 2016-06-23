package com.theironyard.pig.players;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by jeff on 6/23/16.
 */
public class ScaredyCatAITest {

    private ScaredyCatAI ai;

    @Before
    public void setup(){
        ai = new ScaredyCatAI("Test");
    }

    @Test
    public void whenRollAgainThenReturnFalse(){
        boolean again = ai.rollAgain(100);

        assertFalse("Should return false but returned true", again);
    }

    @Test
    public void whenAddScoreThenScoreAdded(){
        ai.setScore(0);

        int newScore = ai.addScore(10);

        assertEquals("Score not returned correctly", 10, newScore);
        assertEquals("Score not updated correctly in class", 10, ai.getScore());
    }
}
