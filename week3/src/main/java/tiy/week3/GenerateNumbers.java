package tiy.week3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by jeff on 6/28/16.
 */
public class GenerateNumbers {

    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        File f = new File("fibdata.txt");
        FileWriter fw = new FileWriter(f, true);
        fw.write("10\n");

        for(int i = 0; i < 150000; i++){
            int num = rand.nextInt(42) + 1;
            fw.write(num + "\n");
        }

        fw.close();
    }
}
