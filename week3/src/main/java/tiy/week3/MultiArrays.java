package tiy.week3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jeff on 6/30/16.
 */
public class MultiArrays {

    public static void main(String[] args) {
        int[] num = new int[5];

        for(int i = 0; i < 5; i++){
            num[i] = i;
        }

        for(int foo : num){
            System.out.println(foo);
        }


        int[][] nums = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                nums[i][j] = i + j;
            }
        }

//        HashMap<Integer, ArrayList<Integer>> foo = new HashMap<>();
//
//        foo.get(0).get(0);

        return;
    }




}
