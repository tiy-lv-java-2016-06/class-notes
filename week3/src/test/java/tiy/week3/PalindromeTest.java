package tiy.week3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeff on 6/27/16.
 */
public class PalindromeTest {

    @Test
    public void whenIsPalindromeTrueThenReturnTrue(){
        assertTrue(Palindrome.isPalindrome("racecar"));
    }

    @Test
    public void whenIsPalindromeFalseThenReturnFalse(){
        assertFalse(Palindrome.isPalindrome("foobar"));
    }

    @Test
    public void whenIsPalindromeRecTrueThenReturnTrue(){
        assertTrue(Palindrome.isPalindromeRec("racecar"));
    }

    @Test
    public void whenIsPalindromeRecFalseThenReturnFalse(){
        assertFalse(Palindrome.isPalindromeRec("foobar"));
    }

}
