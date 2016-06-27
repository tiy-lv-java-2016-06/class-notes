package tiy.week3;

/**
 * Created by jeff on 6/27/16.
 */
public class Palindrome {

    /**
     * Iterative approach to solving.  Loop through and move the current index testing the
     * position from the front and rear.
     * @param input
     * @return if the string is a legit palidrome
     */
    public static boolean isPalindrome(String input){
        boolean rval = true;

        int front = 0;
        int back = input.length() - 1;

        while(front < back && rval){
            if(input.charAt(front) != input.charAt(back)){
                rval = false;
            }
            front++;
            back--;
        }
        return rval;
    }

    /**
     * Recursive palindrome test. Keeps recursively calling with a substring (minus
     * first and last letters) until it fails or has less than 2 characters.
     * @param input
     * @return
     */
    public static boolean isPalindromeRec(String input){
        boolean rval;
        int len = input.length();

        if(input.length() <= 1){
            rval = true;
        }
        else if(input.charAt(0) != input.charAt(len - 1)){
            rval = false;
        }
        else{
            rval = isPalindromeRec(input.substring(1, len - 1));
        }

        return rval;
    }
}
